/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.mihosoft.geneticai;

import com.thoughtworks.xstream.XStream;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

/**
 *
 * @author Michael Hoffer <info@michaelhoffer.de>
 */
public class GenIO {

    public static String saveGeneration(Generation g) {
        XStream xstream = new XStream();
        defineAliases(xstream);

        return xstream.toXML(g);
    }

    public static Generation loadGeneration(String s) {
        XStream xstream = new XStream();
        defineAliases(xstream);

        return (Generation) xstream.fromXML(s);
    }

    public static Generation loadGeneration(Path p) throws IOException {

        StringBuilder sBuilder = new StringBuilder();

        for (String l : Files.readAllLines(p, StandardCharsets.UTF_8)) {
            sBuilder.append(l).append("\n");
        }

        return loadGeneration(sBuilder.toString());
    }

    public static void saveGeneration(Path p, Generation g) throws IOException {
        try (BufferedWriter br = Files.newBufferedWriter(p,
                Charset.forName("UTF-8"),
                new OpenOption[]{StandardOpenOption.WRITE,
                    StandardOpenOption.CREATE})) {
            br.append(saveGeneration(g));

            br.flush();
        }
    }

    public static void defineAliases(XStream xstream) {
        xstream.alias("simplegeneration", SimpleGeneration.class);
        xstream.alias("simplechromosome", SimpleChromosome.class);
        xstream.alias("simplegene", SimpleGene.class);
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.mihosoft.geneticai;

import java.util.Random;

/**
 *
 * @author Michael Hoffer <info@michaelhoffer.de>
 */
public class Rand {

    private static final Random random = new Random();
    
    static final String LOWERCASE_LETTERS = "abcdefghijklmnopqrstuvwxyz";
    static final String UPPERCASE_LETTERS = LOWERCASE_LETTERS.toUpperCase();
    static final String NUMBERS = "0123456789";
    static final String WHITESPACES = " \t";
    static final String NEWLINE = " \n";
    static final String ALPHA_NUMERICAL = LOWERCASE_LETTERS + UPPERCASE_LETTERS + NUMBERS;
    static final String ALPHA_NUMERICAL_AND_WHITESPACES_AND_NEWLINE = ALPHA_NUMERICAL + WHITESPACES + NEWLINE;
    

    static double randFloat(double min, double max) {
        return min + random.nextDouble() * (max - min);
    }

    static double randFloat() {
        return random.nextDouble();
    }

    static int randInt(int min, int max) {
        return min + random.nextInt(max - min + 1);
    }

    static int randInt() {
        return random.nextInt(1);
    }

    static String randString(String characters, int length) {
        char[] text = new char[length];
        for (int i = 0; i < length; i++) {
            text[i] = characters.charAt(random.nextInt(characters.length()));
        }
        return new String(text);
    }

    public static void srand(long seed) {
        random.setSeed(seed);
    }

    public static Object randByType(Object min, Object max) {

        Object val = null;

//        System.out.print(">> min: " + min + ", max: " + max);

        if (min instanceof Integer && max instanceof Integer) {
            val = randInt((Integer) min, (Integer) max);
        } else if (min instanceof Double || max instanceof Double) {
            val = randFloat((Double) min, (Double) max);
        } else {
            //
        }

//        System.out.println(", val: " + val);

        return val;
    }
}

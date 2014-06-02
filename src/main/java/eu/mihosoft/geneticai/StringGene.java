/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.mihosoft.geneticai;

/**
 *
 * @author Michael Hoffer <info@michaelhoffer.de>
 */
public class StringGene extends SimpleGene<String> {

    private int size;
    private String alphabet = Rand.ALPHA_NUMERICAL_AND_WHITESPACES_AND_NEWLINE;

    public StringGene(int size) {
        this.size = size;
    }
    
    public void setAlphabet(String alphabet) {
        this.alphabet = alphabet;
    }

    @Override
    public void randomInit() {
        setData(Rand.randString(alphabet, size));
    }

    @Override
    public Gene copy() {

        StringGene copy = new StringGene(size);

        String copyData = null;

        copyData = super.getData();
        copy.setData(copyData);
        copy.setAlphabet(alphabet);

        return copy;
    }

    @Override
    public String toString() {
        return getData();
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.mihosoft.geneticai;

/**
 *
 * @author Michael Hoffer <info@michaelhoffer.de>
 */
public interface Generation {
    public Chromosome<?>[] getChromosomes();
    public void setChromosomes(Chromosome<?>[] chromosomes);
    public void randomInit(Chromosome<?> prototype);
//    public Generation copy();
    public Chromosome<?> getFittest();
}

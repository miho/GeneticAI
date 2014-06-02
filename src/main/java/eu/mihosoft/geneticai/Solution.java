/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.mihosoft.geneticai;

/**
 *
 * @author Michael Hoffer <info@michaelhoffer.de>
 */
public interface Solution {
    public int getGeneration();
    public Chromosome<?> getChromosome();
    public boolean isOptimal();
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.mihosoft.geneticai;

/**
 *
 * @author Michael Hoffer <info@michaelhoffer.de>
 */
public interface Chromosome<T> {
    public double getFitness();
    public void setFitness(double fitness);
    public Gene<T>[] getGenes();
    public void setGene(int i, Gene<T> g);
//    public void setGenes(Gene<T>[] genes);
    public void randomInit();
    public Chromosome<T> copy();
}

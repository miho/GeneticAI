/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.mihosoft.geneticai;

/**
 *
 * @author Michael Hoffer <info@michaelhoffer.de>
 */
public class SimpleChromosome<T> implements Chromosome {
    private Gene<T>[] genes;
    private double fitness;

    public SimpleChromosome(Gene<T>... genes) {
        this.genes = genes;
    }
    
    @Override
    public Gene<T>[] getGenes() {
        return genes;
    }

    @Override
    public double getFitness() {
        return this.fitness;
    }
    
    @Override
    public void setFitness(double fitness) {
        this.fitness = fitness;
    }

    @Override
    public void randomInit() {
        for (Gene gene : genes) {
            gene.randomInit();
        }
    }

    @Override
    public Chromosome copy() {
        
        Gene[] copyGenes = new Gene[genes.length];
        
        SimpleChromosome copy = new SimpleChromosome(copyGenes);
        
        for(int i = 0; i < genes.length;i++) {
            copyGenes[i] = genes[i].copy();
        }
        
        copy.fitness = fitness;
        
        return copy;
    }

//    @Override
//    public void setGenes(Gene<T>[] genes) {
//        this.genes = genes;
//    }

    @Override
    public void setGene(int i, Gene g) {
        genes[i] = g;
    }

    @Override
    public String toString() {
        String s = "";
        
        for (Gene<T> gene : genes) {
            s += gene.getData().toString() + " ";
        }
        
        return s;
    }
}

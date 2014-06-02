/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.mihosoft.geneticai;

/**
 *
 * @author Michael Hoffer <info@michaelhoffer.de>
 */
class SolutionImpl implements Solution {

    private int generation;
    private Chromosome<?> c;
    private boolean optimal;

    public SolutionImpl(int generation, boolean optimal, Chromosome<?> c) {
        this.generation = generation;
        this.optimal = optimal;
        this.c = c;
    }

    @Override
    public int getGeneration() {
        return this.generation;
    }

    @Override
    public Chromosome<?> getChromosome() {
        return this.c;
    }

    @Override
    public String toString() {
        return "generation: " + getGeneration() + ", optimal: " + isOptimal() + ", fitness: " + c.getFitness() + " , solution: " + getChromosome();
    }

    @Override
    public boolean isOptimal() {
        return optimal;
    }
}

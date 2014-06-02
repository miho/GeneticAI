/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.mihosoft.geneticai;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Michael Hoffer <info@michaelhoffer.de>
 */
public class SimpleEvolution implements Evolution {

    private Generation oldGeneration;
    private Generation newGeneration;
    private Generation finalGeneration;
    private double oldFitness = 1;
    private double rate = 0;
    private Breeder breeder;
    private boolean showOutput;
    
    private int generationCounter;

    public SimpleEvolution(Breeder b) {
        this.breeder = b;
    }

    public SimpleEvolution(Evaluator<?> e) {
        this.breeder = new SimpleBreeder(e);
        this.breeder.addChromosomeOperator(new MutationOperator());
        this.breeder.addBreedingOperator(new CrossOverAndSelectOperator());
    }

    @Override
    public Solution evolve(Generation prototype, int maxIter) {

        if (breeder == null) {
            throw new IllegalStateException("Cannot evolve: no breeder defined!");
        }

        oldGeneration = prototype;
        newGeneration = new SimpleGeneration(prototype.getChromosomes().length);

        finalGeneration = newGeneration;

        Chromosome<?> posibleSolution = prototype.getFittest();

        generationCounter = 0;

        for (int i = 0; i < maxIter; i++) {
            generationCounter++;
            getBreeder().breed(oldGeneration, newGeneration);
            finalGeneration = newGeneration;
            Generation swap = newGeneration;
            newGeneration = oldGeneration;
            oldGeneration = swap;

            posibleSolution = finalGeneration.getFittest();

            computeConvRate(posibleSolution);

            if (getBreeder().getEvaluator().accept(posibleSolution,finalGeneration)) {
                return new SolutionImpl(getGenerationCounter(), true, posibleSolution);
            }
        }

        return new SolutionImpl(getGenerationCounter(), false, posibleSolution);
    }

    private void computeConvRate(Chromosome<?> posibleSolution) {
        double r = posibleSolution.getFitness() / oldFitness;
        oldFitness = posibleSolution.getFitness();

        if (!Double.isNaN(r) && !Double.isInfinite(r)) {
            rate = r;

            if (showOutput) {
                System.out.println(">> rate: " + r);
            }
        }
    }

    @Override
    public double getRate() {
        return rate;
    }

    /**
     * @return the breeder
     */
    @Override
    public Breeder getBreeder() {
        return breeder;
    }

    /**
     * @param breeder the breeder to set
     */
    @Override
    public void setBreeder(Breeder breeder) {
        this.breeder = breeder;
    }

    /**
     * @return the showOutput
     */
    public boolean isShowOutput() {
        return showOutput;
    }

    /**
     * @param showOutput the showOutput to set
     */
    public void setShowOutput(boolean showOutput) {
        this.showOutput = showOutput;
    }

    /**
     * @return the generationCounter
     */
    public int getGenerationCounter() {
        return generationCounter;
    }
}

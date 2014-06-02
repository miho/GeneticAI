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
public class SimpleBreeder implements Breeder {

    private Evaluator evaluator;
    private List<ChromosomeOperator> chromosomeOperators = new ArrayList<>();
    private List<BreedingOperator> generationOperators = new ArrayList<>();

    public SimpleBreeder(Evaluator e) {
        this.evaluator = e;
    }

    @Override
    public void breed(Generation gOld, Generation gNew) {

        for (BreedingOperator gO : generationOperators) {
            gO.apply(gOld, gNew);
        }

        for (ChromosomeOperator cO : chromosomeOperators) {
            for (Chromosome<?> c : gNew.getChromosomes()) {
                cO.apply(c);
            }
        }

        for (Chromosome<?> c : gNew.getChromosomes()) {
            c.setFitness(0);
            getEvaluator().evaluate(c, gNew);
        }

    }

    @Override
    public void addChromosomeOperator(ChromosomeOperator o) {
        this.chromosomeOperators.add(o);
    }

    @Override
    public void addBreedingOperator(BreedingOperator o) {
        this.generationOperators.add(o);
    }

    /**
     * @return the evaluator
     */
    @Override
    public Evaluator getEvaluator() {
        return evaluator;
    }

    @Override
    public void setChromosomeOperator(ChromosomeOperator<?> o) {
        this.chromosomeOperators.clear();
        this.chromosomeOperators.add(o);
    }

    @Override
    public void setBreedingOperator(BreedingOperator o) {
        this.generationOperators.clear();
        this.generationOperators.add(o);
    }
}

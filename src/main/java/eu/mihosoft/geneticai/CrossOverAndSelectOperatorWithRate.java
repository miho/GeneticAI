/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.mihosoft.geneticai;

/**
 *
 * @author Michael Hoffer <info@michaelhoffer.de>
 */
public class CrossOverAndSelectOperatorWithRate extends CrossOverAndSelectOperator {

    private final Evolution evolution;
    private final Chromosome<?> prototype;
    private int countZeroRate = 0;
    private boolean showOutput;
    
     public CrossOverAndSelectOperatorWithRate(Evolution evolution, Chromosome<?> prototype) {
        this.evolution = evolution;
        this.prototype = prototype;
        this.showOutput = showOutput;
    }

    public CrossOverAndSelectOperatorWithRate(Evolution evolution, Chromosome<?> prototype, boolean showOutput) {
        this.evolution = evolution;
        this.prototype = prototype;
        this.showOutput = showOutput;
    }

    @Override
    public void apply(Generation src, Generation dst) {

        if (evolution.getRate() < 1) {
            countZeroRate++;
        } else {
            countZeroRate = 0;
        }

        Chromosome<?> best = src.getFittest();

        if (countZeroRate < 10) {
            super.apply(src, dst);
            for (int i = 0; i < 3; i++) {
                dst.getChromosomes()[Rand.randInt(0, dst.getChromosomes().length - 1)] = best.copy();
            }

        } else {
            if (this.showOutput) {
                System.out.println("reset generation");
            }
            Rand.srand(System.nanoTime());
            countZeroRate = 0;
            dst.randomInit(prototype);
            for (int i = 0; i < 10; i++) {
                dst.getChromosomes()[Rand.randInt(0, dst.getChromosomes().length - 1)] = best.copy();
            }
        }
    }
}
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.mihosoft.geneticai;

/**
 *
 * @author Michael Hoffer <info@michaelhoffer.de>
 */
public class MutationOperator implements ChromosomeOperator<Integer> {

    private double mutationRate = 0.015;

    public MutationOperator() {
    }

    public MutationOperator(double mutationRate) {
        this.mutationRate = mutationRate;
    }

    @Override
    public Chromosome<Integer> apply(Chromosome<Integer> src) {
        Chromosome<Integer> result = src;
        
        for (int i = 0; i < result.getGenes().length; i++) {

            boolean mutate = Rand.randFloat() < getMutationRate();
            if (mutate) {

                result.getGenes()[i].randomInit();
            }
        }

        return result;
    }

    /**
     * @return the mutationRate
     */
    public double getMutationRate() {
        return mutationRate;
    }

    /**
     * @param mutationRate the mutationRate to set
     */
    public void setMutationRate(double mutationRate) {
        this.mutationRate = mutationRate;
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.mihosoft.geneticai;

/**
 *
 * @author Michael Hoffer <info@michaelhoffer.de>
 */
public class CrossOverAndSelectOperator implements BreedingOperator {

    private double crossoverRate = 0.7;
    private double mixRate = 0.5;

    public CrossOverAndSelectOperator() {
    }

    public CrossOverAndSelectOperator(double crossoverRate, double mixRate) {
        this.crossoverRate = crossoverRate;
        this.mixRate = mixRate;
    }

    private Chromosome<?> choose(Generation src) {

        int tournamentSize = Math.max(src.getChromosomes().length / 20, 2);
        Generation tournament = new SimpleGeneration(tournamentSize);

        for (int i = 0; i < tournamentSize; i++) {
            int randomId = (int) (Math.random() * (src.getChromosomes().length));
            tournament.getChromosomes()[i] = src.getChromosomes()[randomId];
        }

        Chromosome<?> fittest = tournament.getFittest();

        return fittest;
    }

    public Chromosome<?> crossover(Chromosome<?> first, Chromosome<?> second) {

        Chromosome<?> result = first.copy();

        boolean crossOver = Rand.randFloat() < getCrossoverRate();

        if (crossOver) {
            for (int i = 0; i < first.getGenes().length; i++) {
                boolean mix = Rand.randFloat() < getMixRate();

                if (mix) {
                    Gene g = second.getGenes()[i].copy();
                    result.setGene(i, g);
                }
            }
        }

        return result;
    }

    @Override
    public void apply(Generation src, Generation dst) {

        for (int i = 0; i < src.getChromosomes().length; i++) {
            Chromosome<?> newChromosome;

            Chromosome<?> first = choose(src);
            Chromosome<?> second = choose(src);

            newChromosome = crossover(first, second);

            dst.getChromosomes()[i] = newChromosome;
        }
    }

    /**
     * @return the crossoverRate
     */
    public double getCrossoverRate() {
        return crossoverRate;
    }

    /**
     * @param crossoverRate the crossoverRate to set
     */
    public void setCrossoverRate(double crossoverRate) {
        this.crossoverRate = crossoverRate;
    }

    /**
     * @return the crossoverRate
     */
    public double getMixRate() {
        return mixRate;
    }

    /**
     * @param crossoverRate the crossoverRate to set
     */
    public void setMixRate(double mixRate) {
        this.mixRate = mixRate;
    }
}
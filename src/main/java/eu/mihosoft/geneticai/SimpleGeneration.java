/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.mihosoft.geneticai;

/**
 *
 * @author Michael Hoffer <info@michaelhoffer.de>
 */
public class SimpleGeneration implements Generation {

    Chromosome<?>[] chromosomes;

    public SimpleGeneration(int size) {
        chromosomes = new Chromosome[size];
    }

    @Override
    public Chromosome<?>[] getChromosomes() {
        return chromosomes;
    }

    @Override
    public void setChromosomes(Chromosome<?>[] chromosomes) {
        this.chromosomes = chromosomes;
    }

    @Override
    public void randomInit(Chromosome<?> prototype) {
        for (int i = 0; i < chromosomes.length; i++) {
            chromosomes[i] = prototype.copy();
            chromosomes[i].randomInit();
        }
    }

//    @Override
//    public Generation copy() {
//        Generation copy = new SimpleGeneration(chromosomes.length);
//        
//        for (int i = 0; i < chromosomes.length;i++) {
//            copy.getChromosomes()[i] = chromosomes[i].copy();
//        }
//        
//        return copy;
//    }
    @Override
    public Chromosome<?> getFittest() {

       Chromosome<?> result = getChromosomes()[0];

        for (Chromosome<?> c : getChromosomes()) {
            if (c.getFitness() > result.getFitness()) {
                result = c;
            }
        }

        return result;

    }
}

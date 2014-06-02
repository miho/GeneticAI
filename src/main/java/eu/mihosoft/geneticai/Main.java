/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.mihosoft.geneticai;

/**
 *
 * @author Michael Hoffer <info@michaelhoffer.de>
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        integerEvolution01(10);
        integerEvolution01(100);
        integerEvolution01(200);

        stringEvolution01("AABBCCDDABAC", 2, null);
        stringEvolution01("Hello", 1, null);
        stringEvolution01("Hello World", 1, null);
        stringEvolution01("Genetic Algorithms", 1, null);
    }

    private static void stringEvolutionWithoutRate01(final String solutionString, int subGeneLength, String alphabet) {

        Gene<String>[] genes = new Gene[solutionString.length() / subGeneLength];

        for (int i = 0; i < genes.length; i++) {
            StringGene g = new StringGene(subGeneLength);
            if (alphabet != null && !alphabet.isEmpty()) {
                g.setAlphabet(alphabet);
            }
            genes[i] = g;
        }

        final Chromosome<String> prototype = new SimpleChromosome<>(genes);

        Generation protoGeneration = new SimpleGeneration(100);
        protoGeneration.randomInit(prototype);

        Evaluator<String> e = new Evaluator<String>() {
            @Override
            public void evaluate(Chromosome<String> c, Generation g) {

                double fitness = 0;

                for (int j = 0; j < c.getGenes().length; j++) {

                    String s = c.getGenes()[j].getData();

                    for (int i = 0; i < s.length(); i++) {
                        if (solutionString.charAt(j * s.length() + i)
                                == s.charAt(i)) {
                            fitness += 5;
                        } else {
                            fitness -= 2;
                        }
                    }
                }

                fitness = Math.max(0, fitness);

                c.setFitness(fitness);
            }

            @Override
            public boolean accept(Chromosome<String> c, Generation g) {
                return c.getFitness() == solutionString.length() * 5;
            }
        };

        final Evolution evolution = new SimpleEvolution(e);

        evolution.getBreeder().setBreedingOperator(
                new CrossOverAndSelectOperator());

        int maxIter = 1000000;

        Solution solution = evolution.evolve(protoGeneration, maxIter);

        System.out.println(solution);
    }
    
    private static void stringEvolution01(final String solutionString, int subGeneLength, String alphabet) {

        Gene<String>[] genes = new Gene[solutionString.length() / subGeneLength];

        for (int i = 0; i < genes.length; i++) {
            StringGene g = new StringGene(subGeneLength);
            if (alphabet != null && !alphabet.isEmpty()) {
                g.setAlphabet(alphabet);
            }
            genes[i] = g;
        }

        final Chromosome<String> prototype = new SimpleChromosome<>(genes);

        Generation protoGeneration = new SimpleGeneration(100);
        protoGeneration.randomInit(prototype);

        Evaluator<String> e = new Evaluator<String>() {
            @Override
            public void evaluate(Chromosome<String> c, Generation g) {

                double fitness = 0;

                for (int j = 0; j < c.getGenes().length; j++) {

                    String s = c.getGenes()[j].getData();

                    for (int i = 0; i < s.length(); i++) {
                        if (solutionString.charAt(j * s.length() + i)
                                == s.charAt(i)) {
                            fitness += 5;
                        } else {
                            fitness -= 2;
                        }
                    }
                }

                fitness = Math.max(0, fitness);

                c.setFitness(fitness);
            }

            @Override
            public boolean accept(Chromosome<String> c, Generation g) {
                return c.getFitness() == solutionString.length() * 5;
            }
        };

        final Evolution evolution = new SimpleEvolution(e);

        evolution.getBreeder().setBreedingOperator(
                new CrossOverAndSelectOperatorWithRate(evolution, prototype));

        int maxIter = 1000000;

        Solution solution = evolution.evolve(protoGeneration, maxIter);

        System.out.println(solution);
    }

    private static void integerEvolution01(int size) {
        
        Gene<Integer>[] genes = new Gene[size];

        for (int i = 0; i < genes.length; i++) {
            Gene<Integer> g = new SimpleGene<>();
            g.setRange(0, 10);
            genes[i] = g;
        }

        Chromosome<Integer> prototype = new SimpleChromosome<>(genes);

        Generation gOld = new SimpleGeneration(100);
        gOld.randomInit(prototype);

        Evaluator<Integer> e = new Evaluator<Integer>() {
            @Override
            public void evaluate(Chromosome<Integer> c, Generation g) {
                for (int i = 0; i < c.getGenes().length; i++) {

                    if (i % 2 == 0) {
                        if (c.getGenes()[i].getData() == 1) {
                            c.setFitness(c.getFitness() + 10);
                        } else {
                            c.setFitness(c.getFitness()
                                    - Math.abs(c.getGenes()[i].getData() - 1));
                        }
                    } else {
                        if (c.getGenes()[i].getData() == 0) {
                            c.setFitness(c.getFitness() + 10);
                        } else {
                            c.setFitness(c.getFitness()
                                    - Math.abs(c.getGenes()[i].getData() - 0));
                        }
                    }

                    c.setFitness(Math.max(0.0, c.getFitness()));
                }
            }

            @Override
            public boolean accept(Chromosome<Integer> c, Generation g) {
                return c.getFitness() > c.getGenes().length * 10 - 1;
            }
        };

        Evolution evolution = new SimpleEvolution(e);

        evolution.getBreeder().setBreedingOperator(
                new CrossOverAndSelectOperatorWithRate(evolution, prototype));

        evolution.getBreeder().setChromosomeOperator(new MutationOperator(0.01));

        int maxIter = 1000000;

        Solution solution = evolution.evolve(gOld, maxIter);

        System.out.println(solution);
    }

}

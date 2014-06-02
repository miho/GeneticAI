/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.mihosoft.geneticai;

/**
 *
 * @author Michael Hoffer <info@michaelhoffer.de>
 */
public interface Breeder {
    
    public void addChromosomeOperator(ChromosomeOperator<?> o);
    public void setChromosomeOperator(ChromosomeOperator<?> o);
    public void addBreedingOperator(BreedingOperator o);
    public void setBreedingOperator(BreedingOperator o);

    public void breed(Generation gOld, Generation gNew);
    
    public Evaluator getEvaluator();
    
}

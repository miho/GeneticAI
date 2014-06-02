/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.mihosoft.geneticai;

/**
 *
 * @author Michael Hoffer <info@michaelhoffer.de>
 */
public interface Evaluator<T> {
    public void evaluate(Chromosome<T> c, Generation g);
    public boolean accept(Chromosome<T> c, Generation g);
}

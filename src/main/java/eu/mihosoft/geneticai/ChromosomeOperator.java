/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.mihosoft.geneticai;

/**
 *
 * @author Michael Hoffer <info@michaelhoffer.de>
 */
public interface ChromosomeOperator<T> {
    public Chromosome<T> apply(Chromosome<T> src);
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.mihosoft.geneticai;

/**
 *
 * @author Michael Hoffer <info@michaelhoffer.de>
 */
public interface Evolution {
    
    public Solution evolve(Generation prototype, int maxIter);
    
    public double getRate();
    
    public void setBreeder(Breeder breeder);
    public Breeder getBreeder();


}

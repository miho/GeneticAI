/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.mihosoft.geneticai;

/**
 *
 * @author Michael Hoffer <info@michaelhoffer.de>
 */
public interface Gene<T> {
   public void setData(T value);
   public T getData();
   public void setRange(T min, T max);
   public void randomInit();
   
   public Gene copy();
}

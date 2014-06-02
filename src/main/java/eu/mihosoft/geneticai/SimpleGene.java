/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.mihosoft.geneticai;

/**
 *
 * @author Michael Hoffer <info@michaelhoffer.de>
 */
public class SimpleGene<T> implements Gene<T> {

    private T data;
    private T min;
    private T max;

    @Override
    public void setData(T data) {
        this.data = data;
    }

    @Override
    public T getData() {
        return this.data;
    }

    @Override
    public void setRange(T min, T max) {
        this.min = min;
        this.max = max;
    }

    @Override
    public void randomInit() {
        setData((T) Rand.randByType(min, max));
    }

    @Override
    public Gene copy() {

        SimpleGene<T> copy = new SimpleGene<>();

        T copyData = null;

        copyData = data;
        copy.setData(copyData);
        copy.setRange(min, max);

        return copy;
    }
}

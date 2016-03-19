package clustering;

import java.util.Map;
import java.util.Set;
import java.util.SortedSet;

public interface Instance extends Map<Integer, Double>, Iterable<Double>{
    
    public Object classValue();

    public void setClassValue(Object value);

    public int noAttributes();

    @Override
    @Deprecated
    public int size();

    public double value(int pos);

    public Instance minus(Instance min);

    @Override
    public SortedSet<Integer> keySet();

    public Instance minus(double value);

    public Instance add(Instance max);

    public Instance divide(double value);

    public Instance divide(Instance currentRange);

    public Instance add(double value);

    public Instance multiply(double value);

    public Instance multiply(Instance value);

    public void removeAttribute(int i);

    public Instance sqrt();

    public int getID();

    public Instance copy();


    public void removeAttributes(Set<Integer> indices);
    
    public String toString();

}

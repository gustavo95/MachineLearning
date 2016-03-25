package clustering;

import java.util.Arrays;

public class DenseInstance implements Instance {

    private double[] attributes;

    public DenseInstance(double[] att) {
        this(att, null);
    }

    public DenseInstance(double[] att, Object classValue) {
        super();
        this.attributes = att.clone();
    }

    public DenseInstance(int size) {
        this(new double[size]);
    }

    @Override
    public double value(int pos) {
        return attributes[pos];
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final DenseInstance other = (DenseInstance) obj;
        if (!Arrays.equals(attributes, other.attributes))
            return false;
        return true;
    }
    
    @Override
    public int noAttributes() {
        return attributes.length;
    }
    
    @Override
    public String toString() {
        return Arrays.toString(attributes);
    }

}

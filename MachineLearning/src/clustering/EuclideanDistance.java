package clustering;

public class EuclideanDistance implements DistanceMeasure{
	
	private double power;
	
	public EuclideanDistance() {
        this(2);
    }
	
	public EuclideanDistance(double power) {
        this.power = power;
    }
	
	public double calculateDistance(Instance x, Instance y) {
        if (x.noAttributes() != y.noAttributes()) {
            throw new RuntimeException("Distancia Euclidiana - As entradas devem conter o mesmo numero de dados");
        }
        double sum = 0;
        for (int i = 0; i < x.noAttributes(); i++) {
            if (!Double.isNaN(y.value(i)) && !Double.isNaN(x.value(i)))
                sum += (y.value(i) - x.value(i)) * (y.value(i) - x.value(i));
        }
        return Math.sqrt(sum);
    }
	
	@Override
    public double measure(Instance x, Instance y) {
        assert (x.noAttributes() == y.noAttributes());
        double sum = 0;
        for (int i = 0; i < x.noAttributes(); i++) {
            sum += Math.pow(Math.abs(y.value(i) - x.value(i)), power);
        }

        return Math.pow(sum, 1 / power);
    }
	
	public boolean compare(double x, double y) {
		return x < y;
	}

	@Override
	public double getMinValue() {
		return 0;
	}

	@Override
	public double getMaxValue() {
		return Double.POSITIVE_INFINITY;
	}
	
}

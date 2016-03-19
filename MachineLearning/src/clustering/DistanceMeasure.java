package clustering;

import java.io.Serializable;

public interface DistanceMeasure extends Serializable {
	
	public double calculateDistance(Instance x, Instance y);

	public double measure(Instance x, Instance y);

	public boolean compare(double x, double y);

	public double getMinValue();

	public double getMaxValue();
}

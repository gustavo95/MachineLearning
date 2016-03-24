package clustering;

public interface DistanceMeasure{
	
	public double calculateDistance(Instance x, Instance y);

	public double measure(Instance x, Instance y);

	public boolean compare(double x, double y);

	public double getMinValue();

	public double getMaxValue();
}

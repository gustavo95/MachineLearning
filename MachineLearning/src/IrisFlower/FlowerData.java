package IrisFlower;

import clustering.Instance;

public class FlowerData implements Instance{
	
	private double sepalLength;
	private double sepalWidth;
	private double petalLength;
	private double petalWidth;
	private String species;
	
	public FlowerData(double sepalLength, double sepalWidth, double petalLength, double petalWidth, String species) {
		super();
		this.sepalLength = sepalLength;
		this.sepalWidth = sepalWidth;
		this.petalLength = petalLength;
		this.petalWidth = petalWidth;
		this.species = species;
	}

	@Override
	public double value(int pos) {
		switch (pos) {
		case 0:
			return sepalLength;
		case 1:
			return sepalWidth;
		case 2:
			return petalLength;
		case 3:
			return petalWidth;
		default:
			return 0;
		}
	}
	
	@Override
	public int noAttributes() {
		return 4;
	}
	
	@Override
	public String toString(){
		return "sepalLength: " + sepalLength + "; sepalWidth: " + sepalWidth + "; petalLength: " + petalLength
				+ "; petalWidth: " + petalWidth + "; species: " + species;
	}
	
}

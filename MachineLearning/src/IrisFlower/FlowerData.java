package IrisFlower;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;

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
	

	@Override
	public void clear() {
		// TODO Auto-generated method stub
	}

	@Override
	public boolean containsKey(Object key) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsValue(Object value) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Set<java.util.Map.Entry<Integer, Double>> entrySet() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Double get(Object key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Double put(Integer key, Double value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void putAll(Map<? extends Integer, ? extends Double> m) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Double remove(Object key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Double> values() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<Double> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object classValue() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setClassValue(Object value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Instance minus(Instance min) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SortedSet<Integer> keySet() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Instance minus(double value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Instance add(Instance max) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Instance divide(double value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Instance divide(Instance currentRange) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Instance add(double value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Instance multiply(double value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Instance multiply(Instance value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeAttribute(int i) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Instance sqrt() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Instance copy() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeAttributes(Set<Integer> indices) {
		// TODO Auto-generated method stub
		
	}

}

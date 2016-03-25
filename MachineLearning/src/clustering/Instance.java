package clustering;

public interface Instance{
	
	public double value(int pos);
	
	public int noAttributes();
	
	public String toString();
	
	public boolean equals(Object obj);

}

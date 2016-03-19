package clustering;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class KMedoids{
	
	private int numberOfClusters;
	private int maxIterations;
	private DistanceMeasure dm;
	private Random rg;
	
	public KMedoids(int numberOfClusters, int maxIterations) {
		super();
		this.numberOfClusters = numberOfClusters;
		this.maxIterations = maxIterations;
		dm = new EuclideanDistance();
		rg = new Random(System.currentTimeMillis());
	}
	
	//inicia a clusterização, escolhe os centroides aleatorios e recalcula os centroides
	public List<List<Instance>> cluster(List<Instance> data) {
		Instance[] medoids = new Instance[numberOfClusters];
		List<List<Instance>> output = new ArrayList<List<Instance>>(numberOfClusters);
		
		for (int i = 0; i < numberOfClusters; i++) {
			int random = rg.nextInt(data.size());
			medoids[i] = data.get(random);
		}

		boolean changed = true;
		int count = 0;
		while (changed && count < maxIterations) {
			changed = false;
			count++;
			int[] assignment = assign(medoids, data);
			changed = recalculateMedoids(assignment, medoids, output, data);
		}

		return output;

	}
	
	//calcular as distancias dos dados aos centroides
	private int[] assign(Instance[] medoids, List<Instance> data) {
		int[] out = new int[data.size()];
		
		for (int i = 0; i < data.size(); i++) {
			double bestDistance = dm.calculateDistance(data.get(i), medoids[0]);
			int bestIndex = 0;
			
			for (int j = 1; j < medoids.length; j++) {
				double tmpDistance = dm.calculateDistance(data.get(i), medoids[j]);
				if (tmpDistance < bestDistance) {
					bestDistance = tmpDistance;
					bestIndex = j;
				}
			}
			out[i] = bestIndex;
		}
		return out;

	}
	
	//recalcula os centroides
	private boolean recalculateMedoids(int[] assignment, Instance[] medoids,
			List<List<Instance>> output, List<Instance> data) {
		boolean changed = false;
		
		for (int i = 0; i < numberOfClusters; i++) {
			if(output.size() > i){
				output.remove(i);
			}
			output.add(i, new ArrayList<Instance>());

			for (int j = 0; j < assignment.length; j++) {
				if (assignment[j] == i) {
					output.get(i).add(data.get(j));
				}
			}
			
			if (output.get(i).size() == 0) {
				medoids[i] = data.get(rg.nextInt(data.size()));
				changed = true;
			} else {
				Instance centroid = average(output.get(i));
				Instance oldMedoid = medoids[i];
				medoids[i] = kNearest(data, 1, centroid, dm).iterator().next();
				if (!medoids[i].equals(oldMedoid))
					changed = true;
			}
		}
		return changed;
	}
	
	//calcula a media dos atributos
	public static Instance average(List<Instance> data) {
		int n = data.get(0).noAttributes();
		double[] tmpOut = new double[n];
		
		for (int i = 0; i < n; i++) {
			double sum=0;
			for (int j = 0; j < data.size(); j++) {
				sum+= data.get(j).value(i);
			}
			tmpOut[i] = sum/data.size();

		}
		return new DenseInstance(tmpOut);
	}
	
	//retorna os k elementos perto de inst
	 public Set<Instance> kNearest(List<Instance> data, int k, Instance inst, DistanceMeasure dm) {
	        Map<Instance, Double> closest = new HashMap<Instance, Double>();
	        double max = dm.getMaxValue();
	        
	        for (Instance tmp : data) {
	            double d = dm.measure(inst, tmp);
	            
	            if (dm.compare(d, max) && !inst.equals(tmp)) {
	                closest.put(tmp, d);
	                if (closest.size() > k)
	                    max = removeFarthest(closest,dm);
	            }

	        }
	        return closest.keySet();
	    }
	 
	 //remove o elemento mais distante 
	 private double removeFarthest(Map<Instance, Double> vector,DistanceMeasure dm) {
	        Instance tmp = null;
	        double max = dm.getMinValue();
	       
	        for (Instance inst : vector.keySet()) {
	            double d = vector.get(inst);
	            
	            if (dm.compare(max,d)) {
	                max = d;
	                tmp = inst;
	            }
	        }
	        vector.remove(tmp);
	        return max;

	    }
}

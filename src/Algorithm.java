import java.util.*;
import java.util.stream.DoubleStream;

class Algorithm {

	
	// Inputs
	public static int T = 144;
	public static double Cf = 20;
	public static double Cd = 2;

	   public static final double[][] D = {
		   {2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,3,2,2,2,2,2,2,2,3,3,4,4,5,5,5,5,5,5,5,5,6,6,6,6,7,7,7,7,7,7,7,7,7,7,6,6,6,6,6,6,6,6,6,5,5,5,5,5,5,5,5,5,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,5,5,5,5,5,5,5,5,5,6,6,6,6,6,6,6,6,6,6,6,6,5,5,5,5,4,4,4,4,4,4,4,3,3,3,2,2,2,2,2,2,2,2},
		   {4,4,4,3,3,3,3,3,3,3,3,3,3,4,4,4,5,5,5,5,5,4,4,4,5,6,7,7,8,9,9,9,10,10,10,10,11,11,12,12,13,13,13,13,14,14,14,14,14,13,13,13,12,12,12,12,12,11,11,11,11,11,11,10,10,10,10,9,9,9,8,8,8,8,8,8,8,8,8,8,8,7,7,7,7,7,8,8,8,8,8,8,8,8,8,8,8,8,9,9,9,9,9,9,10,10,10,10,10,11,11,11,12,12,12,12,12,12,12,12,12,11,11,10,10,9,9,9,9,8,8,8,7,7,6,5,5,4,4,4,4,4,4,4},
		   {6,6,5,5,5,5,5,5,5,5,5,5,5,6,6,7,7,8,7,7,7,7,6,6,7,9,10,11,12,14,14,14,14,15,15,15,16,17,17,18,19,20,20,20,20,21,21,21,21,20,20,19,19,18,18,18,17,17,17,17,16,16,16,16,15,15,15,14,14,13,13,12,12,12,12,12,12,12,12,12,11,11,11,11,11,11,11,12,12,12,12,12,12,12,12,12,12,13,13,13,13,14,14,14,14,15,15,15,16,16,17,17,18,18,18,18,18,18,18,18,17,17,16,15,14,14,13,13,13,13,12,12,11,10,9,8,7,6,6,6,6,6,6,6},
		   {8,7,7,7,6,6,6,6,6,6,6,6,7,7,8,9,9,10,10,9,9,9,8,8,10,11,13,15,16,18,18,19,19,19,20,20,21,22,23,24,25,26,26,27,27,27,28,28,27,27,26,25,25,24,24,23,23,23,22,22,22,21,21,21,20,20,19,19,18,17,17,16,16,16,16,16,16,16,16,15,15,15,14,14,14,15,15,15,16,16,16,16,16,16,16,16,16,17,17,17,18,18,18,19,19,19,20,20,21,21,22,23,23,24,24,24,24,24,24,24,23,22,21,20,19,18,18,17,17,17,16,16,15,13,12,11,9,8,8,8,8,8,8,8},
		   {12,11,11,10,10,9,9,9,9,9,9,9,10,11,12,13,14,15,15,14,14,13,13,12,15,17,20,22,25,27,28,28,29,29,30,30,32,33,35,36,38,39,40,40,41,41,42,42,41,40,39,38,37,36,36,35,35,34,34,33,33,32,32,31,31,30,29,28,27,26,25,24,24,24,24,24,24,24,24,23,23,22,22,21,22,22,23,23,24,24,24,24,24,24,24,24,25,25,26,26,27,27,28,28,29,29,30,30,31,32,33,34,35,36,36,36,36,36,36,36,35,33,32,30,29,27,27,26,26,25,25,24,22,20,18,16,14,12,12,12,12,12,12,12},
		   {15,15,14,13,13,12,12,12,12,12,12,12,13,15,16,17,19,20,19,19,18,17,17,16,19,23,26,29,33,36,37,37,38,39,39,40,42,44,46,48,50,52,53,53,54,55,55,56,55,53,52,51,49,48,47,47,46,45,45,44,43,43,42,41,41,40,39,37,36,35,33,32,32,32,32,32,32,32,31,31,30,29,29,28,29,29,30,31,31,32,32,32,32,32,32,32,33,33,34,35,35,36,37,37,38,39,39,40,41,43,44,45,47,48,48,48,48,48,48,48,46,44,42,40,38,36,35,35,34,33,33,32,29,27,24,21,19,16,16,16,16,16,16,16},
};
	   
	   
	public static final int Lambda = D.length;
	public static double Ls = Double.POSITIVE_INFINITY;
	
	   
	
	 
	   public static final double[] FP = {1,0.94484,0.79329,0.55711,0.39431,0.30367,0.26756,0.23145,0.19534,0.15923,0.12312,0.09975,0.092208,0.084666,0.077124,0.069582,0.064024,0.059253,0.054482,0.049711,0.047199,0.045092,0.043487,0.042613,0.041738,0.040863,0.039989,0.039114,0.037554,0.03438,0.031591,0.029329,0.027256,0.026403,0.025549,0.024648,0.023413,0.022193,0.021189,0.020508,0.020133,0.019757,0.019018,0.016859,0.015443,0.015042,0.014311,0.013449,0.012512,0.011501,0.011284,0.011104,0.01098,0.010855,0.01069,0.010452,0.01028,0.01013,0.0098708,0.0095188,0.0092813,0.0091206,0.0089732,0.0088328,0.0086701,0.0082555,0.0080443,0.0078826,0.0077837,0.0076636,0.00761,0.0075828,0.0075555,0.007518,0.0074757,0.0074335,0.0073824,0.007327,0.0072703,0.007226,0.0071856,0.007127,0.0052475,0.0045227,0.0044902,0.0044552,0.0044273,0.0043697,0.0042974,0.0040555,0.003813,0.0037776,0.0037578,0.0037389,0.0037358,0.0037331,0.0037303,0.0037276,0.0037249,0.0037222,0.0037194,0.0037167,0.003714,0.0037113,0.0037068,0.0036917,0.0036725,0.0036442
		   			}; 
		   
	   public static final int[][]  Th = new int[][] { 
	   {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52,53,54,55,56,57,58,59,60,61,62,63,64,65,66,67,68,69,70,71,72,73,74,75,76,77,78,79,80,81,82,83,84,85,86,87,88,89,90,91,92,93,94,95,96,97,98,99,100,101,102,103,104,105,106,107},
	   {0,1,2,2,4,4,5,6,6,7,7,8,9,10,11,11,12,13,14,14,15,16,16,17,17,18,18,18,19,20,20,21,21,21,22,22,22,23,23,24,24,24,25,25,25,26,26,26,27,27,28,28,28,29,29,29,30,30,30,31,32,33,33,34,35,36,36,37,37,39,40,40,40,40,41,41,41,42,42,43,43,44,44,45,46,46,47,47,48,49,50,51,52,52,52,52,52,53,53,53,53,53,53,53,53,54,54,55},
	   {0,1,1,2,3,4,4,5,5,5,6,6,7,7,8,8,9,9,10,11,11,12,12,12,12,13,13,13,13,14,14,15,15,15,15,16,16,17,17,17,17,18,18,18,18,19,19,19,20,20,21,21,21,21,21,22,22,22,23,23,23,24,24,25,25,25,26,26,27,27,27,27,27,28,28,28,28,28,29,29,29,29,30,30,31,31,31,32,32,33,33,34,34,34,34,34,34,35,35,35,35,35,35,35,35,36,36,37},
	   {0,1,1,2,3,3,3,4,4,4,5,5,6,6,6,7,7,7,8,8,8,9,9,9,10,10,10,10,10,11,11,11,11,12,12,12,12,13,13,13,13,14,14,14,15,15,15,15,16,16,16,17,17,17,17,17,17,17,18,18,18,19,19,19,20,20,21,21,21,22,22,22,22,22,22,22,22,23,23,23,23,23,24,24,24,25,25,25,26,26,26,27,27,27,27,27,27,27,27,27,27,27,27,27,27,27,28,28},
	   {0,1,1,2,2,2,2,3,3,4,4,4,4,5,5,5,5,6,6,6,6,6,7,7,7,7,7,7,7,8,8,8,8,9,9,9,9,9,10,10,10,10,10,11,11,11,11,11,11,12,12,12,12,12,13,13,13,13,13,14,14,14,15,15,15,15,16,16,16,17,17,17,17,17,17,17,17,18,18,18,18,18,19,19,19,19,20,20,20,20,20,21,21,21,21,21,21,21,21,21,21,21,21,21,21,21,22,22},
	   {0,1,1,1,1,2,2,2,2,3,3,3,3,3,4,4,4,4,4,5,5,5,5,5,5,5,6,6,6,6,6,6,6,7,7,7,7,7,7,8,8,8,8,8,8,9,9,9,10,10,10,10,10,10,11,11,11,11,11,11,12,12,12,13,13,13,13,14,14,14,14,14,14,15,15,15,15,15,15,15,16,16,16,17,17,17,18,18,18,18,19,19,19,19,19,19,19,19,19,19,20,20,20,20,20,20,20,20},
	   };
	   
	   
	   

	public static HashMap<String, Double> costs = new HashMap<String, Double>();

	private static double getCost(int n, int[] m, int eta_prev, double P) {
		if (n >= T)
			return 0.0;
		String id = Integer.toString(n) + Arrays.toString(m)
				+ Integer.toString(eta_prev);
		Double cost = costs.get(id);
		if (cost != null)
			return cost;
		// check damage constraint
		for (int lambda = 0; lambda < Lambda; lambda++) {
			double damage = 0.0;
			for (int t = n - m[lambda]; t <= n; t++)
				damage += D[lambda][t];
			if (damage > P) {
				costs.put(id, Double.POSITIVE_INFINITY);
				return Double.POSITIVE_INFINITY;
			}
		}
		// find best threshold
		cost = Double.POSITIVE_INFINITY;
		int[] mNext = new int[m.length];
		for (int eta = 0; eta < Th[0].length; eta++) {
			for (int lambda = 0; lambda < Lambda; lambda++)
				mNext[lambda] = Math.min(Th[lambda][eta], m[lambda] + 1);
			double etaCost = getCost(n + 1, mNext, eta, P) + Cf * FP[eta]
					+ ((n > 0) && (eta != eta_prev) ? Cd : 0);
			if (etaCost < cost)
				cost = etaCost;
		}
		costs.put(id, cost);
		return cost;
	}

	public static HashMap<String, Integer> thresholds = new HashMap<String, Integer>();

	private static double getThreshold(int n, int[] m, int eta_prev, double P) {
		if (n >= T)
			return 0.0;
		String id = Integer.toString(n) + Arrays.toString(m)
				+ Integer.toString(eta_prev);
		Double cost = costs.get(id);
		if (cost != null)
			return cost;
		// check damage constraint
		for (int lambda = 0; lambda < Lambda; lambda++) {
			double damage = 0.0;
			for (int t = n - m[lambda]; t <= n; t++)
				damage += D[lambda][t];
			if (damage > P) {
				costs.put(id, Double.POSITIVE_INFINITY);
				thresholds.put(id, -1);
				return Double.POSITIVE_INFINITY;
			}
		}
		// find best threshold
		cost = Double.POSITIVE_INFINITY;
		Integer etaS = -1;
		int[] mNext = new int[m.length];
		for (int eta = 0; eta < Th[0].length; eta++) {
			for (int lambda = 0; lambda < Lambda; lambda++)
				mNext[lambda] = Math.min(Th[lambda][eta], m[lambda] + 1);
			double etaCost = getThreshold(n + 1, mNext, eta, P) + Cf * FP[eta]
					+ ((n > 0) && (eta != eta_prev) ? Cd : 0);
			if (etaCost < cost) {
				cost = etaCost;
				etaS = eta;

			}
		}
		costs.put(id, cost);
		thresholds.put(id, etaS);
		return cost;
	}
	
	static void exhaustive(int c, int[] eta) {
		if (c == T) {
			int n = 0;
			int[] m = new int[Lambda];
			double Payoff_solution = 0;
			int lambda_solution = 0;
			int ka_solution = 0;
			while (n < T) {
				int[] mNext = new int[Lambda];
				for (int lambda = 0; lambda < Lambda; lambda++) {
					double damage = 0.0;
					for (int t = n - m[lambda]; t <= n; t++)
						damage += D[lambda][t];
					mNext[lambda] = Math.min(Th[lambda][eta[n]], m[lambda] + 1);
					if (damage >= Payoff_solution) {
						Payoff_solution = damage;
						lambda_solution = lambda;
						ka_solution = n - m[lambda];
					}
				}
				m = mNext;
				n = n + 1;
			}
			double TC = 0;
			for (int i = 0; i < T; i++) {
				if (i > 0 && eta[i] != eta[i - 1]) {
					TC += Cf * FP[eta[i]] + Cd;
				} else {
					TC += Cf * FP[eta[i]];
				}
			}

			double L = Payoff_solution + TC;
			if (L < Ls) {
				Ls = L;
			}
		} else {
			for (int i = 0; i < Th[0].length; i++) {
				eta[c] = i;
				exhaustive(c + 1, eta);
			}
		}
	}

	public static void main(String args[]) {
		
		double max = 0;
		for (int i = 0; i < D.length; i++) {
			for (int j = 0; j < T; j++) {
				if (D[i][j] > max) {
					max = D[i][j];
				}
			}
		}

		SortedSet<Double> SearchSpace = new TreeSet<Double>();
		for (int i = 0; i < Lambda; i++) {
			for (int ka = 0; ka < T; ka++) {
				for (int delta = 0; delta < Th[i][Th[i].length - 1]; delta++) {
					double sum = 0;
					if (ka + delta < T) {
						sum = DoubleStream.of(
								Arrays.copyOfRange(D[i], ka, ka + delta + 1))
								.sum();
					} else {
						sum = DoubleStream.of(
								Arrays.copyOfRange(D[i], ka, T)).sum();
					}
					if (sum >= max) {
						SearchSpace.add(sum);
					}
				}
			}
		}
		
		//long startTimeEx = System.nanoTime();
		//exhaustive(0, new int[T]);
		//long endTimeEx = System.nanoTime();
		//System.out.println("Took "+(endTimeEx - startTimeEx)/1000000000.0 + " s"); 

		Double TC = Double.POSITIVE_INFINITY;
		Double Ps = Double.POSITIVE_INFINITY;
		

		long startTime = System.nanoTime();
		for (double P : SearchSpace) {
			//if (P < 239.0)
			//	continue;
			System.out.println("P: " + P);

			if (P >= max && TC > P) {
				costs.clear();
				double cost = getCost(0, new int[Lambda], 0, P);
				System.out.print("Cost: ");
				System.out.println(cost + " Best: " + Ps);
				if (cost + P < TC) {
					TC = cost + P;
					Ps = P;
				}
			}
		} 
		long endTime = System.nanoTime();
		System.out.println("Took "+(endTime - startTime)/1000000000.0 + " s");
	
	 
		
		Ps = 240.0;
		costs.clear();
		getThreshold(0, new int[Lambda], 0, Ps);
		//System.out.println("Loss: " + TC + ", Payoff: " + Ps);
		System.out.println("Total Loss: " + costs.get(Integer.toString(0) + Arrays.toString(new int[Lambda])
					+ Integer.toString(0))+Ps + ", Payoff: " + Ps);
		
		int n = 0;
		int[] m = new int[Lambda];
		int[] eta_solution = new int[T];
		int eta_prev = 0;
		double Payoff_solution = 0;
		int lambda_solution = 0;
		int ka_solution = 0;
		while (n < T) {
			String id = Integer.toString(n) + Arrays.toString(m)
					+ Integer.toString(eta_prev);
			eta_solution[n] = thresholds.get(id);
			int[] mNext = new int[Lambda];
			for (int lambda = 0; lambda < Lambda; lambda++) {
				double damage = 0.0;
				for (int t = n - m[lambda]; t <= n; t++)
					damage += D[lambda][t];
				mNext[lambda] = Math.min(Th[lambda][eta_solution[n]],
						m[lambda] + 1);
				if (damage >= Payoff_solution) {
					Payoff_solution = damage;
					lambda_solution = lambda;
					ka_solution = n - m[lambda];
				}
			}

			eta_prev = eta_solution[n];
			m = mNext;
			n = n + 1;
		}
		System.out.print("Thresholds: ");
		for (int i = 0; i < eta_solution.length; i++)
			System.out.print(eta_solution[i] + ", ");
		System.out.println();
		System.out.println("Best-Response Attack: " + "Type " + lambda_solution
				+ ", " + "Start Time " + ka_solution);

	}

}

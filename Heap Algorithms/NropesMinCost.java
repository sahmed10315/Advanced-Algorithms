
/* package whatever; // don't place package name! */

import java.util.*;

/* Name of the class has to be "Main" only if the class is public. */
public class NropesMinCost {
	int minCost(int[] input) {
		int minCost = 0;
		PriorityQueue<Integer> queue = new PriorityQueue<>();
		for (int i = 0; i < input.length; i++) {
			queue.add(input[i]);
		}
		while (queue.size() > 1) {
			int first = queue.remove();
			int second = queue.remove();
			int sum = first + second;
			minCost += sum;
			queue.add(sum);
		}
		return minCost;
	}

	public static void main(String[] args) throws java.lang.Exception {
		NropesMinCost connectNRopes = new NropesMinCost();
		int input[] = { 4, 3, 2, 6 };
		int minCost = connectNRopes.minCost(input);
		System.out.println("Minimum cost of connecting ropes is: " + minCost);
	}
}
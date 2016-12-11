import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.TreeSet;

public class SortAlmostSortedArray {

	public static void sortApproximatelySortedData(Iterator<Integer> sequence, int k) {
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		// Adds the first k elements into minHeap. Stop if there are fewer than
		// k
		// elements.
		for (int i = 0; i < k && sequence.hasNext(); ++i) {
			minHeap.add(sequence.next());
		}

		// For every new element, add it to minHeap and extract the smallest.
		while (sequence.hasNext()) {
			minHeap.add(sequence.next());
			Integer smallest = minHeap.remove();
			System.out.println(smallest);
		}

		// sequence is exhausted, iteratively extracts the remaining elements.
		while (!minHeap.isEmpty()) {
			Integer smallest = minHeap.remove();
			System.out.println(smallest);
		}
	}

	public static void main(String[] args) {
	}
}
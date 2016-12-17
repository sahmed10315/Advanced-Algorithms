import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
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
		int k = 3;
		int arr[] = { 2, 6, 3, 12, 56, 8 };
		List<Integer> list = new ArrayList<Integer>();
		list.add(arr[0]);list.add(arr[1]);list.add(arr[2]);list.add(arr[3]);list.add(arr[4]);list.add(arr[5]);
		sortApproximatelySortedData(list.iterator(), k);
	}
}
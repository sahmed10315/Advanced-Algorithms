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
		Random r = new Random();
		int n;
		if (args.length == 1) {
			n = Integer.parseInt(args[0]);
		} else {
			n = r.nextInt(100000) + 1;
		}
		System.out.println("n = " + n);
		List<Integer> A = new ArrayList<>();
		for (int i = 0; i < n; ++i) {
			A.add(r.nextInt(999999) + 1);
		}
		sortApproximatelySortedData(A.iterator(), n - 1);
		// Check result is sorted.
		List<Integer> tmp = new ArrayList<>(result);
		Collections.sort(tmp);
		assert (result.equals(tmp));
		// Check result contains stream entries.
		assert (new TreeSet<>(result).equals(new TreeSet<>(A)));
	}
}
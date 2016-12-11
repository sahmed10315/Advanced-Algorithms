
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class KLargest {
	// @include
	private static class Compare {
		private static class GreaterThan implements Comparator<Integer> {
			public int compare(Integer a, Integer b) {
				return (a > b) ? -1 : (a.equals(b)) ? 0 : 1;
			}
		}

		public static final GreaterThan GREATER_THAN = new GreaterThan();
		// @exclude

		private static class LessThan implements Comparator<Integer> {
			public int compare(Integer a, Integer b) {
				return (a < b) ? -1 : (a.equals(b)) ? 0 : 1;
			}
		}

		public static final LessThan LESS_THAN = new LessThan();
		// @include
	}

	// The numbering starts from one, i.e., if A = [3,1,-1,2] then
	// findKthLargest(A, 1) returns 3, findKthLargest(A, 2) returns 2,
	// findKthLargest(A, 3) returns 1, and findKthLargest(A, 4) returns -1.
	public static int findKthLargest(List<Integer> A, int k) {
		return findKth(A, k, Compare.GREATER_THAN);
	}

	// @exclude

	// The numbering starts from one, i.e., if A = [3,1,-1,2] then
	// findKthSmallest(A, 1) returns -1, findKthSmallest(A, 2) returns 1,
	// findKthSmallest(A, 3) returns 2, and findKthSmallest(A, 4) returns 3.
	public static int findKthSmallest(List<Integer> A, int k) {
		return findKth(A, k, Compare.LESS_THAN);
	}

	// @include
	public static int findKth(List<Integer> A, int k, Comparator<Integer> cmp) {
		int left = 0, right = A.size() - 1;
		Random r = new Random(0);
		while (left <= right) {
			// Generates a random integer in [left, right].
			int pivotIdx = r.nextInt(right - left + 1) + left;
			int newPivotIdx = partitionAroundPivot(left, right, pivotIdx, A, cmp);
			if (newPivotIdx == k - 1) {
				return A.get(newPivotIdx);
			} else if (newPivotIdx > k - 1) {
				right = newPivotIdx - 1;
			} else { // newPivotIdx < k - 1.
				left = newPivotIdx + 1;
			}
		}
		// @exclude
		throw new NoSuchElementException("no k-th node in array A");
		// @include
	}

	// Partitions A.subList(left, right+1) around pivotIdx, returns the new
	// index
	// of the pivot, newPivotIdx, after partition. After partitioning,
	// A.subList(left, newPivotIdx) contains elements that are less than the
	// pivot, and A.subList(newPivotIdx + 1 , right + 1) contains elements that
	// are greater than the pivot.
	//
	// Note: "less than" is defined by the Comparator object.
	//
	// Returns the new index of the pivot element after partition.
	private static int partitionAroundPivot(int left, int right, int pivotIdx, List<Integer> A,
			Comparator<Integer> cmp) {
		int pivotValue = A.get(pivotIdx);
		int newPivotIdx = left;

		Collections.swap(A, pivotIdx, right);
		for (int i = left; i < right; ++i) {
			if (cmp.compare(A.get(i), pivotValue) < 0) {
				Collections.swap(A, i, newPivotIdx++);
			}
		}
		Collections.swap(A, right, newPivotIdx);
		return newPivotIdx;
	}

	public static void main(String[] args) { 
		System.out.println("Finished complexRandomTest()");
		Random r = new Random();
		for (int times = 0; times < 1000; ++times) {
			int n, k;
			if (args.length == 1) {
				n = Integer.parseInt(args[0]);
				k = r.nextInt(n) + 1;
			} else if (args.length == 2) {
				n = Integer.parseInt(args[0]);
				k = Integer.parseInt(args[1]);
			} else {
				n = r.nextInt(100000) + 1;
				k = r.nextInt(n - 1) + 1;
			}
			List<Integer> A = new ArrayList<>(n);
			for (int i = 0; i < n; ++i) {
				A.add(r.nextInt(10000000));
			}
			int result = findKthLargest(A, k);
			Collections.sort(A);
			assert (result == A.get(A.size() - k));
		}
	}
}
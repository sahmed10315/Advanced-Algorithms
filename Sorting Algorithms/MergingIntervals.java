
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List; 
import java.util.Stack;

public class MergingIntervals {

	private static class Interval {
		public int left, right;

		public Interval(int l, int r) {
			this.left = l;
			this.right = r;
		}
	}

	public static List<Interval> merge(List<Interval> intervals) {
		List<Interval> result = new ArrayList<Interval>();

		if (intervals == null || intervals.size() == 0)
			return result;

		Collections.sort(intervals, new Comparator<Interval>() {
			public int compare(Interval i1, Interval i2) {
				if (i1.left != i2.left)
					return i1.left - i2.left;
				else
					return i1.right - i2.right;
			}
		});

		Interval pre = intervals.get(0);
		for (int i = 0; i < intervals.size(); i++) {
			Interval curr = intervals.get(i);
			if (curr.left > pre.right) {
				result.add(pre);
				pre = curr;
			} else {
				Interval merged = new Interval(pre.left, Math.max(pre.right, curr.right));
				pre = merged;
			}
		}
		result.add(pre);

		return result;
	}

	// The main function that takes a set of intervals, merges
	// overlapping intervals and prints the result
	void mergeIntervals(Interval arr[], int n) {
		// Test if the given set has at least one interval
		if (n <= 0)
			return;

		// Create an empty stack of intervals
		Stack<Interval> s = new Stack<>();

		Arrays.sort(arr, new Comparator<Interval>() {
			public int compare(Interval i1, Interval i2) {
				if (i1.left != i2.left)
					return i1.left - i2.left;
				else
					return i1.right - i2.right;
			}
		});

		// push the first interval to stack
		s.push(arr[0]);

		// Start from the next interval and merge if necessary
		for (int i = 1; i < n; i++) {
			// get interval from stack top
			Interval top = s.pop();

			// if current interval is not overlapping with stack top,
			// push it to the stack
			if (top.left < arr[i].right)
				s.push(arr[i]);

			// Otherwise update the ending time of top if ending of current
			// interval is more
			else if (top.left < arr[i].right) {
				top.left = arr[i].right;
				s.pop();
				s.push(top);
			}
		}

		return;
	}

	public static void main(String[] args) {
		ArrayList<Interval> list = new ArrayList<MergingIntervals.Interval>();
		list.add(new Interval(1, 3));
		list.add(new Interval(2, 6));
		list.add(new Interval(8, 19));
		list.add(new Interval(1, 4));
		merge(list);
	}

}

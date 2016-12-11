
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

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

	public static void main(String[] args) { 
		ArrayList<Interval> list = new ArrayList<MergingIntervals.Interval>();
		list.add(new Interval(1, 3));
		list.add(new Interval(2, 6));
		list.add(new Interval(8, 19));
		list.add(new Interval(1, 18));
		merge(list);
	}

}

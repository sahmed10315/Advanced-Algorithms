
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class PointsCoveringIntervals {
	public static class Interval {
		public int left, right;

		public Interval(int l, int r) {
			this.left = l;
			this.right = r;
		}
	}

	public static List<Integer> findMinimumVisits(List<Interval> intervals) {
		if (intervals.isEmpty()) {
			return Collections.emptyList();
		}

		// Sort intervals based on the right endpoints.
		Collections.sort(intervals, new Comparator<Interval>() {
			@Override
			public int compare(Interval i1, Interval i2) {
				return Integer.compare(i1.right, i2.right);
			}
		});
		List<Integer> visits = new ArrayList<>();
		Integer lastVisitTime = intervals.get(0).right;
		visits.add(lastVisitTime);
		for (Interval interval : intervals) {
			if (interval.left > lastVisitTime) {
				// The current right endpoint, lastVisitTime, will not cover any
				// more
				// intervals.
				lastVisitTime = interval.right;
				visits.add(lastVisitTime);
			}
		}
		return visits;
	}

	public static void main(String[] args) {
		List<Interval> A = new ArrayList<>();
		A.add(new Interval(0, 3));
		A.add(new Interval(2, 6));
		A.add(new Interval(3, 4));
		A.add(new Interval(6, 9));
		findMinimumVisits(A);
	}
}

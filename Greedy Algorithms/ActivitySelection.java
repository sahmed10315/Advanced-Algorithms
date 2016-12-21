
import java.util.*;
 

public class ActivitySelection {
	public static class Interval {
		public int start, finish;

		public Interval(int l, int r) {
			this.start = l;
			this.finish = r;
		}
	}
	public static void printMaxActivities(List<Interval> intervals) { 

		// Sort intervals based on the right endpoints.
		Collections.sort(intervals, new Comparator<Interval>() {
			@Override
			public int compare(Interval i1, Interval i2) {
				return Integer.compare(i1.finish, i2.finish);
			}
		}); 

		System.out.print("Following activities are selected : \n");

		// The first activity always gets selected
	 
		System.out.println(intervals.get(0).start + " " + intervals.get(0).finish);
		Integer lastTime = intervals.get(0).finish;
		// Consider rest of the activities
		for (Interval interval : intervals) {
			// If this activity has start time greater than or
			// equal to the finish time of previously selected
			// activity, then select it
			if (interval.start > lastTime) {
				lastTime = interval.finish;
				System.out.println(interval.start + " " + interval.finish);
				
			}
		}
	}

	// driver program to test above function
	public static void main(String[] args) {
		List<Interval> A = new ArrayList<>();
//		A.add(new Interval(1, 2));
//		A.add(new Interval(3, 4));
//		A.add(new Interval(0, 6));
//		A.add(new Interval(5, 7));
//		A.add(new Interval(8, 9));
//		A.add(new Interval(5, 9)); 
		A.add(new Interval(0, 3));
		A.add(new Interval(2, 6));
		A.add(new Interval(3, 4));
		A.add(new Interval(6, 9));
		printMaxActivities(A);
	}

}

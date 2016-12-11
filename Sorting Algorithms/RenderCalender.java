
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class RenderCalender {
	public static class Event {
		public int start, finish;

		public Event(int start, int finish) {
			this.start = start;
			this.finish = finish;
		}

		@Override
		public String toString() {
			return "[" + start + "," + finish + "]";
		}
	}

	private static class Endpoint implements Comparable<Endpoint> {
		public int time;
		public boolean isStart;

		public Endpoint(int t, boolean is) {
			time = t;
			isStart = is;
		}

		public int compareTo(Endpoint e) {
			if (time != e.time) {
				return Integer.compare(time, e.time);
			}
			// If times are equal, an endpoint that starts an interval comes
			// first.
			return isStart && !e.isStart ? -1 : !isStart && e.isStart ? 1 : 0;
		}

	}

	public static int findMaxSimultaneousEvents(List<Event> A) {
		// Builds an array of all endpoints.
		List<Endpoint> E = new ArrayList<>();
		for (Event event : A) {
			E.add(new Endpoint(event.start, true));
			E.add(new Endpoint(event.finish, false));
		}
		// Sorts the endpoint array according to the time, breaking ties
		// by putting start times before end times.
		Collections.sort(E);

		// Track the number of simultaneous events, and record the maximum
		// number of simultaneous events.
		int maxNumSimultaneousEvents = 0, numSimultaneousEvents = 0;
		for (Endpoint endpoint : E) {
			if (endpoint.isStart) {
				++numSimultaneousEvents;
				maxNumSimultaneousEvents = Math.max(numSimultaneousEvents, maxNumSimultaneousEvents);
			} else {
				--numSimultaneousEvents;
			}
		}
		return maxNumSimultaneousEvents;
	}

	public static void main(String[] args) {
		Random gen = new Random();
		int n;
		if (args.length == 1) {
			n = Integer.parseInt(args[0]);
		} else {
			n = gen.nextInt(100000) + 1;
		}
		List<Event> A = new ArrayList<>(n);
		for (int i = 0; i < n; ++i) {
			int start = gen.nextInt(99999);
			int finish = gen.nextInt(start + 10000) + start + 1;
			A.add(new Event(start, finish));
		}
		int ans = findMaxSimultaneousEvents(A);
		System.out.println(ans);
	}
}

/*
Consider a coordinate system for the Milky Way, in which Earth is at $(0,0,0)$.
Model stars as points, and assume distances are in light years.
The Milky Way consists of approximately $10^{12}$ stars,
and their coordinates are stored in a file.
@problem
How would you compute the $k$ stars which are closest to Earth?
*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Random;

public class KClosest { 
	public static class Star implements Comparable<Star> {
		private double x, y, z;

		public Star(double x, double y, double z) {
			this.x = x;
			this.y = y;
			this.z = z;
		}

		public double distance() {
			return Math.sqrt(x * x + y * y + z * z);
		}

		@Override
		public int compareTo(Star rhs) {
			return Double.compare(this.distance(), rhs.distance());
		}
 
		@Override
		public String toString() {
			return "(" + x + "," + y + "," + z + ")";
		} 
	}

	public static List<Star> findClosestKStars(int k, Iterator<Star> stars) {
		// maxHeap to store the closest k stars seen so far.
		PriorityQueue<Star> maxHeap = new PriorityQueue<>(k, Collections.reverseOrder());
		while (stars.hasNext()) {
			// Add each star to the max-heap. If the max-heap size exceeds k,
			// remove
			// the maximum element from the max-heap.
			Star star = stars.next();
			maxHeap.add(star);
			if (maxHeap.size() == k + 1) {
				maxHeap.remove();
			}
		}

		List<Star> orderedStars = new ArrayList<Star>(maxHeap);
		// The only guarantee PriorityQueue makes about ordering is that the
		// maximum element comes first, so we sort orderedStars.
		Collections.sort(orderedStars);
		return orderedStars;
	}

	public static void main(String[] args) {
		Random r = new Random();
		for (int times = 0; times < 1000; ++times) {
			int num, k;
			if (args.length == 1) {
				num = Integer.parseInt(args[0]);
				k = r.nextInt(num) + 1;
			} else if (args.length == 2) {
				num = Integer.parseInt(args[0]);
				k = Integer.parseInt(args[1]);
			} else {
				num = r.nextInt(10000) + 1;
				k = r.nextInt(num) + 1;
			}
			List<Star> stars = new ArrayList<>();
			// Randomly generate num of stars
			for (int i = 0; i < num; ++i) {
				stars.add(new Star(r.nextInt(100001), r.nextInt(100001), r.nextInt(100001)));
			}
			List<Star> closestStars = findClosestKStars(k, stars.iterator());
			Collections.sort(closestStars);
			Collections.sort(stars);
			assert (0 == stars.get(k - 1).compareTo(closestStars.get(closestStars.size() - 1)));
		}
	}
}
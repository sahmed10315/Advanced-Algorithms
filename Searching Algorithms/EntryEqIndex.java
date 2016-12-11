 
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class EntryEqIndex {
 
	public static int searchEntryEqualToItsIndex(List<Integer> A) {
		int left = 0, right = A.size() - 1;
		while (left <= right) {
			int mid = left + ((right - left) / 2);
			int difference = A.get(mid) - mid;
			// A.get(mid) == mid if and only if difference == 0.
			if (difference == 0) {
				return mid;
			} else if (difference > 0) {
				right = mid - 1;
			} else { // difference < 0.
				left = mid + 1;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		Random r = new Random();
		for (int times = 0; times < 1000; ++times) {
			int n;
			Set<Integer> table = new HashSet<>();
			if (args.length == 1) {
				n = Integer.parseInt(args[0]);
			} else {
				n = r.nextInt(1000) + 1;
			}
			List<Integer> A = new ArrayList<>();
			for (int i = 0; i < n; ++i) {
				int x;
				do {
					x = r.nextInt(1999) - 999;
				} while (table.contains(x));
				table.add(x);
				A.add(x);
			}
			Collections.sort(A);
			int ans = searchEntryEqualToItsIndex(A);
			if (ans != -1) {
				System.out.println("A[" + ans + "] = " + A.get(ans));
				assert (A.get(ans) == ans);
			} else {
				System.out.println("no entry where A[k] = k");
			}
		}
	}
}

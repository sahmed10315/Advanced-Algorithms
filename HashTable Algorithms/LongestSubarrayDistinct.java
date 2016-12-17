
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class LongestSubarrayDistinct {
	// @include
	public static int longestSubarrayWithDistinctEntries(List<Integer> A) {
		// Records the most recent occurrences of each entry.
		Map<Integer, Integer> mostRecentOccurrence = new HashMap<>();
		int longestDupFreeSubarrayStartIdx = 0, result = 0;
		for (int i = 0; i < A.size(); ++i) {
			Integer dupIdx = mostRecentOccurrence.put(A.get(i), i);
			// A.get(i) appeared before. Did it appear in the longest current
			// subarray?
			if (dupIdx != null) {
				if (dupIdx >= longestDupFreeSubarrayStartIdx) {
					result = Math.max(result, i - longestDupFreeSubarrayStartIdx);
					longestDupFreeSubarrayStartIdx = dupIdx + 1;
				}
			}
		}
		result = Math.max(result, A.size() - longestDupFreeSubarrayStartIdx);
		return result;
	}

	public static void main(String[] args) {
		Random r = new Random();
		int n;
		if (args.length == 1) {
			n = Integer.parseInt(args[0]);
		} else {
			n = r.nextInt(1001);
		}
		System.out.println("n = " + n);
		for (int times = 0; times < 1000; ++times) {
			List<Integer> A = new ArrayList<>(n);
			for (int i = 0; i < n; i++) {
				A.add(r.nextInt(1001));
			}
			// System.out.println(A);
			int ans = longestSubarrayWithDistinctEntries(A); 
		}
	}
}
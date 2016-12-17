
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class SortKIncreasingDecreasingArray { 
	public static List<Integer> sortKIncreasingDecreasingArray(List<Integer> A) {
		// Decomposes A into a set of sorted arrays.
		List<List<Integer>> sortedSubarrays = new ArrayList<>();
		SubarrayType subarrayType = SubarrayType.INCREASING;
		int startIdx = 0;
		for (int i = 1; i <= A.size(); ++i) {
			if (i == A.size() // A is ended. Adds the last subarray
					|| (A.get(i - 1) < A.get(i) && subarrayType == SubarrayType.DECREASING)
					|| (A.get(i - 1) >= A.get(i) && subarrayType == SubarrayType.INCREASING)) {
				List<Integer> subList = A.subList(startIdx, i);
				if (subarrayType == SubarrayType.DECREASING) {
					Collections.reverse(subList);
				}
				sortedSubarrays.add(subList);
				startIdx = i;
				subarrayType = (subarrayType == SubarrayType.INCREASING ? SubarrayType.DECREASING
						: SubarrayType.INCREASING);
			}
		}
	//	return MergeKSortedArrays.mergeKSortedArray(sortedSubarrays);
		return A;
	}

	private static enum SubarrayType {
		INCREASING, DECREASING
	}

	public static void main(String[] args) {
			List<Integer> A = new ArrayList<>();
			A.add(57);
			A.add(131);A.add(493);A.add(294);A.add(221);A.add(339);A.add(418);A.add(452);A.add(442);A.add(190);
			List<Integer> ans = sortKIncreasingDecreasingArray(A);
		}
	
}
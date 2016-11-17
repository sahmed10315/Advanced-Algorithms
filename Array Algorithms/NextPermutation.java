
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class NextPermutation {
	public static <T> boolean equal(List<T> list1, List<T> list2) {
		if (list1.size() != list2.size()) {
			return false;
		}

		for (int i = 0; i < list1.size(); i++) {
			if (!list1.get(i).equals(list2.get(i))) {
				return false;
			}
		}

		return true;
	}

	// @include
	public static List<Integer> nextPermutation(List<Integer> perm) {
		int k = perm.size() - 2;
		while (k >= 0 && perm.get(k) >= perm.get(k + 1)) {
			--k;
		}
		if (k == -1) {
			return Collections.emptyList(); // perm is the last permutation.
		}

		// Swap the smallest entry after index k that is greater than perm[k].
		// We
		// exploit the fact that perm.subList(k + 1, perm.size()) is decreasing
		// so
		// if we search in reverse order, the first entry that is greater than
		// perm[k] is the smallest such entry.
		for (int i = perm.size() - 1; i > k; --i) {
			if (perm.get(i) > perm.get(k)) {
				Collections.swap(perm, k, i);
				break;
			}
		}

		// Since perm.subList[k + 1, perm.size()) is in decreasing order, we can
		// build the smallest dictionary ordering of this subarray by reversing
		// it.
		Collections.reverse(perm.subList(k + 1, perm.size()));
		return perm;
	}

	public static void main(String[] args) { 
			List<Integer> perm = new ArrayList<>();
			perm.add(1);
			perm.add(0);
			perm.add(3);
			perm.add(2);
			List<Integer> ans = nextPermutation(perm);
			System.out.println(ans);
 
	}
}
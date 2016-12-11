import java.util.List;

public class SortedMerge {
	public static void merge(int[] a, int[] b, int lastA, int lastB) {
		int indexMerged = lastB + lastA
				- 1; /* Index of last location of merged array */
		int indexA = lastA - 1; /* Index of last element in array b */
		int indexB = lastB - 1; /* Index of last element in array a */

		/* Merge a and b, starting from the last element in each */
		while (indexB >= 0) {
			if (indexA >= 0 && a[indexA] > b[indexB]) { /*
														 * end of a is bigger
														 * than end of b
														 */
				a[indexMerged] = a[indexA]; // copy element
				indexA--;
			} else {
				a[indexMerged] = b[indexB]; // copy element
				indexB--;
			}
			indexMerged--; // move indices
		}
	}

	public static void mergeTwoSortedArrays(List<Integer> A, int m, List<Integer> B, int n) {
		int a = m - 1, b = n - 1, writeIdx = m + n - 1;
		while (a >= 0 && b >= 0) {
			A.set(writeIdx--, A.get(a) > B.get(b) ? A.get(a--) : B.get(b--));
		}
		while (b >= 0) {
			A.set(writeIdx--, B.get(b--));
		}
	}

	public static void main(String[] args) {
		int[] a = { 2, 3, 4, 5, 6, 8, 10, 100, 0, 0, 0, 0, 0, 0 };
		int[] b = { 1, 4, 7, 6, 7, 7 };
		merge(a, b, 8, 6);
	}
}

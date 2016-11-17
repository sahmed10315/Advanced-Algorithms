import java.util.Arrays;

public class ApplyPermutation {
	
	public static void applyPermutation(int[] perm, char[] A) {
		for (int i = 0; i < A.length; ++i) {
			// Check if the element at index i has not been moved by checking if
			// perm[i] is nonnegative.
 			int next = i;
			while (perm[next] >= 0) {
				swap(A, i, perm[next]);
				int temp = perm[next];
				// Subtracts perm.length from an entry in perm to make it
				// negative,
				// which indicates the corresponding move has been performed.
				perm[next] = perm[next] - perm.length;
				next = temp;
			}
		}

		// Restore perm.
		for (int i = 0; i < perm.length; i++) {
			perm[i] = perm[i] + perm.length;
		}
	}

	private static void swap(char[] a, int i, int j) { 
		char temp = a[i];
		a[i] = a[j];
		a[j] = (char) temp;
	}

	public static void main(String[] args) {
		int [] perm = new int[] {2, 0, 1, 3};
		char [] arrA = new char [] {'a', 'b', 'c', 'd'};
		applyPermutation(perm , arrA);
		
		for(char c : arrA) {
			System.out.println(c);
		}
		
	}
}

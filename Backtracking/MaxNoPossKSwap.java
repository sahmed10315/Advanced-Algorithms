
public class MaxNoPossKSwap { 
	// doing at-most K swap operations on its digits.

	// function to find maximum integer possible by
	// doing at-most K swap operations on its digits
	static String findMaximumNum(char[] str, int k, String max) {
		// return if no swaps left
		if (k == 0)
			return null;

		int n = str.length;

		// consider every digit
		for (int i = 0; i < n - 1; i++) {

			// and compare it with all digits after it
			for (int j = i + 1; j < n; j++) {
				// if digit at position i is less than digit
				// at position j, swap it and check for maximum
				// number so far and recurse for remaining swaps
				if (str[i] < str[j]) {
					// swap str[i] with str[j]
					swap(str, i, j);

					// If current num is more than maximum so far
					if (Integer.parseInt(new String(str)) > Integer.parseInt(max))
						max = new String(str);

					// recurse of the other k - 1 swaps
					findMaximumNum(str, k - 1, max);

					// backtrack
					swap(str, i, j);
				}
			}
		}
		return max;
	}

	static void swap(char a[], int l, int r) {
		char temp = a[l];
		a[l] = a[r];
		a[r] = temp;
	}

	// Driver code
	public static void main(String[] args) {
		String str = "7599";

		int k = 2;

		String max = str;
		System.out.println(findMaximumNum(str.toCharArray(), k, max));

	}
 
}

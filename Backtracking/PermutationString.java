
public class PermutationString {
	static void swap(char a[], int l, int r) {
		char temp = a[l];
		a[l] = a[r];
		a[r] = temp;
	}

	static void permute(char a[], int l, int r) {
		if (l == r)
			System.out.println(new String(a));
		else {
			for (int i = l; i <= r; i++) {
				swap(a, l, i);
				permute(a, l + 1, r);
				swap(a, l, i); // backtrack
			}
		}
	}

	/* Driver program to test above functions */
	public static void main(String[] args) {
		String str = "AAA";
		permute(str.toCharArray(), 0, str.length() - 1);
	}
}

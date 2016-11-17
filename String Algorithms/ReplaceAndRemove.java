
public class ReplaceAndRemove {
	public static int replaceAndRemove(int size, char[] s) {
		// Forward iteration: remove "b"s and count the number of "a"s.
		int writeIdx = 0, aCount = 0;
		for (int i = 0; i < size; ++i) {
			if (s[i] != 'b') {
				s[writeIdx++] = s[i];
			}
			if (s[i] == 'a') {
				++aCount;
			}
		}

		// Backward iteration: replace "a"s with "dd"s starting from the end.
		int curIdx = writeIdx - 1;
		writeIdx = writeIdx + aCount - 1;
		final int finalSize = writeIdx + 1;
		while (curIdx >= 0) {
			if (s[curIdx] == 'a') {
				s[writeIdx--] = 'd';
				s[writeIdx--] = 'd';
			} else {
				s[writeIdx--] = s[curIdx];
			}
			--curIdx;
		}
		return finalSize;
	}

	public static void main(String[] args) {
		String s = "acdbbca";
		char[] arr = s.toCharArray();
		int finalSize = replaceAndRemove(s.length(), arr);
		StringBuilder ans = new StringBuilder();
		for (int i = 0; i < finalSize; ++i) {
			ans.append(arr[i]);
		}

		System.out.println(ans);
	}
}
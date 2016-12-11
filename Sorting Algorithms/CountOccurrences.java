import java.util.Arrays;

public class CountOccurrences {
	public static void countOccurrences(String s) {
		char[] a = s.toCharArray();
		Arrays.sort(a);

		int currentCharacterCount = 1;
		for (int i = 1; i < a.length; i++) {
			if (a[i] == a[i - 1]) {
				++currentCharacterCount;
			} else {
				System.out.println("(" + a[i - 1] + ", " + currentCharacterCount + ")");
				currentCharacterCount = 1;
			}
		}
		System.out.println("(" + a[a.length - 1] + "," + currentCharacterCount + ")");
	}
}

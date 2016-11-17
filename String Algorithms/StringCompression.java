
public class StringCompression {

	String compress(String str) {
		StringBuilder compressed = new StringBuilder();

		int countCon = 0;

		for (int i = 0; i < str.length(); i++) {
			countCon++;

			if (str.charAt(i) != str.charAt(i + 1) || i + 1 >= str.length()) {
				compressed.append(str.charAt(i));
				compressed.append(countCon);
				countCon = 0;
			}
		}

		return compressed.length() < str.length() ? compressed.toString() : str;
	}
}

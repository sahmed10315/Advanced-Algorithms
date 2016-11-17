
public class ReverseWords {

	public static void reverseSplit(String str) {

		String[] strArray = str.split(" ");
		StringBuffer sb = new StringBuffer();
		for (int i = strArray.length - 1; i >= 0; i--) {
			sb.append(strArray[i]);
			sb.append(" ");
		}
		System.out.println(sb.toString());
	}

	private static void reverseWords(String str) {
		StringBuilder sb = new StringBuilder(str);
		// Step 1 : Reverse individual words
		short startWord = 0;
		for (int i = 0; i < sb.length(); i++) {
			if (sb.charAt(i) == ' ') {
				reverseWord(sb, startWord, i - 1);
				startWord = (short) (i + 1);
			} else if (i == sb.length() - 1) {
				reverseWord(sb, startWord, i);
			}
		}
		// Step 2: Reverse whole word
		reverseWord(sb, (short) 0, sb.length() - 1);
		System.out.println(sb.toString());
	}

	private static void reverseWord(StringBuilder sb, short start_word, int end_word) {
		while (start_word < end_word) {
			char temp = sb.charAt(start_word);
			sb.setCharAt(start_word, sb.charAt(end_word));
			sb.setCharAt(end_word, temp);
			start_word++;
			end_word--;
		}
	}

	public static void main(String[] args) {
		reverseSplit("i like this program very much");
		reverseWords("i like this program very much");
	}
}
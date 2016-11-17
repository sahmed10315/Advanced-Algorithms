
public class ColumnEncoding {

	public static int ssDecodeColID(final String col) {
		int result = 0;
		for (int i = 0; i < col.length(); i++) {
			char c = col.charAt(i);
			result = result * 26 + c - 'A' + 1;
		}
		return result;
	}

	public static void main(String[] args) {
		System.out.println(ssDecodeColID("ZZ"));
	}
}

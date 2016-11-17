
import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
	public static int romanToInteger(String s) {
		Map<Character, Integer> T = new HashMap<Character, Integer>() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			{
				put('I', 1);
				put('V', 5);
				put('X', 10);
				put('L', 50);
				put('C', 100);
				put('D', 500);
				put('M', 1000);
			}
		};

		int sum = T.get(s.charAt(s.length() - 1));
		for (int i = s.length() - 2; i >= 0; --i) {
			if (T.get(s.charAt(i)) < T.get(s.charAt(i + 1))) {
				sum -= T.get(s.charAt(i));
			} else {
				sum += T.get(s.charAt(i));
			}
		}
		return sum;
	}

	public static void main(String[] args) {
		System.out.println(7 == romanToInteger("VII"));
		System.out.println(9 == romanToInteger("IX"));
	}
}
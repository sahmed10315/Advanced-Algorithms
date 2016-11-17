import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BigNoArrayMultiplication {
	public static List<Integer> multiply(List<Integer> num1, List<Integer> num2) {
		final int sign = num1.get(0) < 0 ^ num2.get(0) < 0 ? -1 : 1;
		num1.set(0, Math.abs(num1.get(0)));
		num2.set(0, Math.abs(num2.get(0)));

		List<Integer> result = new ArrayList<>(Collections.nCopies(num1.size() + num2.size(), 0));
		for (int i = num1.size() - 1; i >= 0; --i) {
			for (int j = num2.size() - 1; j >= 0; --j) {
				result.set(i + j + 1, result.get(i + j + 1) + num1.get(i) * num2.get(j));
				result.set(i + j, result.get(i + j) + result.get(i + j + 1) / 10);
				result.set(i + j + 1, result.get(i + j + 1) % 10);
			}
		}
		// Remove the leading zeroes.
		int first_not_zero = 0;
		while (first_not_zero < result.size() && result.get(first_not_zero) == 0) {
			++first_not_zero;
		}
		result = result.subList(first_not_zero, result.size());
		if (result.isEmpty()) {
			return Arrays.asList(0);
		}
		result.set(0, result.get(0) * sign);
		return result;
	}

	private static String listToString(List<Integer> A) {
		StringBuilder result = new StringBuilder();
		for (int a : A) {
			result.append(a);
		}
		return result.toString();
	}

	public static void main(String[] args) {
		List<Integer> s1, s2;
		s1 = Arrays.asList(3, 2, 1);
		s2 = Arrays.asList(1, 2, 3);

		List<Integer> temp1 = new ArrayList<>(s1), temp2 = new ArrayList<>(s2);
		List<Integer> res = multiply(temp2, temp1);
		System.out.println(String.format("%s * %s = %s", listToString(s1), listToString(s2), listToString(res)));

		System.out.println("multiplying using Java's BigInteger...");
		BigInteger result = new BigInteger(listToString(s1)).multiply(new BigInteger(listToString(s2)));
		System.out.println("answer = " + result.toString());

		assert (listToString(res).equals(result.toString()));
	}
}
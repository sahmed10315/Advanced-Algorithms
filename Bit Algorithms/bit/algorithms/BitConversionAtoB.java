package bit.algorithms;

public class BitConversionAtoB {

	public static int bitSwapRequired(int a, int b) {
		int count = 0;
		for (int c = a ^ b; c != 0; c = c & (c - 1)) {
			count++;
		}
		return count;
	}

	public static void main(String[] args) {
		int a = -23432;
		int b = 512132;
		System.out.println("Required number of bits: " + bitSwapRequired(a, b));
	}

}

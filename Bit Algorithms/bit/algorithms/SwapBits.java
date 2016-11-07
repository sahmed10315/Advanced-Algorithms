package bit.algorithms;
 

public class SwapBits {
	public static long swapBits(long x, int i, int j) {
		// Extract the i-th and j-th bits, and see if they differ.
		if (((x >>> i) & 1) != ((x >>> j) & 1)) {
			// i-th and j-th bits differ. We will swap them by flipping their
			// values.
			// Select the bits to flip with bitMask. Since x^1 = 0 when x = 1
			// and 1
			// when x = 0, we can perform the flip XOR.
			long bitMask = (1L << i) | (1L << j);
			x ^= bitMask;
		}
		return x;
	}

	public static void main(String[] args) {
		System.out.println (swapBits(47, 1, 4));
		System.out.println (swapBits(28, 0, 2));
	}
}
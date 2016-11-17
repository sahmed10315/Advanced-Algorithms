

public class NextNumber {
	public static int getNext(int n) {
		int c = n;
		int c0 = 0;
		int c1 = 0;
		while (((c & 1) == 0) && (c != 0)) {
			c0++;
			c >>= 1;
		}

		while ((c & 1) == 1) {
			c1++;
			c >>= 1;
		}

		/*
		 * If c is 0, then n is a sequence of 1s followed by a sequence of 0s.
		 * This is already the biggest number with c1 ones. Return error.
		 */
		if (c0 + c1 == 31 || c0 + c1 == 0) {
			return -1;
		}

		int pos = c0 + c1; // position of right-most non-trailing zero (where
							// the right most bit is bit 0)

		/*
		 * Flip the right-most non-trailing zero (which will be at position pos)
		 */
		n |= (1 << pos); // Flip right-most non-trailing zero

		/*
		 * Clear all bits to the right of pos. Example with pos = 5 (1) Shift 1
		 * over by 5 to create 0..0100000 [ mask = 1 << pos ] (2) Subtract 1 to
		 * get 0..0011111 [ mask = mask - 1 ] (3) Flip all the bits by using '~'
		 * to get 1..1100000 [ mask = ~mask ] (4) AND with n
		 */
		n &= ~((1 << pos) - 1); // Clear all bits to the right of pos

		/*
		 * Put (ones-1) 1s on the right by doing the following: (1) Shift 1 over
		 * by (ones-1) spots. If ones = 3, this gets you 0..0100 (2) Subtract
		 * one from that to get 0..0011 (3) OR with n
		 */
		n |= (1 << (c1 - 1)) - 1;

		return n;
	}

	public static int getNextBruteForce(int i) {

		int num_ones = countOnes(i);
		i++;
		while (countOnes(i) != num_ones) {
			i++;
		}
		return i;
	}

	public static int countOnes(int i) {
		int count = 0;
		while (i > 0) {
			if ((i & 1) == 1) {
				count++;
			}
			i = i >> 1;
		}
		return count;
	}

	public static void main(String[] args) {
		int i = 13948;
		System.out.println(getNext(i));
		i = 5;
		System.out.println(getNext(i));
	}
}

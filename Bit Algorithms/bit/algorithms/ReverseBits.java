package bit.algorithms;

public class ReverseBits {
	private static long[] precomputedReverse = new long[(1 << 16)];

	private static long reverseBits(long x, int n) {
		for (int i = 0, j = n; i < j; ++i, --j) {
			x = SwapBits.swapBits(x, i, j);
		}
		return x;
	}

	private static void createPrecomputedTable() {
		for (int i = 0; i < (1 << 16); ++i) {
			precomputedReverse[i] = reverseBits(i, 15);
		}
	}
 
	public static long reverseBits(long x) {
		final int WORD_SIZE = 16;
		final int BIT_MASK = 0xFFFF; 
		return precomputedReverse[(int) (x & BIT_MASK)] << (3 * WORD_SIZE)
				| precomputedReverse[(int) ((x >>> WORD_SIZE) & BIT_MASK)] << (2 * WORD_SIZE)
				| precomputedReverse[(int) ((x >>> (2 * WORD_SIZE)) & BIT_MASK)] << WORD_SIZE
				| precomputedReverse[(int) ((x >>> (3 * WORD_SIZE)) & BIT_MASK)];
	}

	public static void main(String[] args) {
		createPrecomputedTable();
		System.out.println(reverseBits(63));
	}
}


public class Parity {
	public static short parity(long x) {
		short result = 0;
		while (x != 0) {
			result ^= (x & 1); 
			x >>>= 1; 
		}
		return result;
	} 
	
	// slowest implementation, bit by bit
	private static short parityBitByBit(long x) {
		short result = 0;
		for (int i = 0; i < 64; i++) {
			result ^= 1 & (x >> i);
		}
		return result;
	}

	private static short parityBitByBitSmart(long x) {
		short result = 0;
		while (x != 0) {
			result ^= 1;
			x &= (x - 1); // Drops the lowest set bit of x.
		}
		return result;
	}

	// very fast implementation, uses associativity
	private static short parityAssoc(long x) {
		x ^= x >>> 32;
		x ^= x >>> 16;
		x ^= x >>> 8;
		x ^= x >>> 4;
		x ^= x >>> 2;
		x ^= x >>> 1;
		return (short) (x & 0x1);
	}

	// another very fast implementation, uses lookuptable
	private static short[] precomputedParity;

	static {
		precomputedParity = new short[1 << 16];
		for (int i = 0; i < (1 << 16); ++i) {
			precomputedParity[i] = Parity.parity(i);
		}
	}

	public static short parityTable(long x) {
		final int WORD_SIZE = 16;
		final int BIT_MASK = 0xFFFF; 
		int offset = WORD_SIZE;
		short result = precomputedParity[(int) (x & BIT_MASK)];
		x = x >>> offset;
		result ^= precomputedParity[(int) (x) & BIT_MASK];
		x = x >>> offset;
		result ^= precomputedParity[(int) (x) & BIT_MASK];
		x = x >>> offset;
		result ^= precomputedParity[(int) (x) & BIT_MASK];
		return result; 
	}

	public static void main(String[] args) { 
		System.out.println(parity(121472));
		System.out.println(parityBitByBit(121472));
		System.out.println(parityBitByBitSmart(121472));
		System.out.println(parityAssoc(121472));
		System.out.println(parityTable(121472));
	}
}

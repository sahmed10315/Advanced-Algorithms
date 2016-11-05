package bit.algorithms;

public class NumOnes {

	static int numOnesInBinary(int no) {
		int numOnes = 0;
		while (no != 0) {
			if ((no & 1) == 1) {
				numOnes++;
			}
			no >>>= 1;
		}
		return numOnes;
	}

	static int numOnesInBinaryOptimized(int no) {
		int numOnes = 0;
		while (no != 0) {
			no &= (no - 1);
			numOnes++;
		}
		return numOnes;
	}

	public static void main(String[] args) {
		System.out.println(numOnesInBinary(111));
		System.out.println(numOnesInBinaryOptimized(111));
	}
}

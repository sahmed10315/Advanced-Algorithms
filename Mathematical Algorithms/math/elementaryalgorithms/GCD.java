package math.elementaryalgorithms;
/*
 * Euclid algorithm for finding greatest common divisor.
 * Time complexity for both iterative and recursive: O(logB) 
 * Space complexity of recursive: O(logB) 
*/
public class GCD {

	static int euclidGCD(int a, int b) {
		int dividend = a >= b ? a : b;
		int divisor = a <= b ? a : b;
		
		while (divisor != 0) {
			int remainder = dividend % divisor;
			dividend = divisor;
			divisor = remainder;
		}
		
		return dividend;
	}
	
	static int euclidGCDRecursive(int a, int b) {
		return b == 0 ? a : euclidGCDRecursive(b, a % b);
	}
	
	public static void main(String [] args) {
		System.out.println(euclidGCD(350, 105));
		System.out.println(euclidGCDRecursive(350, 105));
	}
}

package math.elementaryalgorithms;

/* Computers factorial recursively and iteratively
 * Time, Space complexity of recursive: O(N), O(N)
 * Time, Space complexity of iterative: O(N), O(1) 
 */

public class Factorial {
	public static void main(String [] args) {
		System.out.println(isFactorialRecursively(7));
		System.out.println(isFactorialIteratively(7));
	}

	static int isFactorialRecursively(int n ) {
		if (n < 0) 
			return -1;
		else if(n == 0)
			return 1;
		else 
			return n * isFactorialRecursively(n - 1);
	}
	
	static int isFactorialIteratively(int n) {
		int factorial = 1;
		
		for (int i = 1 ; i <= n ; i++)
			factorial = factorial*i;
		
		return factorial;
	}
}
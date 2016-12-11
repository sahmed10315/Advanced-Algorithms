package math.elementaryalgorithms;

/* Fibonacci implemented iteratively, recursively and through memoization 
 * Run time, space time of Iterative: O(N), O(1)
 * Run time, space time of Recursive: O(2^N), O(N)
 * Run time, space time of Memoization: O(N), O(N)
 * */
public class Fibonacci {

	public static void main(String[] args) {
		System.out.println(fibonacciRecursive(5));
		System.out.println(fibonacciIteratively(550));
		System.out.println(fibonacciMemoization(550));
		for (int i = 1; i < 10; i++)
			System.out.print(fibonacciRecursive(i) + ", ");
	}

	static int fibonacciRecursive(int n) {
		if (n <= 0)
			return 0;
		else if (n == 1)
			return 1;
		// tail recursion
		return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
	}

	static int fibonacciIteratively(int n) {
		if (n == 1 || n == 2)
			return 1;

		int prev1 = 1, prev2 = 1, sum = 1;

		for (int i = 3; i <= n; i++) {
			sum = prev1 + prev2;
			prev1 = prev2;
			prev2 = sum;
		}
		return sum;
	}

	static int fibonacciMemoization(int n) {
		int[] memo = new int[n + 1];
		return fib(n, memo);
	}

	static int fib(int n, int[] memo) {
		if (n <= 0)
			return 0;
		else if (n == 1)
			return 1;
		else if (memo[n] > 0)
			return memo[n];

		memo[n] = fib(n - 1, memo) + fib(n - 2, memo);
		
		return memo[n];
	}
}
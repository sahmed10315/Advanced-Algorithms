package stacks.algorithms;

import java.util.Stack;

public class LongestParenthesis {
	// C++ program to find length of the longest valid
	// substring

	static int findMaxLen(String str) {
		int n = str.length();

		// Create a stack and push -1 as initial index to it.
		Stack<Integer> stk = new Stack<Integer>();
		stk.push(-1);

		// Initialize result
		int result = 0;

		// Traverse all characters of given string
		for (int i = 0; i < n; i++) {
			// If opening bracket, push index of it
			if (str.charAt(i) == '(')
				stk.push(i);

			else // If closing bracket, i.e.,str[i] = ')'
			{
				// Pop the previous opening bracket's index
				stk.pop();

				// Check if this length formed with base of
				// current valid substring is more than max
				// so far
				if (!stk.empty())
					result = Math.max(result, i - stk.peek());

				// If stack is empty. push current index as
				// base for next valid substring (if any)
				else
					stk.push(i);
			}
		}

		return result;
	}

	// Driver program
	public static void main(String[] args) {
		String str = "((()()";
		findMaxLen(str);

		str = "()(()))))";
		findMaxLen(str);
		str = "((((())))()";
		findMaxLen(str);
		str = "()))())";
		findMaxLen(str);
	}
}

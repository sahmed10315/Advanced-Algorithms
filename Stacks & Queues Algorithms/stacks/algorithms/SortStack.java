package stacks.algorithms;

import java.util.Stack;

public class SortStack { 

	public static void sort(Stack<Integer> s) {
		Stack<Integer> r = new Stack<Integer>();
		while (!s.isEmpty()) {
			/* Insert each element in s in sorted order into r. */
			int tmp = s.pop();
			while (!r.isEmpty() && r.peek() > tmp) {
				s.push(r.pop());
			}
			r.push(tmp);
		}

		/* Copy the elements back. */
		while (!r.isEmpty()) {
			s.push(r.pop());
		}
	}

	public static void main(String[] args) {
		Stack<Integer> s = new Stack<Integer>();
		sort(s);
		while (!s.isEmpty()) {
			System.out.println(s.pop());
		}
	}
	
}
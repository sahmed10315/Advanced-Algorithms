package stacks.algorithms;

import java.util.Stack;

public class PrintAncesostorsBT {
	static class Node {
		private int data;
		private Node left;
		private Node right;

		Node(int data) {
			this.data = data;
			left = null;
			right = null;
		}
	}

	// Iterative Function to print all ancestors of a given key
	void printAncestors(Node root, int key) {
		Stack<Node> stack = new Stack<>();

		if (root == null)
			return;

		while (true) {
			while (root != null && root.data != key) {
				stack.add(root);
				root = root.left;
			}

			if (root != null && root.data == key)
				break;

			if (stack.peek().right == null) {
				root = stack.pop();
				while (!stack.isEmpty() && stack.peek().right == root)
					root = stack.pop();
			}
			root = (stack.isEmpty()) ? null : stack.peek().right;
		}
		while (!stack.isEmpty())
			System.out.print(stack.pop().data + " ");

	}
}

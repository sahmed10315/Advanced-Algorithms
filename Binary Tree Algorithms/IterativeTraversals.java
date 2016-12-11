import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack; 

public class IterativeTraversals {
	/* Class containing left and right child of current
	 node and key value*/
	class Node {
		int key;
		Node left, right;

		public Node(int item) {
			key = item;
			left = right = null;
		}
	}
	Node root = null;
	/* Iterative implementation using a stack for in order traversal */
	void iterativeInorder() {
		if (root == null) {
			return;
		}

		// keep the nodes in the path that are waiting to be visited
		Stack<Node> stack = new Stack<Node>();
		Node node = root;

		// first node to be visited will be the left one
		while (node != null) {
			stack.push(node);
			node = node.left;
		}

		// traverse the tree
		while (stack.size() > 0) {
			// visit the top node
			node = stack.pop();
			System.out.print(node.key + " ");
			if (node.right != null) {
				node = node.right;

				// the next node to be visited is the leftmost
				while (node != null) {
					stack.push(node);
					node = node.left;
				}
			}
		}
	}

	void iterativePreorder() {
		iterativePreorder(root);
	}

	/* An iterative process to print preorder traversal of Binary tree */
	void iterativePreorder(Node node) {

		// Base Case
		if (node == null) {
			return;
		}

		// Create an empty stack and push root to it
		Stack<Node> nodeStack = new Stack<Node>();
		nodeStack.push(root);

		/*
		 * Pop all items one by one. Do following for every popped item a) print
		 * it b) push its right child c) push its left child Note that right
		 * child is pushed first so that left is processed first
		 */
		while (nodeStack.isEmpty() == false) {

			// Pop the top item from stack and print it
			Node mynode = nodeStack.peek();
			System.out.print(mynode.key + " ");
			nodeStack.pop();

			// Push right and left children of the popped node to stack
			if (mynode.right != null) {
				nodeStack.push(mynode.right);
			}
			if (mynode.left != null) {
				nodeStack.push(mynode.left);
			}
		}
	}

	/* Iterative Post order traversal using two stacks */
	public void iterativePostOrder(Node root) {
		if (root == null)
			return;

		Stack<Node> stack1 = new Stack<Node>();
		Stack<Node> stack2 = new Stack<Node>();
		Node node = null;

		stack1.push(root);

		while (!stack1.isEmpty()) {
			node = stack1.pop();
			stack2.push(node);

			if (node.left != null)
				stack1.push(node.left);
			if (node.right != null)
				stack1.push(node.right);
		}

		while (!stack2.isEmpty()) {
			node = stack2.pop();
			System.out.print(node.key + " ");
		}
	}

	/* Level order traversal done iteratively through queue */
	void iterativeLevelOrder() {
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		while (!queue.isEmpty()) {

			/* poll() removes the present head. */
			Node tempNode = queue.poll();
			System.out.print(tempNode.key + " ");

			/* Enqueue left child */
			if (tempNode.left != null) {
				queue.add(tempNode.left);
			}

			/* Enqueue right child */
			if (tempNode.right != null) {
				queue.add(tempNode.right);
			}
		}
	}
}

package queue.algorithms;

import java.util.LinkedList;
import java.util.Queue;

public class MaxLevelSumBT {
	// A queue based C++ program to find maximum sum
	// of a level in Binary Tree

	/*
	 * A binary tree node has data, pointer to left child and a pointer to right
	 * child
	 */
	static class Node {
		int data;
		Node left, right;
	}

	// Function to find the maximum sum of a level in tree
	// using level order traversal
	int maxLevelSum(Node root) {
		// Base case
		if (root == null)
			return 0;

		// Initialize result
		int result = root.data;

		// Do Level order traversal keeping track of number
		// of nodes at every level.
		Queue<Node> q = new LinkedList<>();
		q.add(root);
		while (!q.isEmpty()) {
			// Get the size of queue when the level order
			// traversal for one level finishes
			int count = q.size();

			// Iterate for all the nodes in the queue currently
			int sum = 0;
			while (count-- > 0) {
				// Dequeue an node from queue
				Node temp = q.poll();

				// Add this node's value to current sum.
				sum = sum + temp.data;

				// Enqueue left and right children of
				// dequeued node
				if (temp.left != null)
					q.add(temp.left);
				if (temp.right != null)
					q.add(temp.right);
			}

			// Update the maximum node count value
			result = Math.max(sum, result);
		}

		return result;
	}

	int main() {

		return 0;
	}
}

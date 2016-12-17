package queue.algorithms;
// An iterative java program to find height of binary tree

import java.util.LinkedList;
import java.util.Queue;

public class HeightOfTree {

	// A binary tree node
	class Node {
		int data;
		Node left, right;

		Node(int item) {
			data = item;
			left = right;
		}
	}

	class BinaryTree {
		Node root;

		// Iterative method to find height of Bianry Tree
		int treeHeight(Node node) {
			// Base Case
			if (node == null)
				return 0;

			// Create an empty queue for level order tarversal
			Queue<Node> q = new LinkedList();

			// Enqueue Root and initialize height
			q.add(node);
			int height = 0;

			while (true) {
				// nodeCount (queue size) indicates number of nodes
				// at current lelvel.
				int nodeCount = q.size();
				if (nodeCount == 0)
					return height;
				height++;

				// Dequeue all nodes of current level and Enqueue all
				// nodes of next level
				while (nodeCount > 0) {
					Node newnode = q.peek();
					q.remove();
					if (newnode.left != null)
						q.add(newnode.left);
					if (newnode.right != null)
						q.add(newnode.right);
					nodeCount--;
				}
			}
		}
	}

	// Driver program to test above functions
	public static void main(String args[]) { 
	}
}

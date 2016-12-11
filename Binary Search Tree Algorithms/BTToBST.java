import java.util.Arrays;

public class BTToBST {

	/* Class containing left and right child of current node and key value */
	class Node {
		int key;
		Node left, right;

		public Node(int item) {
			key = item;
			left = right = null;
		}
	}

	// Root of BST
	Node root;

	// Constructor
	BTToBST() {
		root = null;
	}

	// This function converts a given Binary Tree to BST
	void binaryTreeToBST(Node root) {
		// base case: tree is empty
		if (root == null)
			return;

		/*
		 * Count the number of nodes in Binary Tree so that we know the size of
		 * temporary array to be created
		 */
		int n = size(root);

		// Create a temp array arr[] and store inorder traversal of tree in
		// arr[]
		int[] arr = new int[n];
		int i = 0;
		storeInorder(root, arr, i);

		Arrays.sort(arr);

		// Copy array elements back to Binary Tree
		i = 0;
		arrayToBST(arr, root, i);
	}

	/* Computes number of nodes in tree */
	int size(Node node) {
		if (node == null)
			return 0;
		else
			return (size(node.left) + 1 + size(node.right));
	}

	/*
	 * A helper function that stores inorder traversal of a tree rooted with
	 * node
	 */
	void storeInorder(Node node, int inorder[], int index) {
		// Base Case
		if (node == null)
			return;

		/* first store the left subtree */
		storeInorder(node.left, inorder, index);

		/* Copy the root's data */
		inorder[index++] = node.key;

		/* finally store the right subtree */
		storeInorder(node.right, inorder, index);
	}

	/*
	 * A helper function that copies contents of arr[] to Binary Tree. This
	 * functon basically does Inorder traversal of Binary Tree and one by one
	 * copy arr[] elements to Binary Tree nodes
	 */
	void arrayToBST(int[] arr, Node root, int index) {
		// Base Case
		if (root == null)
			return;

		/* first update the left subtree */
		arrayToBST(arr, root.left, index);

		/* Now update root's data and increment index */
		root.key = arr[index++];

		/* finally update the right subtree */
		arrayToBST(arr, root.right, index);
	}
}

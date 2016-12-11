
public class IsBST {

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
	IsBST() {
		root = null;
	}
	/*
	 * returns true if given search tree is binary search tree (efficient
	 * version)
	 */
	boolean isBST() {
		return isBSTUtil(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	/*
	 * Returns true if the given tree is a BST and its values are >= min and <=
	 * max.
	 */
	boolean isBSTUtil(Node node, int min, int max) {
		/* an empty tree is BST */
		if (node == null)
			return true;

		/* false if this node violates the min/max constraints */
		if (node.key < min || node.key > max)
			return false;

		/*
		 * otherwise check the subtrees recursively tightening the min/max
		 * constraints
		 */
		// Allow only distinct values
		return (isBSTUtil(node.left, min, node.key - 1) && isBSTUtil(node.right, node.key + 1, max));
	}
}

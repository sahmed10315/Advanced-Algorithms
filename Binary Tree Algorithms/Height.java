public class Height {
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
	/*
	 * Compute the "height" of a tree -- the number of nodes along the longest
	 * path from the root node down to the farthest leaf node.
	 */
	int height(Node root) {
		if (root == null)
			return 0;
		else {
			/* compute height of each subtree */
			int lheight = height(root.left);
			int rheight = height(root.right);

			/* use the larger one */
			if (lheight > rheight)
				return (lheight + 1);
			else
				return (rheight + 1);
		}
	}

	/* Much simpler version of finding height of a binary tree */
	public int heightOtherVersion(Node root) {
		if (root == null) {
			return -1;
		}
		return Math.max(heightOtherVersion(root.left), heightOtherVersion(root.right)) + 1;
	}
}

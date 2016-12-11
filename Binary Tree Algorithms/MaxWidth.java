public class MaxWidth {
	/*
	 * Class containing left and right child of current node and key value
	 */
	class Node {
		int key;
		Node left, right;

		public Node(int item) {
			key = item;
			left = right = null;
		}
	}

	/* Much simpler version of finding height of a binary tree */
	public int height(Node root) {
		if (root == null) {
			return -1;
		}
		return Math.max(height(root.left), height(root.right)) + 1;
	}

	/* Function to get the maximum width of a binary tree */
	int getMaxWidth(Node node) {
		int maxWidth = 0;
		int width;
		int h = height(node);
		int i;

		/*
		 * Get width of each level and compare the width with maximum width so
		 * far
		 */
		for (i = 1; i <= h; i++) {
			width = getWidth(node, i);
			if (width > maxWidth)
				maxWidth = width;
		}

		return maxWidth;
	}

	/* Get width of a given level */
	int getWidth(Node node, int level) {
		if (node == null)
			return 0;

		if (level == 1)
			return 1;
		else if (level > 1)
			return getWidth(node.left, level - 1) + getWidth(node.right, level - 1);
		return 0;
	}
}

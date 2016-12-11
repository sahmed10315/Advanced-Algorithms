public class GetLevelOfANode {
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
	 * Helper function for getLevel(). It returns level of the data if data is
	 * present in tree, otherwise returns 0.
	 */
	int getLevelUtil(Node node, int data, int level) {
		if (node == null)
			return 0;

		if (node.key == data)
			return level;

		int downlevel = getLevelUtil(node.left, data, level + 1);
		if (downlevel != 0)
			return downlevel;

		downlevel = getLevelUtil(node.right, data, level + 1);
		return downlevel;
	}

	/* Returns level of given data value */
	int getLevel(Node node, int data) {
		return getLevelUtil(node, data, 1);
	}
}

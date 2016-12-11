
public class KeysInGivenRange {
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
	KeysInGivenRange() {
		root = null;
	}
	/*
	 * The functions prints all the keys which in the given range [k1..k2]. The
	 * function assumes than k1 < k2
	 */
	void printKeysInGvnRange(Node node, int k1, int k2) {

		/* base case */
		if (node == null) {
			return;
		}

		/*
		 * Since the desired o/p is sorted, recurse for left subtree first If
		 * root->data is greater than k1, then only we can get o/p keys in left
		 * subtree
		 */
		if (k1 < node.key) {
			printKeysInGvnRange(node.left, k1, k2);
		}

		/* if root's data lies in range, then prints root's data */
		if (k1 <= node.key && k2 >= node.key) {
			System.out.print(node.key + " ");
		}

		/*
		 * If root->data is smaller than k2, then only we can get o/p keys in
		 * right subtree
		 */
		if (k2 > node.key) {
			printKeysInGvnRange(node.right, k1, k2);
		}
	}
}

public class IsBalanced {
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
	/* Returns true if binary tree with root as root is height-balanced */
	boolean isBalanced(Node node) {
		int lh; /* for height of left subtree */

		int rh; /* for height of right subtree */

		/* If tree is empty then return true */
		if (node == null)
			return true;

		/* Get the height of left and right sub trees */
		lh = height(node.left);
		rh = height(node.right);

		if (Math.abs(lh - rh) > 1)
			return false;

		return isBalanced(node.left) && isBalanced(node.right);
	}
	public static int checkHeight(TreeNode1 root) {
		if (root == null) {
			return -1;
		}
		int leftHeight = checkHeight(root.left);
		if (leftHeight == Integer.MIN_VALUE)
			return Integer.MIN_VALUE; // Propagate error up

		int rightHeight = checkHeight(root.right);
		if (rightHeight == Integer.MIN_VALUE)
			return Integer.MIN_VALUE; // Propagate error up

		int heightDiff = leftHeight - rightHeight;
		if (Math.abs(heightDiff) > 1) {
			return Integer.MIN_VALUE; // Found error -> pass it back
		} else {
			return Math.max(leftHeight, rightHeight) + 1;
		}
	}

	public static boolean isBalanced(TreeNode1 root) {
		return checkHeight(root) != Integer.MIN_VALUE;
	}

	public static void main(String[] args) {
		// Create balanced tree
		int[] array = { 0, 1, 2, 3, 5, 6, 7, 8, 9, 10 };
		TreeNode1 root = TreeNode1.createMinimalBST(array);

		System.out.println("Is balanced? " + isBalanced(root));

		root.insertInOrder(4); // Add 4 to make it unbalanced

		System.out.println("Is balanced? " + isBalanced(root));
	}

}

class TreeNode1 {
	public int data;
	public TreeNode1 left;
	public TreeNode1 right;
	public TreeNode1 parent;
	private int size = 0;

	public TreeNode1(int d) {
		data = d;
		size = 1;
	}

	private void setLeftChild(TreeNode1 left) {
		this.left = left;
		if (left != null) {
			left.parent = this;
		}
	}

	private void setRightChild(TreeNode1 right) {
		this.right = right;
		if (right != null) {
			right.parent = this;
		}
	}

	public void insertInOrder(int d) {
		if (d <= data) {
			if (left == null) {
				setLeftChild(new TreeNode1(d));
			} else {
				left.insertInOrder(d);
			}
		} else {
			if (right == null) {
				setRightChild(new TreeNode1(d));
			} else {
				right.insertInOrder(d);
			}
		}
		size++;
	}

	public int size() {
		return size;
	}
 
	public int height() {
		int leftHeight = left != null ? left.height() : 0;
		int rightHeight = right != null ? right.height() : 0;
		return 1 + Math.max(leftHeight, rightHeight);
	}
 
	private static TreeNode1 createMinimalBST(int arr[], int start, int end) {
		if (end < start) {
			return null;
		}
		int mid = (start + end) / 2;
		TreeNode1 n = new TreeNode1(arr[mid]);
		n.setLeftChild(createMinimalBST(arr, start, mid - 1));
		n.setRightChild(createMinimalBST(arr, mid + 1, end));
		return n;
	}

	public static TreeNode1 createMinimalBST(int array[]) {
		return createMinimalBST(array, 0, array.length - 1);
	}

}

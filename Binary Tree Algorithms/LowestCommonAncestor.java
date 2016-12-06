
public class LowestCommonAncestor {

	public static TreeNode1 commonAncestorWithParent(TreeNode1 p, TreeNode1 q) {
		if (p == q)
			return p;

		TreeNode1 ancestor = p;
		while (ancestor != null) {
			if (isOnPath(ancestor, q)) {
				return ancestor;
			}
			// ancestor = ancestor.parent;
		}
		return null;
	}

	public static boolean isOnPath(TreeNode1 ancestor, TreeNode1 node) {
		while (node != ancestor && node != null) {
			// node = node.parent;
		}
		return node == ancestor;
	}

	public static TreeNode1 commonAncestorWitoutParent(TreeNode1 root, TreeNode1 p, TreeNode1 q) {
		if (!covers(root, p) || !covers(root, q)) { // Error check - one node is
													// not in tree
			return null;
		}
		return ancestorHelper(root, p, q);
	}

	public static TreeNode1 ancestorHelper(TreeNode1 root, TreeNode1 p, TreeNode1 q) {
		if (root == null || root == p || root == q) {
			return root;
		}

		boolean pIsOnLeft = covers(root.left, p);
		boolean qIsOnLeft = covers(root.left, q);
		if (pIsOnLeft != qIsOnLeft) { // Nodes are on different side
			return root;
		}
		TreeNode1 childSide = pIsOnLeft ? root.left : root.right;
		return ancestorHelper(childSide, p, q);
	}

	public static boolean covers(TreeNode1 root, TreeNode1 p) {
		if (root == null)
			return false;
		if (root == p)
			return true;
		return covers(root.left, p) || covers(root.right, p);
	}

	TreeNode1 lcaBst(TreeNode1 node, int n1, int n2) {
		if (node == null)
			return null;

		// If both n1 and n2 are smaller than root, then LCA lies in left
		if (node.data > n1 && node.data > n2)
			return lcaBst(node.left, n1, n2);

		// If both n1 and n2 are greater than root, then LCA lies in right
		if (node.data < n1 && node.data < n2)
			return lcaBst(node.right, n1, n2);

		return node;
	}

	public static void main(String[] args) {
		int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		TreeNode1 n3 = null;
		TreeNode1 n7 = null;
		TreeNode1 ancestor = commonAncestorWithParent(n3, n7);
		System.out.println(ancestor.data);
	}
}

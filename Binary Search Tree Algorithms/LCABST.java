
public class LCABST {
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
}

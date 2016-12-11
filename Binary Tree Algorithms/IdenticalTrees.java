public class IdenticalTrees {

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

	/* Returns true/false if tree a, and tree b are identical */
	boolean identicalTrees(Node a, Node b) {
		/* 1. both empty */
		if (a == null && b == null)
			return true;

		/* 2. both non-empty -> compare them */
		if (a != null && b != null)
			return (a.key == b.key && identicalTrees(a.left, b.left) && identicalTrees(a.right, b.right));

		/* 3. one empty, one not -> false */
		return false;
	}
}

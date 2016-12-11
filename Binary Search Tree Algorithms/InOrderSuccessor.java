
public class InOrderSuccessor {
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
	InOrderSuccessor() {
		root = null;
	}

	Node inOrderSuccessorContainingParent(Node root, Node n) {

		if (n.right != null) {
			return minValue1(n.right);
		}
		return n;

//	//	Node p = n.parent;
//		while (p != null && n == p.right) {
//			n = p;
//		//	p = p.parent;
//		}
//		return p;
	}

	Node inOrderSuccessor(Node root, Node n) {
		// step 1 of the above algorithm
		if (n.right != null)
			return minValue1(n.right);

		Node succ = null;

		// Start from root and search for successor down the tree
		while (root != null) {
			if (n.key < root.key) {
				succ = root;
				root = root.left;
			} else if (n.key > root.key)
				root = root.right;
			else
				break;
		}

		return succ;
	}

	Node minValue1(Node node) {
		Node current = node;

		/* loop down to find the leftmost leaf */
		while (current.left != null) {
			current = current.left;
		}
		return current;
	}
}

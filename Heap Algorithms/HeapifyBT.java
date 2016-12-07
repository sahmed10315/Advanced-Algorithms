import java.util.Arrays;
import java.util.Comparator;

public class HeapifyBT {
	class Node {
		int key;
		Node left, right;

		public Node(int item) {
			key = item;
			left = right = null;
		}
	}

	public static Node heapifyBinaryTreeUsingArray(Node root) {
		int size = traverse(root, 0, null); // Count nodes
		Node[] nodeArray = new Node[size];
		traverse(root, 0, nodeArray); // Load nodes into array
		// Sort array of nodes based on their values, using Comparator object
		Arrays.sort(nodeArray, new Comparator<Node>() {
			@Override
			public int compare(Node m, Node n) {
				int mv = m.key, nv = n.key;
				return (mv < nv ? -1 : (mv == nv ? 0 : 1));
			}
		});
		// Reassign children for each node
		for (int i = 0; i < size; i++) {
			int left = 2 * i + 1;
			int right = left + 1;
			nodeArray[i].left = (left >= size ? null : nodeArray[left]);
			nodeArray[i].right = (right >= size ? null : nodeArray[right]);
		}
		return nodeArray[0]; // Return new root node
	}

	public static int traverse(Node node, int count, Node[] arr) {
		if (node == null)
			return count;
		if (arr != null)
			arr[count] = node;
		count++;
		count = traverse(node.left, count, arr);
		count = traverse(node.right, count, arr);
		return count;
	}

	void preorder(Node root) {
		if (root == null)
			return;
		heapifyBinaryTreeUsingBT(root, null);
		preorder(root.left);
		preorder(root.right);
	}

	void heapifyBinaryTreeUsingBT(Node root, Node prev) {
		if (root == null)
			return;
		heapifyBinaryTreeUsingBT(root.left, root);
		heapifyBinaryTreeUsingBT(root.right, root);
		if (prev != null && root.key > prev.key) {
			swapper(root, prev);
		}
	}

	void swapper(Node node1, Node node2) {
		int temp = node1.key;
		node1.key = node2.key;
		node2.key = temp;
	}
}

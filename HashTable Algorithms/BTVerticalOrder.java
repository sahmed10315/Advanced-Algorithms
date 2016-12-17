
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class BTVerticalOrder {
	static class Node {
		private int data;
		private Node left;
		private Node right;

		public Node(int data) {
			this.data = data;
		}

		public int getData() {
			return data;
		}

		public void setData(int data) {
			this.data = data;
		}

		public Node getLeft() {
			return left;
		}

		public void setLeft(Node left) {
			this.left = left;
		}

		public Node getRight() {
			return right;
		}

		public void setRight(Node right) {
			this.right = right;
		}
	}

	private Node rootNode;

	public static void main(String[] args) {
		new BTVerticalOrder();
	}

	public BTVerticalOrder() {
		addNode(rootNode, 1);
		addNode(rootNode, 2);
		addNode(rootNode, 3);
		addNode(rootNode, 4);
		addNode(rootNode, 5);
		addNode(rootNode, 6);
		addNode(rootNode, 7);

		TreeMap<Integer, String> map = new TreeMap<Integer, String>();
		printTreeInVerticalOrder(rootNode, map, 0);

		for (Map.Entry<Integer, String> entry : map.entrySet()) {
			System.out.println(entry.getValue());
		}
	}

	private void printTreeInVerticalOrder(Node rootNode, TreeMap<Integer, String> map, int hd) {
		if (rootNode == null) {
			return;
		}

		if (map.get(hd) != null) {
			map.put(hd, map.get(hd) + "," + rootNode.getData());
		} else {
			map.put(hd, String.valueOf(rootNode.getData()));
		}

		printTreeInVerticalOrder(rootNode.getLeft(), map, hd - 1);
		printTreeInVerticalOrder(rootNode.getRight(), map, hd + 1);
	}

	private void addNode(Node rootNode, int data) {

		// First check is there any Nodes present.
		if (rootNode == null) {
			// No Nodes are Present, create one and assign it to startNode
			Node temp1 = new Node(data);
			this.rootNode = temp1;
		} else {
			// Nodes present, So check the proper position where to add New
			// Node.

			// Checking whether Left child and Right child are present for root
			// Node.
			if (rootNode.getLeft() != null && rootNode.getRight() != null) {
				// Left and Right Child exist, Also, we need to add ne Node in
				// Sequential Fashion of Left and Right,
				// We have to scan all Levels one by one to check a proper place
				// for new Node.
				// Also, we for each and every node we need to check whether
				// Left and Right Exist,
				// So we need to store them for later Processing that is why we
				// introduced Queue.

				Queue<Node> queue = new LinkedList<Node>();
				queue.add(rootNode);

				while (!queue.isEmpty()) {
					Node obj = (Node) queue.poll();
					if (obj.getLeft() != null && obj.getRight() != null) {
						queue.add(obj.getLeft());
						queue.add(obj.getRight());
					} else if (obj.getLeft() == null) {
						Node temp1 = new Node(data);
						obj.setLeft(temp1);
						break;
					} else {
						Node temp1 = new Node(data);
						obj.setRight(temp1);
						break;
					}
				}

			} else {
				// We reach this condition when either Left or Right is Null,
				// but not sure which side is Null.
				if (rootNode.getLeft() == null) {
					Node temp1 = new Node(data);
					rootNode.setLeft(temp1);
				} else {
					Node temp1 = new Node(data);
					rootNode.setRight(temp1);
				}
			}
		}
	}
}

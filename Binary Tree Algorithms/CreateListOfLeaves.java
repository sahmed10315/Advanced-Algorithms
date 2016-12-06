import java.util.LinkedList;
import java.util.List; 

public class CreateListOfLeaves {

	static class BinaryTreeNode<T> {
		BinaryTreeNode<T> left;
		BinaryTreeNode<T> right;
		T data;

		BinaryTreeNode(T data) {
			this.data = data;
		}
	}

	public static List<BinaryTreeNode<Integer>> createListOfLeaves(BinaryTreeNode<Integer> tree) {
		List<BinaryTreeNode<Integer>> leaves = new LinkedList<>();
		addLeavesLeftToRight(tree, leaves);
		return leaves;
	}

	private static void addLeavesLeftToRight(BinaryTreeNode<Integer> tree, List<BinaryTreeNode<Integer>> leaves) {
		if (tree != null) {
			if (tree.left == null && tree.right == null) {
				leaves.add(tree);
			} else {
				addLeavesLeftToRight(tree.left, leaves);
				addLeavesLeftToRight(tree.right, leaves);
			}
		}
	}
	// @exclude

	public static void main(String[] args) {
		// 3
		// 2 5
		// 1 4 6 
	}
}

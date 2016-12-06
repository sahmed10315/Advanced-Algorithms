
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ReconstructPreorderWithNull {

	static class BinaryTreeNode<T> {
		BinaryTreeNode<T> left;
		BinaryTreeNode<T> right;
		T data;

		BinaryTreeNode(T data) {
			this.data = data;
		}
	}

	// Global variable, tracks current subtree.
	private static Integer subtreeIdx;

	public static BinaryTreeNode<Integer> reconstructPreorder(List<Integer> preorder) {
		subtreeIdx = 0;
		return reconstructPreorderSubtree(preorder);
	}

	// Reconstructs the subtree that is rooted at subtreeIdx.
	private static BinaryTreeNode<Integer> reconstructPreorderSubtree(List<Integer> preorder) {
		Integer subtreeKey = preorder.get(subtreeIdx++);
		
		if (subtreeKey == null) {
			return null;
		}
		// Note that reconstructPreorderSubtree updates subtreeIdx. So the order
		// of
		// following two calls are critical.
		BinaryTreeNode<Integer> tnode = new BinaryTreeNode<Integer>(subtreeKey);
		tnode.left = reconstructPreorderSubtree(preorder);
		tnode.right = reconstructPreorderSubtree(preorder);
		return tnode;
	}

	private static <T> void genPreorderWithNull(BinaryTreeNode<T> n, List<T> p) {
		if (n == null) {
			p.add(null);
			return;
		}

		p.add(n.data);
		genPreorderWithNull(n.left, p);
		genPreorderWithNull(n.right, p);
	}

	public static void main(String[] args) {
	}
}

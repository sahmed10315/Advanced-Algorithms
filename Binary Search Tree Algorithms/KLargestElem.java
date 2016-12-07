
import java.util.ArrayList;
import java.util.List;

public class KLargestElem {
	static class BSTNode<T> {
		public T data;
		public BSTNode<T> left, right;
	}

	public static List<Integer> findKLargestInBST(BSTNode<Integer> tree, int k) {
		List<Integer> kLargestElements = new ArrayList<>();
		findKLargestInBSTHelper(tree, k, kLargestElements);
		return kLargestElements;
	}

	private static void findKLargestInBSTHelper(BSTNode<Integer> tree, int k, List<Integer> kLargestElements) {
		// Perform reverse inorder traversal.
		if (tree != null && kLargestElements.size() < k) {
			findKLargestInBSTHelper(tree.right, k, kLargestElements);
			if (kLargestElements.size() < k) {
				kLargestElements.add(tree.data);
				findKLargestInBSTHelper(tree.left, k, kLargestElements);
			}
		}
	}

	public static void main(String[] args) {
	}
}
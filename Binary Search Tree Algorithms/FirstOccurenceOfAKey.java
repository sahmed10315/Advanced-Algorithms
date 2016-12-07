
public class FirstOccurenceOfAKey {
	static class BSTNode<T> {
		public T data;
		public BSTNode<T> left, right;
	}

	public static BSTNode<Integer> findFirstEqualK(BSTNode<Integer> tree, int k) {
		if (tree == null) {
			return null;
		} else if (tree.data == k) {
			BSTNode<Integer> node = findFirstEqualK(tree.left, k);
			return node != null ? node : tree;
		}
		return findFirstEqualK(tree.data < k ? tree.right : tree.left, k);
	}

}

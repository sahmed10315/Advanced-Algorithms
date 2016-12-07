/*
@summary
Write a program that takes as input a BST and
a value, and returns the node whose key equals the
input value and appears first in an inorder traversal of the BST.
For example, when applied to the BST in Figure~\vref{bst-first-occurrence-fig},
your program should return Node $B$ for $108$, Node $G$ for $285$, and null for
$143$.
Your initial attempt can use recursion, but your final solution cannot.
*/

public class LargerThanKey {
	static class BSTNode<T> {
		public T data;
		public BSTNode<T> left, right;
	}

	public static BSTNode<Integer> findFirstGreaterThanK(BSTNode<Integer> tree, Integer k) {
		BSTNode<Integer> subtree = tree, firstSoFar = null;
		while (subtree != null) {
			if (subtree.data > k) {
				firstSoFar = subtree;
				subtree = subtree.left;
			} else { // Root and all keys in left-subtree are <= k, so skip
						// them.
				subtree = subtree.right;
			}
		}
		return firstSoFar;
	} 

	public static void main(String[] args) {}
}

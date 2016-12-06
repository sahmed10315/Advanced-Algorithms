public class SumRootToLeaf {

	static class BinaryTreeNode<T> {
		BinaryTreeNode<T> left;
		BinaryTreeNode<T> right;
		T data;
		
		BinaryTreeNode(T data) {
			this.data = data;
		}
	}
	public static int sumRootToLeaf(BinaryTreeNode<Integer> tree) {
		return sumRootToLeafHelper(tree, 0);
	}

	private static int sumRootToLeafHelper(BinaryTreeNode<Integer> tree, int partialPathSum) {
		if (tree == null) {
			return 0;
		}

		partialPathSum = partialPathSum * 2 + tree.data;
		if (tree.left == null && tree.right == null) { // Leaf.
			return partialPathSum;
		}
		// Non-leaf.
		return sumRootToLeafHelper(tree.left, partialPathSum) + sumRootToLeafHelper(tree.right, partialPathSum);
	}

	public static void main(String[] args) { 
	    BinaryTreeNode<Integer> root = new BinaryTreeNode<>(1);
	    int result = sumRootToLeaf(root); 
	    root.left = new BinaryTreeNode<>(0); 
	    root.left.left = new BinaryTreeNode<>(0);  
	    root.left.left.left = new BinaryTreeNode<>(0);  
	    root.left.left.right = new BinaryTreeNode<>(1);   
	    root.left.right = new BinaryTreeNode<>(1);  
	    root.left.right.right = new BinaryTreeNode<>(1); 
	    root.left.right.left = new BinaryTreeNode<>(0);
	    root.right = new BinaryTreeNode<>(1); 
	    root.right.left = new BinaryTreeNode<>(0);  
	    root.right.right = new BinaryTreeNode<>(0);
	    root.right.right.right = new BinaryTreeNode<>(0);
	    root.right.left.right = new BinaryTreeNode<>(0);
	    root.right.left.right.right = new BinaryTreeNode<>(0);
	    root.right.left.right.left = new BinaryTreeNode<>(1);
	    root.right.left.right.left.right = new BinaryTreeNode<>(1);
	    result = sumRootToLeaf(root); 
	    System.out.println(result);
	}
}
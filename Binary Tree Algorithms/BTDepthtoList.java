

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
 
public class BTDepthtoList {

	public static void createLevelLinkedList(TreeNode1 root, ArrayList<LinkedList<TreeNode1>> lists, int level) {
		if (root == null) return;
		LinkedList<TreeNode1> list = null;
		if (lists.size() == level) { // Level not contained in list
			list = new LinkedList<TreeNode1>();
			/* Levels are always traversed in order. So, if this is the first time we've visited level i,
			 * we must have seen levels 0 through i - 1. We can therefore safely add the level at the end. */
			lists.add(list);  
		} else {
			list = lists.get(level);
		}
		list.add(root);
		createLevelLinkedList(root.left, lists, level + 1);
		createLevelLinkedList(root.right, lists, level + 1);
	}
	
	public static ArrayList<LinkedList<TreeNode1>> createLevelLinkedListDFS(TreeNode1 root) {
		ArrayList<LinkedList<TreeNode1>> lists = new ArrayList<LinkedList<TreeNode1>>();
		createLevelLinkedList(root, lists, 0);
		return lists;
	}	
	

	public static ArrayList<LinkedList<TreeNode1>> createLevelLinkedListBFS(TreeNode1 root) {
		ArrayList<LinkedList<TreeNode1>> result = new ArrayList<LinkedList<TreeNode1>>();
		
		/* "Visit" the root */
		LinkedList<TreeNode1> current = new LinkedList<TreeNode1>();
		if (root != null) {
			current.add(root);
		}
		
		while (current.size() > 0) {
			result.add(current); // Add previous level
			LinkedList<TreeNode1> parents = current; // Go to next level
			current = new LinkedList<TreeNode1>(); 
			for (TreeNode1 parent : parents) {
				/* Visit the children */
				if (parent.left != null) {
					current.add(parent.left);
				}
				if (parent.right != null) {
					current.add(parent.right);
				}
			}
		}

		return result;
	}
	
	public static void printResult(ArrayList<LinkedList<TreeNode1>> result){
		int depth = 0;
		for(LinkedList<TreeNode1> entry : result) {
			Iterator<TreeNode1> i = entry.listIterator();
			System.out.print("Link list at depth " + depth + ":");
			while(i.hasNext()){
				System.out.print(" " + ((TreeNode1)i.next()).data);
			}
			System.out.println();
			depth++;
		}
	}
	

	public static void main(String[] args) { 
		ArrayList<LinkedList<TreeNode1>> list = createLevelLinkedListDFS(null);
		printResult(list);
	}


}

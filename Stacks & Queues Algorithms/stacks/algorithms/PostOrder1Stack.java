package stacks.algorithms;

import java.util.Deque;
import java.util.LinkedList;

public class PostOrder1Stack {

	static class Node {
		private int data;
		private Node left;
		private Node right;

		Node(int data) {
			this.data = data;
			left = null;
			right = null;
		}
	}
	public void postOrderItrOneStack(Node root){
        Node current = root;
        Deque<Node> stack = new LinkedList<>();
        while(current != null || !stack.isEmpty()){
            if(current != null){
                stack.addFirst(current);
                current = current.left;
            }else{
                Node temp = stack.peek().right;
                if (temp == null) {
                    temp = stack.poll();
                    System.out.print(temp.data + " ");
                    while (!stack.isEmpty() && temp == stack.peek().right) {
                        temp = stack.poll();
                        System.out.print(temp.data + " ");
                    }
                } else {
                    current = temp;
                }
            }
        }
    }
}

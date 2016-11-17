
import java.util.Stack;

public class ListPalindrome {
	static class LinkedListNode {
		public LinkedListNode(int data2) {
			this.data = data2;
		}

		public LinkedListNode() {
		}

		int data;
		LinkedListNode next;
	}

	public static boolean isPalindrome(LinkedListNode head) {
		LinkedListNode reversed = reverseAndClone(head);
		return isEqual(head, reversed);
	}

	public static LinkedListNode reverseAndClone(LinkedListNode node) {
		LinkedListNode head = null;
		while (node != null) {
			LinkedListNode n = new LinkedListNode(node.data); // Clone
			n.next = head;
			head = n;
			node = node.next;
		}
		return head;
	}

	public static boolean isEqual(LinkedListNode one, LinkedListNode two) {
		while (one != null && two != null) {
			if (one.data != two.data) {
				return false;
			}
			one = one.next;
			two = two.next;
		}
		return one == null && two == null;
	}

	public static boolean isPalindrome1(LinkedListNode head) {
		LinkedListNode fast = head;
		LinkedListNode slow = head;

		Stack<Integer> stack = new Stack<Integer>();

		while (fast != null && fast.next != null) {
			stack.push(slow.data);
			slow = slow.next;
			fast = fast.next.next;
		}

		/* Has odd number of elements, so skip the middle */
		if (fast != null) {
			slow = slow.next;
		}

		while (slow != null) {
			int top = stack.pop().intValue();
			if (top != slow.data) {
				return false;
			}
			slow = slow.next;
		}
		return true;
	}

	public static void main(String[] args) {
		LinkedListNode node = new LinkedListNode();
		node.data = 0;
		node.next = (new LinkedListNode());
		node.next.data = 1;

		node.next.next = (new LinkedListNode());
		node.next.next.data = 2;

		node.next.next.next = (new LinkedListNode());
		node.next.next.next.data = 2;

		node.next.next.next.next = (new LinkedListNode());
		node.next.next.next.next.data = 1;

		node.next.next.next.next.next = (new LinkedListNode());
		node.next.next.next.next.next.data = 0;

		node.next.next.next.next.next.next = null;
		System.out.println(isPalindrome(node));
	}

}

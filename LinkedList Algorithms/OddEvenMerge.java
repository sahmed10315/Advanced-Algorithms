public class OddEvenMerge {
	static class Node {
		int data;
		Node next;
	}

	// Rearranges given linked list such that all even
	// positioned nodes are before odd positioned.
	// Returns new head of linked List.
	Node rearrangeEvenOdd(Node head) {
		// Corner case
		if (head == null)
			return null;

		// Initialize first nodes of even and
		// odd lists
		Node odd = head;
		Node even = head.next;

		// Remember the first node of even list so
		// that we can connect the even list at the
		// end of odd list.
		Node evenFirst = even;

		while (true) {
			// If there are no more nodes, then connect
			// first node of even list to the last node
			// of odd list
			if (odd == null || even == null || (even.next == null)) {
				odd.next = evenFirst;
				break;
			}

			// Connecting odd nodes
			odd.next = even.next;
			odd = even.next;

			// If there are NO more even nodes after
			// current odd.
			if (odd.next == null) {
				even.next = null;
				odd.next = evenFirst;
				break;
			}

			// Connecting even nodes
			even.next = odd.next;
			even = odd.next;
		}

		return head;
	}
}

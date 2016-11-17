public class SumLists {
	static class ListNode<T> {
		public ListNode(int i, ListNode<Integer> l) {
			// TODO Auto-generated constructor stub
		}

		T data;
		ListNode<T> next;
	}

	public static ListNode<Integer> addTwoNumbers(ListNode<Integer> L1, ListNode<Integer> L2) {
		ListNode<Integer> dummyHead = new ListNode<>(0, null);
		ListNode<Integer> placeIter = dummyHead;
		int carry = 0;
		while (L1 != null || L2 != null) {
			int sum = carry;
			if (L1 != null) {
				sum += L1.data;
				L1 = L1.next;
			}
			if (L2 != null) {
				sum += L2.data;
				L2 = L2.next;
			}
			placeIter.next = new ListNode<>(sum % 10, null);
			carry = sum / 10;
			placeIter = placeIter.next;
		}
		// carry cannot exceed 1, so we never need to add more than one node.
		if (carry > 0) {
			placeIter.next = new ListNode<>(carry, null);
		}
		return dummyHead.next;
	}

	static class LinkedListNode {
		int data;
		LinkedListNode next;
	}

	public static LinkedListNode addLists(LinkedListNode l1, LinkedListNode l2, int carry) {
		if (l1 == null && l2 == null && carry == 0) {
			return null;
		}

		LinkedListNode result = new LinkedListNode();
		int value = carry;
		if (l1 != null) {
			value += l1.data;
		}
		if (l2 != null) {
			value += l2.data;
		}
		result.data = value % 10;
		if (l1 != null || l2 != null) {
			LinkedListNode more = addLists(l1 == null ? null : l1.next, l2 == null ? null : l2.next,
					value >= 10 ? 1 : 0);
			result.next = more;
		}
		return result;
	}

	public static int linkedListToInt(LinkedListNode node) {
		int value = 0;
		// if (node.next != null) {
		// value = 10 * linkedListToInt(node.next);
		// }
		// return value + node.data;

		while (node != null) {
			value *= 10;
			value += node.data;
			node = node.next;
		}
		return value;
	}

	public static void main(String[] args) {

		LinkedListNode node = new LinkedListNode();
		node.data = 1;
		node.next = (new LinkedListNode());
		node.next.data = 4;

		node.next.next = (new LinkedListNode());
		node.next.next.data = 3;

		node.next.next.next = (new LinkedListNode());
		node.next.next.next.data = 2;

		node.next.next.next.next = (new LinkedListNode());
		node.next.next.next.next.data = 5;

		node.next.next.next.next.next = (new LinkedListNode());
		node.next.next.next.next.next.data = 2;

		node.next.next.next.next.next.next = (new LinkedListNode());
		node.next.next.next.next.next.next.data = 1;

		node.next.next.next.next.next.next.next = null;

		int l1 = linkedListToInt(node);
		int l2 = 0;
		int l3 = 0;
		System.out.print(l1 + " + " + l2 + " = " + l3 + "\n");
		System.out.print(l1 + " + " + l2 + " = " + (l1 + l2));
	}
}

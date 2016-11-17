
public class PartitionList {
	static class LinkedListNode {
		int data;
		LinkedListNode next;
	}

	public static LinkedListNode partition(LinkedListNode node, int x) {
		LinkedListNode head = node;
		LinkedListNode tail = node;

		/* Partition list */
		while (node != null) {
			LinkedListNode next = node.next;
			if (node.data < x) {
				/* Insert node at head. */
				node.next = head;
				head = node;
			} else {
				/* Insert node at tail. */
				tail.next = node;
				tail = node;
			}
			node = next;
		}
		tail.next = null;

		return head;
	}

	public static LinkedListNode partition1(LinkedListNode node, int x) {
		LinkedListNode beforeStart = null;
		LinkedListNode afterStart = null;

		/* Partition list */
		while (node != null) {
			LinkedListNode next = node.next;
			if (node.data < x) {
				/* Insert node into start of before list */
				node.next = beforeStart;
				beforeStart = node;
			} else {
				/* Insert node into front of after list */
				node.next = afterStart;
				afterStart = node;
			}
			node = next;
		}

		/* Merge before list and after list */
		if (beforeStart == null) {
			return afterStart;
		}

		LinkedListNode head = beforeStart;
		while (beforeStart.next != null) {
			beforeStart = beforeStart.next;
		}
		beforeStart.next = afterStart;
		return head;
	}

	public static LinkedListNode partition3(LinkedListNode node, int x) {
		LinkedListNode beforeStart = null;
		LinkedListNode beforeEnd = null;
		LinkedListNode afterStart = null;
		LinkedListNode afterEnd = null;

		/* Partition list */
		while (node != null) {
			LinkedListNode next = node.next;
			node.next = null;
			if (node.data < x) {
				if (beforeStart == null) {
					beforeStart = node;
					beforeEnd = beforeStart;
				} else {
					beforeEnd.next = node;
					beforeEnd = node;
				}
			} else {
				if (afterStart == null) {
					afterStart = node;
					afterEnd = afterStart;
				} else {
					afterEnd.next = node;
					afterEnd = node;
				}
			}
			node = next;
		}

		/* Merge before list and after list */
		if (beforeStart == null) {
			return afterStart;
		}

		beforeEnd.next = afterStart;
		return beforeStart;
	}

	public static LinkedListNode listPivoting(LinkedListNode L, int x) {
		LinkedListNode lessHead = new LinkedListNode();
		LinkedListNode equalHead = new LinkedListNode();
		LinkedListNode greaterHead = new LinkedListNode();
		LinkedListNode lessIter = lessHead;
		LinkedListNode equalIter = equalHead;
		LinkedListNode greaterIter = greaterHead;
		// Populates the three lists.
		LinkedListNode iter = L;
		while (iter != null) {
			if (iter.data < x) {
				lessIter.next = iter;
				lessIter = iter;
			} else if (iter.data == x) {
				equalIter.next = iter;
				equalIter = iter;
			} else { // iter.data > x.
				greaterIter.next = iter;
				greaterIter = iter;
			}
			iter = iter.next;
		}
		// Combines the three lists.
		greaterIter.next = null;
		equalIter.next = greaterHead.next;
		lessIter.next = equalHead.next;
		return lessHead.next;
	}

	public static void main(String[] args) {
		LinkedListNode node = new LinkedListNode();
		node.data = 3;
		node.next = (new LinkedListNode());
		node.next.data = 2;

		node.next.next = (new LinkedListNode());
		node.next.next.data = 2;

		node.next.next.next = (new LinkedListNode());
		node.next.next.next.data = 11;

		node.next.next.next.next = (new LinkedListNode());
		node.next.next.next.next.data = 7;

		node.next.next.next.next.next = (new LinkedListNode());
		node.next.next.next.next.next.data = 5;

		node.next.next.next.next.next.next = (new LinkedListNode());
		node.next.next.next.next.next.next.data = 11;

		node.next.next.next.next.next.next.next = null;

		LinkedListNode curr = node;

		while (curr != null) {
			System.out.println(curr.data);
			curr = curr.next;
		}
		System.out.println();
		curr = node;
		LinkedListNode curr1 = partition3(curr, 7);
		while (curr1 != null) {
			System.out.println(curr1.data);
			curr1 = curr1.next;
		}
		System.out.println();
		curr1 = listPivoting(curr, 7);
		while (curr1 != null) {
			System.out.println(curr1.data);
			curr1 = curr1.next;
		}
		
	}
}

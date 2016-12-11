
public class MergeSortLinkList {
	/* Link list node */
	static class Node {
		int data;
		Node next;
	}

	/* sorts the linked list by changing next pointers (not data) */
	void MergeSort(Node head) {
		Node a = null;
		Node b = null;

		/* Base case -- length 0 or 1 */
		if ((head == null) || (head.next == null)) {
			return;
		}

		/* Split head into 'a' and 'b' sublists */
		FrontBackSplit(head, a, b);

		/* Recursively sort the sublists */
		MergeSort(a);
		MergeSort(b);

		/* answer = merge the two sorted lists together */
		head = SortedMerge(a, b);
	}

	/*
	 * See http://geeksforgeeks.org/?p=3622 for details of this function
	 */
	Node SortedMerge(Node a, Node b) {
		Node result = null;

		/* Base cases */
		if (a == null)
			return (b);
		else if (b == null)
			return (a);

		/* Pick either a or b, and recur */
		if (a.data <= b.data) {
			result = a;
			result.next = SortedMerge(a.next, b);
		} else {
			result = b;
			result.next = SortedMerge(a, b.next);
		}
		return (result);
	}

	/*
	 * Split the nodes of the given list into front and back halves, and return
	 * the two lists using the reference parameters. If the length is odd, the
	 * extra node should go in the front list. Uses the fast/slow pointer
	 * strategy.
	 */
	void FrontBackSplit(Node source, Node frontRef, Node backRef) {
		Node fast;
		Node slow;
		if (source == null || source.next == null) {
			/* length < 2 cases */
			frontRef = source;
			backRef = null;
		} else {
			slow = source;
			fast = source.next;

			/* Advance 'fast' two nodes, and advance 'slow' one node */
			while (fast != null) {
				fast = fast.next;
				if (fast != null) {
					slow = slow.next;
					fast = fast.next;
				}
			}

			/*
			 * 'slow' is before the midpoint in the list, so split it in two at
			 * that point.
			 */
			frontRef = source;
			backRef = slow.next;
			slow.next = null;
		}
	}
}

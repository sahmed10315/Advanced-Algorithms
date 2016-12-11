
public class InsertionSortLinkList {
	Node head; // head of list

	/* Linked list Node */
	class Node {
		int data;
		Node next;

		Node(int d) {
			data = d;
			next = null;
		}
	}

	// function to sort a singly linked list using insertion sort
	void insertionSort(Node head) {
		// Initialize sorted linked list
		Node sorted = null;

		// Traverse the given linked list and insert every
		// node to sorted
		Node current = head;
		while (current != null) {
			// Store next for next iteration
			Node next = current.next;

			// insert current in sorted linked list
			sortedInsert(sorted, current);

			// Update current
			current = next;
		}

		// Update head_ref to point to sorted linked list
		head = sorted;
	}

	/* function to insert a new_node in a list. */
	void sortedInsert(Node head, Node new_node) {
		Node current;

		/* Special case for head node */
		if (head == null || head.data >= new_node.data) {
			new_node.next = head;
			head = new_node;
		} else {

			/* Locate the node before point of insertion. */
			current = head;

			while (current.next != null && current.next.data < new_node.data)
				current = current.next;

			new_node.next = current.next;
			current.next = new_node;
		}
	}
}

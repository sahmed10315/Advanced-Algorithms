
public class KthToLast {
	static class Node {
		int data;
		Node next;
	}
	Node kthToLast(Node head, int k) {
		Node p1 = head;
		Node p2 = head;

		for (int i = 0; i < k && p1 != null; i++)
			p1= p1.next;
		
		while(p1 != null) {
			p1 = p1.next;
			p2 = p2.next;
		}
		
		return p2;
	}
}

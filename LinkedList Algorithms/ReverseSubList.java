public class ReverseSubList {
	static class ListNode<T> {
		public ListNode(int i, ListNode<Integer> l) {
		}

		T data;
		ListNode<T> next;
	}

	public static ListNode<Integer> reverseSublist(ListNode<Integer> L, int start, int finish) {
		if (start == finish) { // No need to reverse since start == finish.
			return L;
		}

		ListNode<Integer> dummyHead = new ListNode<Integer>(0, L);
		ListNode<Integer> sublistHead = dummyHead;
		int k = 1;
		while (k++ < start) {
			sublistHead = sublistHead.next;
		}

		// Reverse sublist.
		ListNode<Integer> sublistIter = sublistHead.next;
		while (start++ < finish) {
			ListNode<Integer> temp = sublistIter.next;
			sublistIter.next = temp.next;
			temp.next = sublistHead.next;
			sublistHead.next = temp;
		}
		return dummyHead.next;
	}

	public static void main(String[] args) {
	}
}
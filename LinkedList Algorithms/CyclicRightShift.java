public class CyclicRightShift {
	static class ListNode<T> {
		public ListNode(int i, ListNode<Integer> l) {
		}

		T data;
		ListNode<T> next;
	}

	public static ListNode<Integer> cyclicallyRightShiftList(ListNode<Integer> L, int k) {
		if (L == null) {
			return L;
		}

		// Computes the length of L and the tail.
		ListNode<Integer> tail = L;
		int n = 1;
		while (tail.next != null) {
			++n;
			tail = tail.next;
		}
		k %= n;
		if (k == 0) {
			return L;
		}

		tail.next = L; // Makes a cycle by connecting the tail to the head.
		int stepsToNewHead = n - k;
		ListNode<Integer> newTail = tail;
		while (stepsToNewHead-- > 0) {
			newTail = newTail.next;
		}
		ListNode<Integer> newHead = newTail.next;
		newTail.next = null;
		return newHead;
	}

	public static void main(String[] args) {
		ListNode<Integer> L;
		L = new ListNode<>(1, new ListNode<>(2, new ListNode<>(3, null)));
		ListNode<Integer> result = cyclicallyRightShiftList(L, 2);
		assert (result.data.equals(2) && result.next.data.equals(3) && result.next.next.data.equals(1)
				&& result.next.next.next == null);
	}
}
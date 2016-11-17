package stacks.algorithms;

import java.util.Deque;
import java.util.LinkedList;

public class SearchPosting {

	static class PostingListNode {
		public int order;
		public PostingListNode next, jump;

		public PostingListNode(int order, PostingListNode next, PostingListNode jump) {
			this.order = order;
			this.next = next;
			this.jump = jump;
		}
	}

	public static void setJumpOrder(PostingListNode L) {
		setJumpOrderHelper(L, 0);
	}

	private static int setJumpOrderHelper(PostingListNode L, int order) {
		if (L != null && L.order == -1) {
			L.order = order++;
			order = setJumpOrderHelper(L.jump, order);
			order = setJumpOrderHelper(L.next, order);
		}
		return order;
	}

	public static void setJumpOrderIter(PostingListNode L) {
		Deque<PostingListNode> s = new LinkedList<>();
		int order = 0;
		s.addFirst(L);
		while (!s.isEmpty()) {
			PostingListNode curr = s.removeFirst();
			if (curr != null && curr.order == -1) {
				curr.order = order++;
				// Stack is last-in, first-out, and we want to process
				// the jump node first, so push next, then push jump.
				s.addFirst(curr.next);
				s.addFirst(curr.jump);
			}
		}
	}
}

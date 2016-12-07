
import java.util.Comparator;
import java.util.NoSuchElementException;
import java.util.PriorityQueue;

public class StackQueueUsingHeap {
	private static final int DEFAULT_INITIAL_CAPACITY = 16;

	private static class ValueWithRank {
		public Integer value;
		public Integer rank;

		public ValueWithRank(Integer value, Integer rank) {
			this.value = value;
			this.rank = rank;
		}
	}

	private static class Compare implements Comparator<ValueWithRank> {
		@Override
		public int compare(ValueWithRank o1, ValueWithRank o2) {
			return Integer.compare(o2.rank, o1.rank);
		}

		public static final Compare COMPARE_VALUEWITHRANK = new Compare();
	}

	public static class Stack {
		private int timestamp = 0;
		private PriorityQueue<ValueWithRank> maxHeap = new PriorityQueue<>(DEFAULT_INITIAL_CAPACITY,
				Compare.COMPARE_VALUEWITHRANK);

		public void push(Integer x) {
			maxHeap.add(new ValueWithRank(x, timestamp++));
		}

		public Integer pop() throws NoSuchElementException {
			return maxHeap.remove().value;
		}

		public Integer peek() {
			return maxHeap.peek().value;
		}
	}

	public static class Queue {
		private int timestamp = 0;
		private PriorityQueue<ValueWithRank> H = new PriorityQueue<>(DEFAULT_INITIAL_CAPACITY, new Compare());

		public void enqueue(Integer x) {
			H.add(new ValueWithRank(x, timestamp--));
		}

		public Integer dequeue() throws NoSuchElementException {
			return H.remove().value;
		}

		public Integer head() {
			return H.peek().value;
		}
	}

	public static void main(String[] args) {} 
}
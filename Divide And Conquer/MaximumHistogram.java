import java.util.Deque;
import java.util.LinkedList;

public class MaximumHistogram {

	public int maxHistogram(int input[]) {
		Deque<Integer> stack = new LinkedList<Integer>();
		int maxArea = 0;
		int area = 0;
		int i;
		for (i = 0; i < input.length;) {
			if (stack.isEmpty() || input[stack.peekFirst()] <= input[i]) {
				stack.offerFirst(i++);
			} else {
				int top = stack.pollFirst();
				if (stack.isEmpty()) {
					area = input[top] * i;
				}
				else {
					int width = i - stack.peekFirst() - 1;
					area = input[top] * width;
				}
				if (area > maxArea) {
					maxArea = area;
				}
			}
		}
		while (!stack.isEmpty()) {
			int top = stack.pollFirst();
			if (stack.isEmpty()) {
				area = input[top] * i;
			}
			else {
				int width = i - stack.peekFirst() - 1;
				area = input[top] * width;
			}
			if (area > maxArea) {
				maxArea = area;
			}
		}
		return maxArea;
	}

	public static void main(String args[]) {
		MaximumHistogram mh = new MaximumHistogram();
		//int input[] = { 2, 2, 2, 6, 1, 5, 4, 2, 2, 2, 2 };
		int input[] = { 2,1,2,3,1 };
		int maxArea = mh.maxHistogram(input);
		// System.out.println(maxArea);
		assert maxArea == 12;
	}
}
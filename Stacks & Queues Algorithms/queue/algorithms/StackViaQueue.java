package queue.algorithms;

import java.util.*;

/**
 *
 * @author Mahmood
 */
public class StackViaQueue {

	Queue<Integer> q1 = new LinkedList<Integer>();
	Queue<Integer> q2 = new LinkedList<Integer>();

	public int pop() {
		if (q1.peek() == null) {
			System.out.println("The stack is empty, nothing to return");
			int i = 0;
			return i;
		} else {
			int pop = q1.remove();
			return pop;
		}
	}

	public void push(int data) {

		if (q1.peek() == null) {
			q1.add(data);
		} else {
			for (int i = q1.size(); i > 0; i--) {
				q2.add(q1.remove());
			}
			q1.add(data);
			for (int j = q2.size(); j > 0; j--) {
				q1.add(q2.remove());
			}

		}
	}

	public static void main(String[] args) {
		StackViaQueue s1 = new StackViaQueue();
		// Stack s1 = new Stack();
		s1.push(1);
		s1.push(2);
		s1.push(3);
		s1.push(4);
		s1.push(5);
		s1.push(6);
		s1.push(7);
		s1.push(8);
		s1.push(9);
		s1.push(10);
		// s1.push(6);
		System.out.println("1st = " + s1.pop());
		System.out.println("2nd = " + s1.pop());
		System.out.println("3rd = " + s1.pop());
		System.out.println("4th = " + s1.pop());
		System.out.println("5th = " + s1.pop());
		System.out.println("6th = " + s1.pop());
		System.out.println("7th = " + s1.pop());
		System.out.println("8th = " + s1.pop());
		System.out.println("9th = " + s1.pop());
		System.out.println("10th= " + s1.pop());
	}

}

class StackImplementationUsingSingleQ {
	static Queue<Integer> Q = new LinkedList<Integer>();

	void push(int d) {
		int size = Q.size(); // size of the queue
		Q.add(d); // push element to the queue

		for (int i = 0; i < size; i++) {
			Q.add(Q.remove());
		}

	}

	void pop() {
		System.out.println("The popped element is " + Q.remove());
	}

	public static void main(String args[]) {
		StackImplementationUsingSingleQ s = new StackImplementationUsingSingleQ();

		s.push(10);
		s.push(3);
		s.push(4);
		s.push(24);
		s.pop();
		s.pop();
	}
}
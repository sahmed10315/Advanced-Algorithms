package stacks.algorithms;

import java.util.Stack;

public class ReverseStackRecursion {
	// Below is a recursive function that inserts an element
	// at the bottom of a stack.
	static void insertAtBottom(Stack<Integer> st, int item)
	{
	    if (st.isEmpty())
	        st.push(item);
	    else
	    {
	 
	        /* Hold all items in Function Call Stack until we
	           reach end of the stack. When the stack becomes
	           empty, the isEmpty(*top_ref)becomes true, the
	           above if part is executed and the item is inserted
	           at the bottom */
	        int temp = st.pop();
	        insertAtBottom(st, item);
	 
	        /* Once the item is inserted at the bottom, push all
	           the items held in Function Call Stack */
	        st.push(temp);
	    }
	}
	 
	// Below is the function that reverses the given stack using
	// insertAtBottom()
	static void reverse(Stack<Integer> st)
	{
	    if (!st.isEmpty())
	    {
	        /* Hold all items in Function Call Stack until we
	           reach end of the stack */
	        int temp = st.pop();
	        reverse(st);
	 
	        /* Insert all the items (held in Function Call Stack)
	           one by one from the bottom to top. Every item is
	           inserted at the bottom */
	        insertAtBottom(st, temp);
	    }
	}
	 
	 public static void main(String [] args) {
		 Stack<Integer> st = new Stack<>();
		 st.push(-3); 
		 st.push(14);
		 st.push(18);
		 st.push(-5);
		 st.push(30);
		 reverse(st);
	 }
}

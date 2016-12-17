package stacks.algorithms;
import java.util.Stack;

public class SortStackRecursion {
	 //Recursive function to insert an item x in sorted way
	 static void sortedInsert(Stack<Integer> s, int x)
	 {
	     // Base case: Either stack is empty or newly inserted
	     // item is greater than top (more than all existing)
	     if (s.isEmpty() || x > s.peek())
	     {
	         s.push(x);
	         return;
	     }
	  
	     // If top is greater, remove the top item and recur
	     int temp = s.pop();
	     sortedInsert(s, x);
	  
	     // Put back the top item removed earlier
	     s.push(temp);
	 }
	  
	 // Function to sort stack
	 static void sortStack(Stack<Integer> s)
	 {
	     // If stack is not empty
	     if (!s.isEmpty())
	     {
	         // Remove the top item
	         int x = s.pop();
	  
	         // Sort remaining stack
	         sortStack(s);
	  
	         // Push the top item back in sorted stack
	         sortedInsert(s, x);
	     }
	 }
	 
	 public static void main(String [] args) {
		 Stack<Integer> st = new Stack<>();
		 st.push(-3); 
		 st.push(14);
		 st.push(18);
		 st.push(-5);
		 st.push(30);
		 sortStack(st);
	 }
}

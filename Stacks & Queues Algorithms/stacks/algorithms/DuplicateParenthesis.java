package stacks.algorithms;
import java.util.Stack;
public class DuplicateParenthesis {
	// C++ program to find duplicate parenthesis in a
	// balanced expression 
	 
	// Function to find duplicate parenthesis in a
	// balanced expression
	static boolean findDuplicateparenthesis(String str)
	{
	    // create a stack of characters
	    Stack<Character> Stack = new Stack<>();
	 
	    // Iterate through the given expression
	    for (char ch : str.toCharArray())
	    {
	        // if current character is close parenthesis ')'
	        if (ch == ')')
	        {
	            // pop character from the stack
	            char top = Stack.pop(); 
	 
	            // if immediate pop is a open parenthesis '(',
	            // we have found duplicate
	            if (top == '(')
	                return true;
	 
	            // else we continue popping characters from the
	            // stack till open parenthesis '(' is encountered
	            else
	            {
	                while (top != '(')
	                    top = Stack.pop(); 
	            }
	        }
	 
	        // push open parenthesis '(', operators and
	        // operands to stack
	        else
	            Stack.push(ch);
	    }
	 
	    // No duplicates found
	    return false;
	}
	 
	// Driver code
	public static void main(String [] args)
	{
	    // input balanced expression
	    String str = "()";
	 
	    findDuplicateparenthesis(str); 
	  
	}
}

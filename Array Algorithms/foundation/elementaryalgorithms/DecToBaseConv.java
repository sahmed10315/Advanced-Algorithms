package foundation.elementaryalgorithms;

public class DecToBaseConv {

	static String convFrmDecToBase(int num, int base) {
 
	    StringBuilder res = new StringBuilder();
	    int rem;
	    // Convert input number is given base by repeatedly
	    // dividing it by base and taking remainder
	    while (num > 0)
	    {
	    	rem = num % base;
	    	if(base == 16)
	    	{
	    		if (rem == 10)
	    			res.append('A');
	    		else if(rem == 11)
	    			res.append('B');
	    		else if(rem == 12)
	    			res.append('C');
	    		else if(rem == 13)
	    			res.append('D');
	    		else if(rem == 14)
	    			res.append('E');
	    		else if(rem == 15)
	    			res.append('F');
	    		else
		    		res.append(rem);
	    	} else
	    		res.append(rem);
	    	
	        num /= base;
	    } 
	    // Reverse the result
	    return res.reverse().toString();
	}
	
	public static void main(String [] args) {
		System.out.println(convFrmDecToBase(6491, 16));

		System.out.println(convFrmDecToBase(6491, 2));
		

		System.out.println(convFrmDecToBase(6491, 8)); 
	}
}

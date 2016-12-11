package math.elementaryalgorithms;

/* Computes a^b 
 * Time complexity, space complexity for recursive: O(b), O(b)
 * */
public class Exponent {

	public static void main(String []args) {
		System.out.println(power(2, 8));
		System.out.println(powerIter(2, 8));
	}
	
	static int power (int a, int b) {
		if (b < 0) 
			return 0;
		else if(b == 0)
			return 1;
		else 
			return a * power(a, b - 1);
	}
	
	static int powerIter(double a, double b){
	    int res =1;
	    for (int i = 0; i < b; i++) 
	        res *= a;
	    
	    return res;
	}
}
package math.elementaryalgorithms;

/* Product of a and b without multiplication
 * Runtime complexity : O(b) 
 */
public class ProductWithoutMult {
	
	static int product(int a, int b) { 
		int sum = 0;
		for(int i = 0; i < b; i++) 
			sum += a;
		
		return sum;
	}
	
	public static void main(String [] args) {
		System.out.println(product(50, 90));
	}
}

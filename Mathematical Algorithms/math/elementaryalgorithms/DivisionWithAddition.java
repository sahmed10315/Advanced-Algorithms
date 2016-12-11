package math.elementaryalgorithms;

/* Division without operator 
 * Runtime complexity: O(a/b)
 * */
public class DivisionWithAddition {
	
	public static void main(String [] arg) {
		System.out.println(division(50, 10));
	}
	
	static int division(int a, int b) {
		int count = 0;
		int sum = b;
		while(sum <= a) {
			sum += b;
			count++;
		}
		return count;
	}
}

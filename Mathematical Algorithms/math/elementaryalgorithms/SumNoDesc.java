package math.elementaryalgorithms;

/* Sum digits from n to 1 iteratively and recursively 
 * Runtime, Space iterative: O(N), O(1)
 * Runtime, Space recursive: O(N), O(N)
 * */
public class SumNoDesc {
	static int sum (int n ) {
		if (n <= 0) 
			return 0;
		return n + sum(n - 1);
	}
	
	static int sumIter(int n) {
		int sum = 0;
		for(int i = 1; i <= n; i++)
			sum += i;
		return sum;
	}
	
	public static void main(String [] args) {
		System.out.println(sumIter(11));
		System.out.println(sum(11));
	}
}
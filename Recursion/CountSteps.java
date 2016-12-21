
public class CountSteps {

	public static int countWays(int n) {
		if (n < 0) {
			return 0;
		} else if (n == 0) {
			return 1;
		} else {
			int count1= countWays(n - 1);
			int count2 = countWays(n - 2);
			int count3 =  countWays(n - 3);
			return count1 + count2 + count3;
		}
	}

	public static void main(String[] args) {
		int n = 20;
		int ways = countWays(3);
		System.out.println(ways);
	}
}

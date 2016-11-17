package math;

public class PalindromeNo {

	public static boolean isPalindrome(long x) {
		if (x < 0)
			return false;
		long div = 1;
		while (x / div >= 10) {
			div *= 10;
		} 
		while (x != 0) {
			long l = x / div;
			long r = x % 10;
			if (l != r)
				return false;
			x = (x % div) / 10;
			div /= 100;
		}
		return true;
	}

	public static void main(String[] args) { 
		System.out.println((isPalindrome(9123443219L)));
		System.out.println(ReverseNo.reverse(12344321) == 12344321);
	}
}
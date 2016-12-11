package math.elementaryalgorithms;

/* 
 * Calculate prime of a number 
 * Time complexity of findPrimes: O(Nsqrt(n))
 * Time complexity of seiveOfErathosthenes : O(n log log n)
 * */

public class IsPrime {
	
	public static void main(String [] args) {
		findPrimes(17);
	}
	
	static boolean isPrime (int n) {
		for (int x = 2; x <= Math.sqrt(n); x++) 
			if (n % x == 0) 
				return false;
		
		return true;
	}
	
	static void findPrimes(int no) {
		for (int i = 2; i <= no; i++)
			if (isPrime(i))
				System.out.println(i);
	}
	
	static void seiveOfEratosthenes(int no) {
		boolean [] primes = new boolean[no + 1];
		
		for(int i = 2; i < primes.length; i++)
			primes[i] = true;
		
		for(int i = 2; i <= Math.sqrt(no); i++)
			if(primes[i])	
				for (int j = 2; i * j <= no; j++)
					primes[i * j] = false;
				
		for(int i = 0; i < primes.length; i++)
			if(primes[i])
				System.out.println(i);
	}
}

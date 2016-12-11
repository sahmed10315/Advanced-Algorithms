package math.elementaryalgorithms;

import java.util.TreeSet;

public class Factorization {

	static void primeFactorization(int no) {
		
		for (int i = 2; i <= Math.sqrt(no); i++) {
			if (no % i == 0) {
				int count = 0;
				while (no % i == 0)
				{
					no = no / i;
					count++;
				}
				System.out.print(i + "^" + count + " * ");
			}
		}
		
		if (no != 1) 		
			System.out.println(no + "^" + 1);

	}
	static void factorization(int no) {
		
		TreeSet<Integer> factors = new TreeSet<>();
		for (int i = 1; i <= Math.sqrt(no); i++){
			if (no % i == 0) {
				factors.add(i);
				
				if(i != Math.sqrt(no))
					factors.add(no/i);
			}
		}
		
		for(int factor : factors)
			System.out.println(factor);
	}
	
	public static void main(String [] args) {
		primeFactorization(102);
	}
}

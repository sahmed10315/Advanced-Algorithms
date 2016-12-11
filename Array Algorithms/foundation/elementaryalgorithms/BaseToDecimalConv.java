package foundation.elementaryalgorithms;

public class BaseToDecimalConv {
	static int convFrmBaseToDeci(String num, int base) {
		
		if (base < 2 || (base > 10 && base != 16))
			return -1;
		
		int val = 0;
		int power = 1;
		
		for (int i = num.length() - 1; i >= 0; i--) {
			int digit = digitToVal(num.charAt(i));
			
			if (digit < 0 || digit >= base)
				return -1;

			// Decimal equivalent is str[len-1]*1 +
		    // str[len-1]*base + str[len-1]*(base^2) + ...
			val += digit * power;
			power = power * base;
		}
		
		return val;
	}
	
	static int digitToVal(char c)
	{
	    if (c >= '0' && c <= '9')
	        return (int)c - '0';
	    else
	        return (int)c - 'A' + 10;
	}
	
	public static void main(String [] args) {
		System.out.println(convFrmBaseToDeci("A12C", 16));
		System.out.println(convFrmBaseToDeci("101101", 2));
		System.out.println(convFrmBaseToDeci("123455", 8));
	}
}

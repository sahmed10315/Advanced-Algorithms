package foundation.elementaryalgorithms;

import java.util.ArrayList;

public class IntToString {

	static String intToStr(int num) { 
		boolean isNeg = false;
		
		ArrayList<Character>temp = new ArrayList<>();
		
		if(num < 0) {
			num = -num;
			isNeg = true;
		}
		
		do {
			temp.add((char)((num % 10) + '0'));
			num /= 10;
		} while(num != 0);
		StringBuilder strBuilder = new StringBuilder();
		
		if(isNeg)
			strBuilder.append('-');
		
		for(int i = temp.size() - 1; i >= 0; i--)
			strBuilder.append(temp.get(i));
		
		return strBuilder.toString();
	}
	
	public static void main(String [] args) {
		System.out.println(intToStr(12345));
	}
}

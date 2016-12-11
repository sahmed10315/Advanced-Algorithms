package foundation.elementaryalgorithms;

public class ReverseString {
	public static void main(String [] args) {
		System.out.println(reverseString1("Saad Ahmed"));
		System.out.println(reverseString2("Saad Ahmed"));
		System.out.println(reverseString3("Saad Ahmed"));
	}
	
	static String reverseString1(String str) {
		if (str.length() < 2) 
            return str;
		return reverseString1(str.substring(1)) + str.charAt(0);
	}
	
	static String reverseString2(String str) {
		
		char [] strChars = str.toCharArray();
		StringBuilder reverse = new StringBuilder();
		
		for(int i = strChars.length -1; i >= 0; i--)
			reverse.append(strChars[i]);
		return reverse.toString();
	}
	
	static String reverseString3(String str) {
		
		char [] strChars = str.toCharArray(); 
		
		for(int i = 0; i < strChars.length / 2; i++)
		{
			int other = strChars.length - i - 1;
			char temp = strChars[i];
			strChars[i] = strChars[other];
			strChars[other] = temp;
		}
		return new String(strChars);
	}
}

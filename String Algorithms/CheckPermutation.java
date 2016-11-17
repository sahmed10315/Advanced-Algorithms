import java.util.Arrays;

public class CheckPermutation {

	static String sort(String str) {
		char [] sArr = str.toCharArray();
		Arrays.sort(sArr);
		return new String(sArr);
		
	}
	static boolean permutationSimple(String s1, String s2) {
		if(s1.length() != s2.length())
			return false;
		
		return sort(s1).equals(sort(s2));
	}
	
	static boolean permutation(String s1, String s2) {
		if (s1.length() != s2.length())
			return false;
		
		int[] letters = new int[128];
		
		for(Character c : s1.toCharArray())
			letters[c]++;
		
		for(Character c : s2.toCharArray()) {
			letters[c]--;
			if(letters[c] < 0)
				return false;
		}
		return true;
	}
	
	public static void main(String [] args) {
		System.out.println(permutation("aaaab","aaabc"));
	}
}
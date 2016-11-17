
public class RemoveSpecChars {

	public static String removeChars(String s, String r) {
		char[] SArray = s.toCharArray();
		char[] RArray = r.toCharArray();
		boolean[] flags = new boolean[128];

		for (int i = 0; i < r.length(); i++)
			flags[RArray[i]] = true;
		int src = 0;
		for (int j = 0; j < s.length(); j++)
			if (!(flags[SArray[j]]))
				SArray[src++] = SArray[j];
		return new String(SArray, 0, src);
	}
	
	public static void main(String [] args) {
		System.out.println(removeChars("Saad Ahmed", "ahm"));
	}
}
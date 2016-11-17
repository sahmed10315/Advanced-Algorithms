
public class IsUnique {

	boolean isUniqueChars(String str) {
		if (str.length() > 128)
			return false;
		
		boolean [] charSet = new boolean[128];
		
		for (int i = 0; i < str.length(); i++) {
			char val = str.charAt(i);
			if(charSet[val])
				return false;
			charSet[val] = true;
		}
		return true;
	}
	
	boolean isUniqueCharsBitVec(String str) {
		
		int checker = 0;
		for (int i = 0; i < str.length(); i++)
		{
			char val = str.charAt(i);
			if ((checker & (1 << val)) != 0)
				return false;
			
			checker |= (1 << val);
		}
		return true;
	}
}
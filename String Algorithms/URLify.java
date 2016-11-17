
public class URLify {

	public static String urlify(String str, int length) {
		char [] sArray = str.toCharArray();
		int count = 0;
		for (Character c : sArray) {
			if (c == ' ')
				count++;
		}
		
		count *= 2;
		
		int newLength = count + length;
		sArray[newLength] = '\0';
		for (length = length - 1; length >= 0;  length--) {
			if (sArray[length] == ' ')
			{
				sArray[newLength - 1] = '0';
				sArray[newLength - 2] = '2';
				sArray[newLength - 3] = '%';
				newLength -= 3;
			} else {
				sArray[newLength - 1] = sArray[length];
				newLength--;
			}
		}
		return new String(sArray);
	}
}
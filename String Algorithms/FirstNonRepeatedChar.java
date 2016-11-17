import java.util.HashMap;

public class FirstNonRepeatedChar {
	public static Character firstNonRepeated(String str) {
		Character c = null;
		HashMap<Character, Integer> hashTable = new HashMap<>();

		for (int i = 0; i < str.length(); i++) {
			c = str.charAt(i);
			if (hashTable.containsKey(c))
				hashTable.put(c, hashTable.get(c) + 1);
			else
				hashTable.put(c, 1);
		}

		for (int i = 0; i < str.length(); i++) {
			c = str.charAt(i);
			if (hashTable.get(c) == 1)
				return c;
		}
		return null;
	}

	static class CountIndex {
		int count;
		int index;
	}

	/*
	 * Returns an array of above structure type. The size of array is
	 * NO_OF_CHARS
	 */
	public static CountIndex[] getCharCountArray(String str) {
		CountIndex[] count = new CountIndex[256];

		for (int i = 0; i < count.length; i++) {
			count[i] = new CountIndex();
			count[i].count = 0;
		}
		for (int i = 0; i < str.length(); i++) {
			Character c = str.charAt(i);
			count[c].count++;

			// If it's first occurrence, then store the index
			if (count[c].count == 1)
				count[c].index = i;
		}
		return count;
	}

	/*
	 * The function returns index of the first non-repeating character in a
	 * string. If all characters are repeating then reurns INT_MAX
	 */
	public static int firstNonRepeating(String str) {
		CountIndex[] count = getCharCountArray(str);
		int result = Integer.MAX_VALUE, i;

		for (i = 0; i < 256; i++) {
			// If this character occurs only once and appears
			// before the current result, then update the result
			if (count[i].count == 1 && count[i].index < result)
				result = count[i].index;
		}

		return result;
	}

	public static void main(String[] args) {
		System.out.println(firstNonRepeating("SASadeAhmeda"));
	}
}

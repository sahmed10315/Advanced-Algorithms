
public class PalindromePermutation {

	boolean isPermutationOfPalindrome(String phrase) {
		int [] table = buildCharFrequencyTable(phrase);
		return checkMaxOneOdd(table);
	}

	private boolean checkMaxOneOdd(int[] table) {
		boolean foundOdd = false;
		for (int count : table) {
			if (count % 2 == 1)
			{
				if(foundOdd)
					return false;
				foundOdd = true;
			}
		}
		return true;
	}

	private int[] buildCharFrequencyTable(String phrase) {
		int [] table = new int[Character.getNumericValue('z') - Character.getNumericValue('a')];
		
		for (char c : phrase.toCharArray()) {
			int x = getCharNumber(c);
			if(x != -1)
				table[x]++;
		}
		return table;
	}

	private int getCharNumber(char c) {
		int a = Character.getNumericValue('a');
		int z = Character.getNumericValue('z');
		int A = Character.getNumericValue('A');
		int Z = Character.getNumericValue('Z');
		
		int val = Character.getNumericValue(c);
		if (val >= a && val <= z)
			return val - a;
		else if (val >= A && val <= Z)
			return val - A;
		
		return -1;
	}
	
	boolean isPermutationOfPalindrome2(String phrase) {
		int countOdd = 0;
		
		int [] table = new int[Character.getNumericValue('z') - Character.getNumericValue('a')];
		
		for (char c : phrase.toCharArray()) {
			int x = getCharNumber(c);
			if(x != -1) {
				table[x]++;
				if (table[x] % 2 == 1)
					countOdd++;
				else 
					countOdd--;
			}
		}
		
		return countOdd <= 1;
	}
	
	boolean isPermutationOfPalindrome3(String phrase) {
		int bitVector = createBitVector(phrase);
		return bitVector == 0 || checkOneBitSet(bitVector);
	}

	private boolean checkOneBitSet(int bitVector) { 
		return (bitVector & (bitVector - 1)) == 0;
	}

	private int createBitVector(String phrase) { 
		int bitVector = 0;
		for (char c: phrase.toCharArray()) {
			int x = getCharNumber(c);
			bitVector = toggle(bitVector, x);
		}
		return bitVector;
	}

	private int toggle(int bitVector, int index) {
		if(index < 0)return bitVector;
		int mask = 1 << index;
		if ((bitVector & (mask)) == 0)
			bitVector |= (mask);
		else
			bitVector &= ~(mask);
		return bitVector;
	}
}

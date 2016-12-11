package foundation.elementaryalgorithms;

// Create permutations of a string.
import java.io.*;

public class Anagrams {

	public static void anagrams(int newSize, char[] arr) {
		if (newSize == 1) // if too small,
			return;  

		for (int j = 0; j < newSize; j++) {
			anagrams(newSize - 1, arr); // anagram remaining
			if (newSize == 2) // if innermost,
				System.out.println(new String(arr));
			rotate(newSize, arr); // rotate word
		}
	}

	// rotate left all chars from position to end
	public static void rotate(int newSize, char[] arrChar) {
		int j;
		int position = arrChar.length - newSize;
		char temp = arrChar[position]; // save first letter
		for (j = position + 1; j < arrChar.length; j++) // shift others left
			arrChar[j - 1] = arrChar[j];
		arrChar[j - 1] = temp; // put first on right
	}

	public static void main(String[] args) throws IOException {
		String input = "ABC";
		char[] arrChar = input.toCharArray();
		anagrams(arrChar.length, arrChar); // anagram it
	}
}
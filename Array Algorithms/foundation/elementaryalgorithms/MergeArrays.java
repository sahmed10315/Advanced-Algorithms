package foundation.elementaryalgorithms;

/* Merge two sorted arrays in another array 
 * Runtime complexity : O(A + B)
 * */
public class MergeArrays {

	public static void merge(int[] arrayA, int[] arrayB, int[] arrayC) {
		int aIndex = 0, bIndex = 0, current = 0;

		while (aIndex < arrayA.length && bIndex < arrayB.length)
			if (arrayA[aIndex] < arrayB[bIndex])
				arrayC[current++] = arrayA[aIndex++];
			else
				arrayC[current++] = arrayB[bIndex++];

		while (aIndex < arrayA.length) // arrayB is empty,
			arrayC[current++] = arrayA[aIndex++]; 

		while (bIndex < arrayB.length) // arrayA is empty,
			arrayC[current++] = arrayB[bIndex++]; 
	}

	public static void main(String[] args) {
		int[] arrayA = { 23, 47, 81, 95 };
		int[] arrayB = { 7, 14, 39, 55, 62, 74 };
		int[] arrayC = new int[10];

		merge(arrayA, arrayB, arrayC);

		for (int x : arrayC)
			System.out.println(x);
	}
}
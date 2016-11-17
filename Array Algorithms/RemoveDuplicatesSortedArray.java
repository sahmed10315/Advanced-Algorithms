
import java.util.Arrays;
import java.util.List;

public class RemoveDuplicatesSortedArray {
	// Returns the number of valid entries after deletion.
	public static int deleteDuplicates(List<Integer> arrList) {
		if (arrList.isEmpty()) {
			return 0;
		}

		int writeIndex = 1;
		for (int i = 1; i < arrList.size(); ++i) {
			if (!arrList.get(writeIndex - 1).equals(arrList.get(i))) {
				arrList.set(writeIndex++, arrList.get(i));
			}
		}
		return writeIndex;
	}

	// Manipulate original array
	public static int removeDuplicatesNaive(int[] A) {
		if (A.length < 2)
			return A.length;

		int j = 0;
		int i = 1;

		while (i < A.length) {
			if (A[i] == A[j]) {
				i++;
			} else {
				j++;
				A[j] = A[i];
				i++;
			}
		}

		return j + 1;
	}

	public static void main(String[] args) {
		List<Integer> arrList = Arrays.asList(2, 3, 4, 4, 7, 11, 11, 11, 15);

		System.out.println(deleteDuplicates(arrList));
		System.out.println(arrList);
	}
}
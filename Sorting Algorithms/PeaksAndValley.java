import java.util.Arrays;

public class PeaksAndValley {
	public static void swap(int[] array, int left, int right) {
		int temp = array[left];
		array[left] = array[right];
		array[right] = temp;
	}

	public static void sortValleyPeak(int[] array) {
		for (int i = 1; i < array.length; i += 2) {
			if (array[i - 1] < array[i]) {
				swap(array, i - 1, i);
			}
			if (i + 1 < array.length && array[i + 1] < array[i]) {
				swap(array, i + 1, i);
			}
		}
	}

	public static void sortValleyPeakBF(int[] array) {
		Arrays.sort(array);
		for (int i = 1; i < array.length; i += 2) {
			swap(array, i - 1, i);
		}
	}
}

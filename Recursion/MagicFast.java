
public class MagicFast {

	public static int magicSlow(int[] array) {
		for (int i = 0; i < array.length; i++) {
			if (array[i] == i) {
				return i;
			}
		}
		return -1;
	}

	public static int magicFast(int[] array, int start, int end) {
		if (end < start) {
			return -1;
		}
		int mid = (start + end) / 2;
		if (array[mid] == mid) {
			return mid;
		} else if (array[mid] > mid) {
			return magicFast(array, start, mid - 1);
		} else {
			return magicFast(array, mid + 1, end);
		}
	}

	public static int magicFast(int[] array) {
		return magicFast(array, 0, array.length - 1);
	}

	public static int magicFastNotDistinct(int[] array, int start, int end) {
		if (end < start) {
			return -1;
		}
		int midIndex = (start + end) / 2;
		int midValue = array[midIndex];
		if (midValue == midIndex) {
			return midIndex;
		}
		/* Search left */
		int leftIndex = Math.min(midIndex - 1, midValue);
		int left = magicFastNotDistinct(array, start, leftIndex);
		if (left >= 0) {
			return left;
		}

		/* Search right */
		int rightIndex = Math.max(midIndex + 1, midValue);
		int right = magicFastNotDistinct(array, rightIndex, end);

		return right;
	}

	public static int magicFastNotDistinct(int[] array) {
		return magicFastNotDistinct(array, 0, array.length - 1);
	}

	public static void main(String[] args) {
		int[] array = new int[11];
		array[0] = -40;
		array[1] = -20;
		array[2] = -1;
		array[3] = 1;
		array[4] = 2;
		array[5] = 3;
		array[6] = 5;
		array[7] = 7;
		array[8] = 9;
		array[9] = 12;
		array[10] = 13;
		System.out.println(magicSlow(array));
		System.out.println(magicFast(array));
		
		array[0] = -10;
		array[1] = -5;
		array[2] = 2;
		array[3] = 2;
		array[4] = 2;
		array[5] = 3;
		array[6] = 4;
		array[7] = 7;
		array[8] = 9;
		array[9] = 12;
		array[10] = 13; 
		System.out.println(magicFastNotDistinct(array));
	}
}

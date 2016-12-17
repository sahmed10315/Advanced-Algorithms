
public class KSmallest {
	// This function returns k'th smallest element in arr[l..r] using
	// QuickSort based method. ASSUMPTION: ALL ELEMENTS IN ARR[] ARE DISTINCT
	static int kthSmallest(int arr[], int l, int r, int k) {
		// If k is smaller than number of elements in array
		if (k > 0 && k <= r - l + 1) {
			// Partition the array around last element and get
			// position of pivot element in sorted array
			int pos = partition(arr, l, r);

			// If position is same as k
			if (pos - l == k - 1)
				return arr[pos];
			if (pos - l > k - 1) // If position is more, recur for left subarray
				return kthSmallest(arr, l, pos - 1, k);

			// Else recur for right subarray
			return kthSmallest(arr, pos + 1, r, k - pos + l - 1);
		}

		// If k is more than number of elements in array
		return Integer.MAX_VALUE;
	}

	public static int partition(int[] arr, int left, int right) {
		int pivot = arr[(left + right) / 2]; // Pick a pivot point. Can be an
												// element
		while (left <= right) { // Until we've gone through the whole array
			// Find element on left that should be on right
			while (arr[left] < pivot)
				left++;

			// Find element on right that should be on left
			while (arr[right] > pivot)
				right--;

			// Swap elements, and move left and right indices
			if (left <= right) {
				swap(arr, left, right);
				left++;
				right--;
			}
		}
		return left;
	}

	public static void swap(int[] array, int i, int j) {
		int tmp = array[i];
		array[i] = array[j];
		array[j] = tmp;
	}

	public static void main(String[] args) {
		int[] A = new int[7];
		A[0] = 1;
		A[1] = 6;
		A[2] = 2;
		A[3] = 99;
		A[4] = 23;
		A[5] = 34;
		A[6] = 3;

		System.out.println(kthSmallest(A, 0, A.length - 1, 5));
	}
}
public class ConvertMinToMaxHeap {
	// A C++ program to convert min Heap to max Heap

	static public void trickleDown(int heapArray[], int index, int currentSize) {
		int largerChild;
		int top = heapArray[index]; // save root
		while (index < currentSize / 2) // while node has at
		{ // least one child,
			int leftChild = 2 * index + 1;
			int rightChild = leftChild + 1;
			// find larger child
			if (rightChild < currentSize && // (rightChild exists?)
					heapArray[leftChild] < heapArray[rightChild])
				largerChild = rightChild;
			else
				largerChild = leftChild;
			// top >= largerChild?
			if (top >= heapArray[largerChild])
				break;
			// shift child up
			heapArray[index] = heapArray[largerChild];
			index = largerChild; // go down
		}
		heapArray[index] = top; // root to index
	}

	static void convertMaxHeap(int arr[], int n) {
		// Start from bottommost and rightmost
		// internal mode and heapify all internal
		// modes in bottom up way
		for (int i = (n - 2) / 2; i >= 0; --i)
			trickleDown(arr, i, n);
	}

	public static void swap(int[] array, int i, int j) {
		int tmp = array[i];
		array[i] = array[j];
		array[j] = tmp;
	}

	// Driver program to test above functions
	public static void main(String[] args) {
		// array representing Min Heap
		int arr[] = { 3, 5, 9, 6, 8, 20, 10, 12, 18, 9 };

		convertMaxHeap(arr, arr.length);

	}
}

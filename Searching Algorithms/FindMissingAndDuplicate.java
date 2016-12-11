
public class FindMissingAndDuplicate {
	void printTwoElements(int arr[], int size) {
		int i;
		System.out.println("\n The repeating element is");

		for (i = 0; i < size; i++) {
			if (arr[Math.abs(arr[i]) - 1] > 0)
				arr[Math.abs(arr[i]) - 1] = -arr[Math.abs(arr[i]) - 1];
			else
				System.out.println(Math.abs(arr[i]));
		}

		System.out.println("\nand the missing element is ");
		for (i = 0; i < size; i++) {
			if (arr[i] > 0)
				System.out.println(i + 1);
		}
	}

	/* Driver program to test above function */
	int main() {
		int arr[] = { 7, 3, 4, 5, 5, 6, 2 };
		printTwoElements(arr, arr.length);
		return 0;
	}
}

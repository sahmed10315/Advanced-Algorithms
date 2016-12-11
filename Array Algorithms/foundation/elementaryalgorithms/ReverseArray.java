package foundation.elementaryalgorithms;

/* Program to reverse an array 
 * Time complexity = O(N) 
 */
public class ReverseArray {
	public static void main(String [] args) {
		
		int [] intArray = { 1, 33, 46, 16, 76, 9 };
		
		for (int no : intArray)
			System.out.println(no);
		
		reverseArray3(intArray, 0, intArray.length - 1);

		for (int no : intArray)
			System.out.println(no);
		
	}
	
	static void reverseArray1(int [] array) {
		for(int i = 0; i < array.length / 2; i++) {
			int other = array.length - i - 1;
			int temp = array[i];
			array[i] = array[other];
			array[other] = temp;
		}
	}
	
	static void reverseArray2(int arr[])
	{
	    int temp;
	    int start = 0;
	    int end = arr.length - 1;
	    while (start < end)
	    {
	        temp = arr[start];   
	        arr[start] = arr[end];
	        arr[end] = temp;
	        start++;
	        end--;
	    }   
	}
	 
    static void reverseArray3(int arr[], int start, int end)
    {
        int temp;
        if (start >= end)
            return;
        temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
        reverseArray3(arr, start+1, end-1);
    }
}
package foundation.elementaryalgorithms;

/* Linear search time and space complexity: O(N) , O(1)
 * Binary search recursive time and space complexity: O(logN), O(logN)
 * Binary search iterative time and space complexity: O(logN), O(1) 
 */
public class Search {

	public static void main(String [] args) {
		int [] arr = {1, 3, 66, 77, 199, 444, 974};
		System.out.println(linearSearch(arr, 199));
		System.out.println(binarySearchRecursive(arr, 199, 0, arr.length));
		System.out.println(binarySearchIterative(arr, 199));
	}
	
	static int linearSearch(int [] arr, int item)
	{
	    for (int i= 0; i< arr.length; i++)
	       if (arr[i] == item)
	         return i;
	    
	    return -1;
	}
	
	static int binarySearchRecursive(int [] a, int x, int low, int high) {
		if (low > high) 
			return -1;
		
		int mid = (low + high) / 2;
		
		if(a[mid] < x)
			return binarySearchRecursive(a, x, mid + 1, high);
		else if( a[mid] > x)
			return binarySearchRecursive(a, x, low, mid - 1);
		else
			return mid;
	}
	
	static int binarySearchIterative(int [] a, int item) {
		int low = 0;
		int high = a.length - 1;
		int mid;
		
		while(low <= high) {
			mid = (low + high) / 2;
			if(a[mid] < item) 
				low = mid + 1;
			else if(a[mid] > item)
				high = mid - 1;
			else
				return mid;
		}
		return -1;
	}
}

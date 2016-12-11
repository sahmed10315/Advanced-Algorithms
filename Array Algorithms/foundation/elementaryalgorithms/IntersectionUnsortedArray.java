package foundation.elementaryalgorithms;

/* Intersection of two unsorted arrays 
 * Time complexity: O(BlogB+AlogB)
 * */
import java.util.Arrays;

public class IntersectionUnsortedArray {

	public static void main(String [] args) {
		int [] arr1 = new int []{3, 8, 6, 20, 7};
		int [] arr2 = new int [] {7, 1, 5, 2, 3, 6}; 
		System.out.println(intersection(arr2, arr1));
	}
	static int intersection(int [] a, int [] b) {
		Arrays.sort(b);
		int intersect = 0;
		
		for (int x: a)
			if(Arrays.binarySearch(b, x) >= 0)
				intersect++;
		return intersect;
	}
}
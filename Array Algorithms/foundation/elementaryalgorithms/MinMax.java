package foundation.elementaryalgorithms;

/* 
 * Find minimum and maximum number in an array 
 * Time complexity = O(N) 
 * */
public class MinMax {
	public static void main(String [] args) {
		
		int [] array = {44, 31, 14, 5, 22, 555, 234, 11, 54, 422}; 
		
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		
		for (int x : array) {
			if (x < min) 
				min = x;
			if (x > max)
				max = x;
		}
		
		System.out.println("Minimum: " + min);
		System.out.println("Maximum: " + max); 
		
		System.out.println("Maximum: " + compareToAll(array));
		
	}
	
	static int compareToAll(int [] arr) {
		boolean isMax;
		
		for(int i = arr.length - 1; i>= 0; i--)
		{
			isMax = true;
			
			for(int j = 0; j < i; j++)
				if(arr[j] > arr[i])
				{
					isMax = false;
					break;
				}
			
			if (isMax) return arr[i];
		}
		return -1;
	}
}

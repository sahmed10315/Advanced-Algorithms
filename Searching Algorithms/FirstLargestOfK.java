import java.util.List;

public class FirstLargestOfK {
	public static int searchFirstLargerOfK(List<Integer> A, int k){
		int left = 0, right = A.size() - 1, result = -1;
		
		while(left <= right) {
			int mid = left + ((right - left) / 2);
			
			if (A.get(mid) > k) {
				result = mid;
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return result;
	}
}

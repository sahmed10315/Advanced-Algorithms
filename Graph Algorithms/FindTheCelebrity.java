
public class FindTheCelebrity {
	public static int findCelebrity(int n, boolean[][] arr) {
		if (n <= 1) {
			return -1;
		}

		int[] inDegree = new int[n];
		int[] outDegree = new int[n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i != j && arr[i][j] == true) {
					outDegree[i]++;
					inDegree[j]++;
				}
			}
		}

		for (int i = 0; i < n; i++) {
			if (inDegree[i] == n - 1 && outDegree[i] == 0) {
				return i;
			}
		}

		return -1;
	}

	public int findCelebrityBetter(int n, boolean[][] arr) {
		if (n <= 1) {
			return -1;
		}

		int left = 0;
		int right = n - 1;

		// Step 1: Find the potential candidate
		while (left < right) {
			if (arr[left][right]) {
				left++;
			} else {
				right--;
			}
		}

		// Step 2: Validate the candidate
		int candidate = right;
		for (int i = 0; i < n; i++) {
			if (i != candidate && (!arr[i][candidate] || arr[candidate][i])) {
				return -1;
			}
		}

		return candidate;
	}

	public static void main(String[] args) {

	}
}

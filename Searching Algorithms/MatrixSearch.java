
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MatrixSearch {
	public static boolean matrixSearch(List<List<Integer>> A, int x) {
		int row = 0, col = A.get(0).size() - 1; // Start from the top-right
												// corner.
		// Keeps searching while there are unclassified rows and columns.
		while (row < A.size() && col >= 0) {
			if (A.get(row).get(col).equals(x)) {
				return true;
			} else if (A.get(row).get(col) < x) {
				++row; // Eliminate this row.
			} else { // A.get(row).get(col) > x.
				--col; // Eliminate this column.
			}
		}
		return false;
	}

	// O(n^2) solution for verifying answer.
	private static boolean bruteForceSearch(List<List<Integer>> A, int x) {
		for (List<Integer> aA : A) {
			for (int anAA : aA) {
				if (anAA == x) {
					return true;
				}
			}
		}
		return false;
	}

	public static void main(String[] args) {
		Random r = new Random();
		for (int times = 0; times < 10000; ++times) {
			int n, m;
			if (args.length == 2) {
				n = Integer.parseInt(args[0]);
				m = Integer.parseInt(args[1]);
			} else {
				n = r.nextInt(100) + 1;
				m = r.nextInt(100) + 1;
			}
			List<List<Integer>> A = new ArrayList<>(n);
			for (int i = 0; i < n; i++) {
				A.add(new ArrayList(m));
				for (int j = 0; j < m; j++) {
					A.get(i).add(0);
				}
			}
			A.get(0).set(0, r.nextInt(100));
			for (int i = 0; i < n; ++i) {
				for (int j = 0; j < m; ++j) {
					int up = (i == 0) ? 0 : A.get(i - 1).get(j);
					int left = (j == 0) ? 0 : A.get(i).get(j - 1);
					A.get(i).set(j, Math.max(up, left) + r.nextInt(20) + 1);
				}
			}
			int x = r.nextInt(1000);
			assert (bruteForceSearch(A, x) == matrixSearch(A, x));
		}
	}
}

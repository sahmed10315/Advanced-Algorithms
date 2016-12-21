
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TrappingRainWater {
	private static int getIndexOfMaxElement(List<Integer> A) {
		int max = Integer.MIN_VALUE;
		int maxH = -1;
		for (int i = 0; i < A.size(); i++) {
			if (A.get(i) > max) {
				max = A.get(i);
				maxH = i;
			}
		}
		return maxH;
	}

	// @include
	public static int calculateTrappingWater(List<Integer> A) {
		if (A.isEmpty()) {
			return 0;
		}

		// Finds the index with maximum height.
		int maxH = getIndexOfMaxElement(A);

		// Calculates the water within A.subList(1, maxH).
		int sum = 0, left = A.get(0);
		for (int i = 1; i < maxH; ++i) {
			if (A.get(i) >= left) {
				left = A.get(i);
			} else {
				sum += left - A.get(i);
			}
		}

		// Calculates the water within A.subList(maxH + 1, A.size() - 1).
		int right = A.get(A.size() - 1);
		for (int i = A.size() - 2; i > maxH; --i) {
			if (A.get(i) >= right) {
				right = A.get(i);
			} else {
				sum += right - A.get(i);
			}
		}
		return sum;
	}

	public static void main(String[] args) {

		List<Integer> A = new ArrayList<>();
		A.add(1);
		A.add(5);
		A.add(2);
		A.add(3);
		A.add(1);
		A.add(7);
		A.add(2); 
		A.add(4);
		System.out.println(A);
		System.out.println(calculateTrappingWater(A));

	}
}
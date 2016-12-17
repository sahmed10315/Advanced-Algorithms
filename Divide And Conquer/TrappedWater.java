import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TrappedWater {
	public static int getMaxTrappedWater(List<Integer> heights) {
		int i = 0, j = heights.size() - 1, maxWater = 0;
		while (i < j) {
			int width = j - i;
			maxWater = Math.max(maxWater, width * Math.min(heights.get(i), heights.get(j)));
			if (heights.get(i) > heights.get(j)) {
				--j;
			} else if (heights.get(i) < heights.get(j)) {
				++i;
			} else { // heights.get(i) == heights.get(j).
				++i;
				--j;
			}
		}
		return maxWater;
	}

	public static void main(String[] args) {
		Random r = new Random();
		List<Integer> heights = new ArrayList<>(15);
		for (int i = 0; i < 15; i++)
			heights.add(r.nextInt(1000) + 1);
		System.out.println(getMaxTrappedWater(heights));
	}

}
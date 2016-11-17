
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List; 

public class JumpGame {
	public static boolean canReachEnd(List<Integer> maxAdvanceSteps) {
		int furthestReachSoFar = 0, lastIndex = maxAdvanceSteps.size() - 1;
		for (int i = 0; i <= furthestReachSoFar && furthestReachSoFar < lastIndex; ++i) {
			furthestReachSoFar = Math.max(furthestReachSoFar, i + maxAdvanceSteps.get(i));
		}
		return furthestReachSoFar >= lastIndex;
	}

	public static void main(String[] args) {
		List<Integer> maxAdvanceSteps = new ArrayList<>(10);
		maxAdvanceSteps.addAll(Arrays.asList(2, 4, 1, 1,0,2,3));
		System.out.println(canReachEnd(maxAdvanceSteps));
	}
}
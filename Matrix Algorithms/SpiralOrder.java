
import java.util.ArrayList; 
import java.util.List; 

public class SpiralOrder {
	// @include
	public static List<Integer> matrixInSpiralOrder(List<List<Integer>> squareMatrix) {
		List<Integer> spiralOrdering = new ArrayList<>();
		for (int offset = 0; offset < Math.ceil(0.5 * squareMatrix.size()); ++offset) {
			matrixLayerInClockwise(squareMatrix, offset, spiralOrdering);
		}
		return spiralOrdering;
	}

	private static void matrixLayerInClockwise(List<List<Integer>> squareMatrix, int offset,
			List<Integer> spiralOrdering) {
		if (offset == squareMatrix.size() - offset - 1) {
			// squareMatrix has odd dimension, and we are at its center.
			spiralOrdering.add(squareMatrix.get(offset).get(offset));
			return;
		}

		for (int j = offset; j < squareMatrix.size() - offset - 1; ++j) {
			spiralOrdering.add(squareMatrix.get(offset).get(j));
		}
		for (int i = offset; i < squareMatrix.size() - offset - 1; ++i) {
			spiralOrdering.add(squareMatrix.get(i).get(squareMatrix.size() - offset - 1));
		}
		for (int j = squareMatrix.size() - offset - 1; j > offset; --j) {
			spiralOrdering.add(squareMatrix.get(squareMatrix.size() - offset - 1).get(j));
		}
		for (int i = squareMatrix.size() - offset - 1; i > offset; --i) {
			spiralOrdering.add(squareMatrix.get(i).get(offset));
		}
	} 
 
	public static void main(String[] args) { 
		List<List<Integer>> A = new ArrayList<>();
		int k = 1;
		for (int i = 0; i < (4); ++i) {
			A.add(new ArrayList<Integer>());
			for (int j = 0; j < (4); ++j) {
				A.get(i).add(k++);
			}
		}
		List<Integer> result = matrixInSpiralOrder(A);
		for (Integer a : result) {
			System.out.print(a + " ");
		}
		System.out.println();
	}
}
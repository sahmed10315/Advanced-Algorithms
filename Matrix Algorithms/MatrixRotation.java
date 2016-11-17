
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MatrixRotation {

	public static void rotateMatrix(List<List<Integer>> squareMatrix) {
		final int matrixSize = squareMatrix.size() - 1;
		for (int i = 0; i < (squareMatrix.size() / 2); ++i) {
			for (int j = i; j < matrixSize - i; ++j) {
				// Perform a 4-way exchange.
				int temp1 = squareMatrix.get(matrixSize - j).get(i);
				int temp2 = squareMatrix.get(matrixSize - i).get(matrixSize - j);
				int temp3 = squareMatrix.get(j).get(matrixSize - i);
				int temp4 = squareMatrix.get(i).get(j);
				squareMatrix.get(i).set(j, temp1);
				squareMatrix.get(matrixSize - j).set(i, temp2);
				squareMatrix.get(matrixSize - i).set(matrixSize - j, temp3);
				squareMatrix.get(j).set(matrixSize - i, temp4);
			}
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
		rotateMatrix(A);
	}
}

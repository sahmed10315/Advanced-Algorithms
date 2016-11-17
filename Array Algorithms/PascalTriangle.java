import java.util.ArrayList; 
import java.util.List; 

public class PascalTriangle {
	public static List<List<Integer>> generatePascalTriangle(int numRows) {
		List<List<Integer>> pascalTriangle = new ArrayList<>();
		for (int i = 0; i < numRows; ++i) {
			List<Integer> currRow = new ArrayList<>();
			for (int j = 0; j <= i; ++j) {
				// Set this entry to the sum of the two above adjacent entries
				// if they
				// exist.
				currRow.add(
						(j == 0 || j == i) ? 1 : pascalTriangle.get(i - 1).get(j - 1) + pascalTriangle.get(i - 1).get(j));
			}
			pascalTriangle.add(currRow);
		}
		return pascalTriangle;
	}

	public static void main(String[] args) {  
		List<List<Integer>> result = generatePascalTriangle(10);
		for (List<Integer> re : result) {
			for (Integer aRe : re) {
				System.out.print(aRe + " ");
			}
			System.out.println();
		}
	}
}

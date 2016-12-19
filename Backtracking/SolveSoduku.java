
public class SolveSoduku {

	/*
	 * Takes a partially filled-in grid and attempts to assign values to all
	 * unassigned locations in such a way to meet the requirements for Sudoku
	 * solution (non-duplication across rows, columns, and boxes)
	 */
	public final static int UNASSIGNED = 0;

	static boolean SolveSudoku(int grid[][]) {
		int row, col = 0;
		boolean flag = false;
		for (row = 0; row < grid.length; row++)
			for (col = 0; col < grid.length; col++)
				if (grid[row][col] == UNASSIGNED)
					flag = true;

		// If there is no unassigned location, we are done
		if (!flag)
			return true; // success!

		// consider digits 1 to 9
		for (int num = 1; num <= 9; num++) {
			// if looks promising
			if (isSafe(grid, row, col, num)) {
				// make tentative assignment
				grid[row][col] = num;

				// return, if success, yay!
				if (SolveSudoku(grid))
					return true;

				// failure, unmake & try again
				grid[row][col] = UNASSIGNED;
			}
		}
		return false; // this triggers backtracking
	}

	/*
	 * Returns a boolean which indicates whether any assigned entry in the
	 * specified row matches the given number.
	 */
	static boolean UsedInRow(int grid[][], int row, int num) {
		for (int col = 0; col < grid[0].length; col++)
			if (grid[row][col] == num)
				return true;
		return false;
	}

	/*
	 * Returns a boolean which indicates whether any assigned entry in the
	 * specified column matches the given number.
	 */
	static boolean UsedInCol(int grid[][], int col, int num) {
		for (int row = 0; row < grid.length; row++)
			if (grid[row][col] == num)
				return true;
		return false;
	}

	/*
	 * Returns a boolean which indicates whether any assigned entry within the
	 * specified 3x3 box matches the given number.
	 */
	static boolean UsedInBox(int grid[][], int boxStartRow, int boxStartCol, int num) {
		for (int row = 0; row < 3; row++)
			for (int col = 0; col < 3; col++)
				if (grid[row + boxStartRow][col + boxStartCol] == num)
					return true;
		return false;
	}

	/*
	 * Returns a boolean which indicates whether it will be legal to assign num
	 * to the given row,col location.
	 */
	static boolean isSafe(int grid[][], int row, int col, int num) {
		/*
		 * Check if 'num' is not already placed in current row, current column
		 * and current 3x3 box
		 */
		return !UsedInRow(grid, row, num) && !UsedInCol(grid, col, num)
				&& !UsedInBox(grid, row - row % 3, col - col % 3, num);
	}

	/* Driver Program to test above functions */
	public static void main(String[] args) {
		// 0 means unassigned cells
		int[][] grid = new int[][] { { 3, 0, 6, 5, 0, 8, 4, 0, 0 }, { 5, 2, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 8, 7, 0, 0, 0, 0, 3, 1 }, { 0, 0, 3, 0, 1, 0, 0, 8, 0 }, { 9, 0, 0, 8, 6, 3, 0, 0, 5 },
				{ 0, 5, 0, 0, 9, 0, 6, 0, 0 }, { 1, 3, 0, 0, 0, 0, 2, 5, 0 }, { 0, 0, 0, 0, 0, 0, 0, 7, 4 },
				{ 0, 0, 5, 2, 0, 6, 3, 0, 0 } };

		SolveSudoku(grid);

	}
}
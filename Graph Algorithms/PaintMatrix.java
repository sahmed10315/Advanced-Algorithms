
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;

public class PaintMatrix { 
	public static void flipColor(List<List<Boolean>> A, int x, int y) {
		final int[][] DIRS = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
		boolean color = A.get(x).get(y);

		A.get(x).set(y, !color); // Flips.
		for (int[] dir : DIRS) {
			int nextX = x + dir[0], nextY = y + dir[1];
			if (nextX >= 0 && nextX < A.size() && nextY >= 0 && nextY < A.get(nextX).size()
					&& A.get(nextX).get(nextY) == color) {
				flipColor(A, nextX, nextY);
			}
		}
	}

	private static class Coordinate {
		public Integer x;
		public Integer y;

		public Coordinate(Integer x, Integer y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void flipColorIter(List<List<Boolean>> A, int x, int y) {
		final int[][] DIRS = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
		boolean color = A.get(x).get(y);

		Queue<Coordinate> q = new LinkedList<>();
		A.get(x).set(y, !A.get(x).get(y)); // Flips.
		q.add(new Coordinate(x, y));
		while (!q.isEmpty()) {
			Coordinate curr = q.element();
			for (int[] dir : DIRS) {
				Coordinate next = new Coordinate(curr.x + dir[0], curr.y + dir[1]);
				if (next.x >= 0 && next.x < A.size() && next.y >= 0 && next.y < A.get(next.x).size()
						&& A.get(next.x).get(next.y) == color) {
					// Flips the color.
					A.get(next.x).set(next.y, !color);
					q.add(next);
				}
			}
			q.remove();
		}
	}

	public static void main(String[] args) {
		int n;
		Random gen = new Random();
		if (args.length == 1) {
			n = Integer.parseInt(args[0]);
		} else {
			n = gen.nextInt(100) + 1;
		}
		List<List<Boolean>> A = new ArrayList<>(n);
		for (int i = 0; i < n; ++i) {
			A.add(new ArrayList(n));
			for (int j = 0; j < n; ++j) {
				A.get(i).add(gen.nextBoolean());
			}
		}
		int i = gen.nextInt(n), j = gen.nextInt(n);
		System.out.println("color = " + i + " " + j + " " + A.get(i).get(j));
		System.out.println(A);
		flipColor(A, i, j);
		System.out.println(A);
	}
}

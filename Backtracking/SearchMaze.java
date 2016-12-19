
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class SearchMaze {
	public static class Coordinate {
		public int x, y;

		public Coordinate(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static enum Color {
		WHITE, BLACK
	}

	public static List<Coordinate> searchMaze(List<List<Color>> maze, Coordinate s, Coordinate e) {
		List<Coordinate> path = new ArrayList<>();
		maze.get(s.x).set(s.y, Color.BLACK);
		path.add(s);
		if (!searchMazeHelper(maze, s, e, path)) {
			path.remove(path.size() - 1);
		}
		return path; // Empty path means no path between s and e.
	}

	// Performs DFS to find a feasible path.
	private static boolean searchMazeHelper(List<List<Color>> maze, Coordinate cur, Coordinate e,
			List<Coordinate> path) {
		if (cur.equals(e)) {
			return true;
		}

		final int[][] SHIFT = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
		for (int[] s : SHIFT) {
			Coordinate next = new Coordinate(cur.x + s[0], cur.y + s[1]);
			if (isFeasible(next, maze)) {
				maze.get(next.x).set(next.y, Color.BLACK);
				path.add(next);
				if (searchMazeHelper(maze, next, e, path)) {
					return true;
				}
				path.remove(path.size() - 1);
			}
		}
		return false;
	}

	// Checks cur is within maze and is a white pixel.
	private static boolean isFeasible(Coordinate cur, List<List<Color>> maze) {
		return cur.x >= 0 && cur.x < maze.size() && cur.y >= 0 && cur.y < maze.get(cur.x).size()
				&& maze.get(cur.x).get(cur.y) == Color.WHITE;
	} 

	public static void main(String[] args) {
		Random r = new Random();
		int n, m;
		n = r.nextInt(30) + 1;
		m = r.nextInt(30) + 1;

		List<List<Color>> maze = new ArrayList<>(n);
		for (int i = 0; i < n; ++i) {
			maze.add(new ArrayList(m));
			for (int j = 0; j < m; ++j) {
				maze.get(i).add(Color.values()[r.nextInt(2)]);
			}
		}
		List<Coordinate> white = new ArrayList<>();
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < m; ++j) {
				if (maze.get(i).get(j) == Color.WHITE) {
					white.add(new Coordinate(i, j));
				}
				System.out.print(maze.get(i).get(j) + " ");
			}
			System.out.println();
		}
		System.out.println();
		if (white.size() != 0) {
			int start = r.nextInt(white.size());
			int end = r.nextInt(white.size());
			System.out.println(white.get(start));
			System.out.println(white.get(end));
			List<Coordinate> path = searchMaze(maze, white.get(start), white.get(end));
			if (!path.isEmpty()) {
				assert (white.get(start).equals(path.get(0)) && white.get(end).equals(path.get(path.size() - 1)));
			}
			Coordinate prev = null;
			for (Coordinate curr : path) {
				if (prev != null) {
					assert (Math.abs(prev.x - curr.x) + Math.abs(prev.y - curr.y) == 1);
				}
				prev = curr;
				System.out.println("(" + curr.x + "," + curr.y + ")");
			}
		}
 
	}
}
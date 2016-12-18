
	import java.awt.Point;
import java.util.ArrayList;
	import java.util.Hashtable; 
 
public class RobotInAGrid { 


 
		public static int[][] maze = new int[10][10];
		
		public static boolean isFree(int x, int y) {
			if (maze[x][y] == 0) {
				return false;
			} else {
				return true;
			}
		}
		
		public static boolean getPath(int x, int y, ArrayList<Point> path) {
			// If out of bounds or not available, return.
			if (y < 0 || x < 0 || !isFree(x, y)) {
				return false;
			}
			
			boolean isAtOrigin = (x == 0) && (y == 0);
			
			// If there's a path from the start to my current location, add my location.
			if (isAtOrigin || getPath(x, y - 1, path) || getPath(x - 1, y, path)) { 
				Point p = new Point(x, y);
				path.add(p);
				return true;
			}
			
			return false;
		}

		public static int randomIntInRange(int min, int max) {
			return randomInt(max + 1 - min) + min;
		}

		public static int randomInt(int n) {
			return (int) (Math.random() * n);
		}
		public static int[][] randomMatrix(int M, int N, int min, int max) {
			int[][] matrix = new int[M][N];
			for (int i = 0; i < M; i++) {
				for (int j = 0; j < N; j++) {
					matrix[i][j] = i + j + 1;
				}
			}
			return matrix;
		}
		public static void main(String[] args) {
			int size = 5;
			maze = randomMatrix(size, size, 0, 5);
			for (int i = 0; i < maze.length; i++){
				for (int j = 0; j < maze.length; j++) 
					System.out.print(maze[i][j] + " ");
					System.out.println();
				}
			
			ArrayList<Point> path = new ArrayList<Point>();
			boolean success = getPath(size - 1, size - 1, path);
			 
		}

	}




//oranges rotten 

public class TimeToRotAllOrange {

	public static void main(String[] args) {
		TimeToRotAllOrange b = new TimeToRotAllOrange();
		int arr[][] = new int[][] { { 2, 1, 0, 2, 1 }, { 1, 0, 1, 2, 1 }, { 1, 0, 0, 2, 1 } };
		// int ans = b.rotOranges(arr);
		// if (ans == -1)
		// System.out.println("All oranges cannot rot");
		// else
		// System.out.println("Time required for all oranges to rot => " + ans);

		timeToRotFarm(arr);
		// for(int i = 0; i < farm.length; i++) {
		// for(int j = 0; j < farm[0].length; j++)
		// System.out.print(farm[i][j] + " ");
		// System.out.println();
		// }
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				if (arr[i][j] == 1) {
					timeToRot = -1;
					break;
				}
			}
		}
		System.out.println(timeToRot);
	}

	static int timeToRot = 0;

	private static void timeToRotFarm(int[][] farm) {
		boolean[][] visited = new boolean[farm.length][farm[0].length];
		for (int i = 0; i < farm.length; i++) {
			for (int j = 0; j < farm[0].length; j++) {
				if (farm[i][j] == 2)
					rotCrop(farm, i, j, visited);
			}
		}
	}

	private static void rotCrop(int[][] farm, int i, int j, boolean[][] visited) {
		if (i < 0 || i == farm.length || j < 0 || j == farm[0].length || farm[i][j] == 0 || visited[i][j])
			return;
		if (farm[i][j] == 2) {
			visited[i][j] = true;
			// move north
			rotCrop(farm, i - 1, j, visited);
			// move east
			rotCrop(farm, i, j + 1, visited);
			// move south
			rotCrop(farm, i + 1, j, visited);
			// move west
			rotCrop(farm, i, j - 1, visited);
			return;
		} else if (farm[i][j] == 1) {
			// farm[i][j] = 1, it's fresh so infect it
			farm[i][j] = 2;
			timeToRot++;
			rotCrop(farm, i, j, visited);
		}
	}
}
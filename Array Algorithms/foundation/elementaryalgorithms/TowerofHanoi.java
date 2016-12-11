package foundation.elementaryalgorithms;

public class TowerofHanoi {

	static int nDisks = 3;

	public static void main(String[] args) {
		moveDisks(nDisks, 'A', 'B', 'C');
	}

	public static void moveDisks(int topN, char src, char inter, char dest) {
		if (topN == 1)
			System.out.println("Disk 1 from " + src + " to " + dest);
		else {
			moveDisks(topN - 1, src, dest, inter); // src to inter

			System.out.println("Disk " + topN + // move bottom
					" from " + src + " to " + dest);
			moveDisks(topN - 1, inter, src, dest); // inter to dest
		}
	}
}

package geometrical;

public class DrawCircle {

	public static void main(String[] args) {
		drawCircle(10);
		drawCircleNaive();
	}

	static void drawCircleNaive() {
		int r = 10;
		for (int i = -r; i <= r; i++) {
			for (int j = -r; j <= r; j++) {
				if (Math.round(Math.sqrt(i * i + j * j)) == r)
					System.out.print("*");
				else
					System.out.print(" ");
			}
			System.out.println();
		}
	}

	static void drawCircle(int r) {
		// Consider a rectangle of size N*N
		int N = 2 * r + 1;

		int x, y; // Coordinates inside the rectangle

		// Draw a square of size N*N.
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				// Start from the left most corner point
				x = i - r;
				y = j - r;

				// If this point is inside the circle, print it
				if (x * x + y * y <= r * r + 1)
					System.out.print("*");
				else // If outside the circle, print space
					System.out.print(" ");
				System.out.print(" ");
			}
			System.out.print("\n");
		}
	}

}

package geometrical;

public class DrawCircle {

	public static void main(String[] args) {
		drawCircle(10);
		drawCircleBF();
	}

	static void drawCircleBF() {
		int r = 10;
		for (int x = -r; x <= r; x++) {
			for (int y = -r; y <= r; y++) {
				if (Math.round(Math.sqrt(x * x + y * y)) == r)
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
	
	void drawCircle(int r, int xCenter, int yCenter)
	{
	    double r2 = r * r;
	    double x = 0;
	    double y = r;
	    while (y >= x)
	    {
	        y = Math.sqrt(r2 - (x * x)) + 0.5; // round up
	        x++;

	        SetPixel(xCenter + x, yCenter + y);
	        SetPixel(xCenter + x, yCenter - y);
	        SetPixel(xCenter - x, yCenter + y);
	        SetPixel(xCenter - x, yCenter - y);
	        SetPixel(xCenter + y, yCenter + x);
	        SetPixel(xCenter + y, yCenter - x);
	        SetPixel(xCenter - y, yCenter + x);
	        SetPixel(xCenter - y, yCenter - x);
	    }
	}

	private void SetPixel(double f, double d) { 
		return;
	}
}

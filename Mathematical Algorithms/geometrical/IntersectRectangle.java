package geometrical;

public class IntersectRectangle {
	public static class Rectangle {
		int x, y, width, height;

		public Rectangle(int x, int y, int width, int height) {
			this.x = x;
			this.y = y;
			this.width = width;
			this.height = height;
		}

		public void print(String s) {
			System.out.println(s + x + " " + y + " " + width + " " + height);
		}
	}

	public static Rectangle intersectRectangle(Rectangle R1, Rectangle R2) {
		if (!isIntersect(R1, R2)) {
			return new Rectangle(0, 0, -1, -1); // No intersection.
		}
		return new Rectangle(Math.max(R1.x, R2.x), Math.max(R1.y, R2.y),
				Math.min(R1.x + R1.width, R2.x + R2.width) - Math.max(R1.x, R2.x),
				Math.min(R1.y + R1.height, R2.y + R2.height) - Math.max(R1.y, R2.y));
	}

	public static boolean isIntersect(Rectangle R1, Rectangle R2) {
		return R1.x <= R2.x + R2.width && R1.x + R1.width >= R2.x && R1.y <= R2.y + R2.height
				&& R1.y + R1.height >= R2.y;
	}

	public static void main(String[] args) {
		Rectangle R1, R2;
		R1 = new Rectangle(Integer.parseInt(args[0]), Integer.parseInt(args[1]), Integer.parseInt(args[2]),
				Integer.parseInt(args[3]));
		R2 = new Rectangle(Integer.parseInt(args[4]), Integer.parseInt(args[5]), Integer.parseInt(args[6]),
				Integer.parseInt(args[7]));

		// Intersect rectangle.
		boolean res = isIntersect(R1, R2);
		System.out.println(res);
		Rectangle ans = intersectRectangle(R1, R2);
		ans.print("ans: ");
	}
}
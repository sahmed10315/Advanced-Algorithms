package geometrical;

public class RectangleOverlap {

	class Point {
		public int x;
		public int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	class Rect {
		public Point ul;
		public Point lr;

		public Rect(Point ul, Point lr) {
			this.ul = ul;
			this.lr = lr;
		}
	}

	boolean overlap(Rect a, Rect b) {
		return !(a.ul.x > b.lr.x || a.ul.y < b.lr.y || a.lr.x < b.ul.x | a.lr.y > b.ul.y);
	}
}

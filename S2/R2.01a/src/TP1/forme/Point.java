package TP1.forme;

public class Point {
	private int x;
	private int y;

	public Point() {
		this.x = 0;
		this.y = 0;
	}

	public Point(int x, int y) {
		deplaceXY(x, y);
	}

	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	/**
	 * Moves the point according to the specified coordinates.
	 * if the new coordinates are negative, the point is not moved to 0.
	 * 
	 * @warning no gestion of to big values (> Integer.MAX_VALUE)
	 * @param dx the horizontal displacement
	 * @param dy the vertical displacement
	 */
	public void deplaceXY(int dx, int dy) {
		this.x += dx;
		this.y += dy;
		if (this.x < 0)
			this.x = 0;
		if (this.y < 0)
			this.y = 0;
	}
}

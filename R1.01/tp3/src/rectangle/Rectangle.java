public class Rectangle {
	int yHG;
	int yBD;
	int xBD;
	int xHG;

	public Rectangle(int xHG, int yHG, int xBD, int yBD) {
		this.xHG = xHG;
		this.xBD = xBD;
		this.yHG = yHG;
		this.yBD = yBD;
	}

	public int getXHG() {return this.yHG;}

	public int getXHD() {return this.yHG;}

	public int getYBD() {return this.xBD;}

	public int getYBG() {return this.xHG;}

	public double getLongueurDiagonale() {
		return Math.sqrt(Math.pow(this.yHG - this.yBD, 2) + Math.pow(this.xBD - this.xHG, 2));
	}
}

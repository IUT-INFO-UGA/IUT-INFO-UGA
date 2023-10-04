public class TriangleCompose {
	private Point somA;
	private Point somB;
	private Point somC;

	public TriangleCompose(Point somA, Point somB, Point somC) {
		this.somA = new Point(somA.getX(), somA.getY());
		this.somB = new Point(somB.getX(), somB.getY());
		this.somC = new Point(somC.getX(), somC.getY());
	}

	public Point getSomA() {return somA;}

	public Point getSomB() {return somB;}

	public Point getSomC() {return somC;}

	public double getCoteAB() {
		// { } => { résultat = longueur du côté d'extrémités somA et somB }
		final int arg1 = (int) Math.pow(this.somA.getX() - this.somB.getX(), 2);
		final int arg2 = (int) Math.pow(this.somA.getY() - this.somB.getY(), 2);
		return Math.sqrt((arg1) + arg2);
	}

	public double getCoteAC() {
		// { } => { résultat = longueur du côté d'extrémités somA et somC }
		final int arg1 = (int) Math.pow(this.somA.getX() - this.somC.getX(), 2);
		final int arg2 = (int) Math.pow(this.somA.getY() - this.somC.getY(), 2);
		return Math.sqrt((arg1) + arg2);
	}

	public double getCoteBC() {
		// { } => { résultat = longueur du côté d'extrémités somB et somC }
		final double arg1 = Math.pow(this.somB.getX() - this.somC.getX(), 2);
		final double arg2 = Math.pow(this.somB.getY() - this.somC.getY(), 2);
		return Math.sqrt((arg1) + arg2);
	}

	public double perimetre() {
		// { } => { résultat = périmètre de ce Triangle }
		return (getCoteAB() + getCoteAC() + getCoteBC());
	}

	public double surface() {
		// { } => { résultat = surface de ce Triangle }
		final double a = getCoteAB();
		final double b = getCoteAC();
		final double c = getCoteBC();

		final double p = (a + b + c) / 2;
		return (Math.sqrt(p * (p - a) * (p - b) * (p - c)));
	}

	public void deplacer(int dx, int dy) {
		// { } => { les sommets de ce Triangle sont déplacés
		// horizontalement de dx et verticalement de dy }
		somA.deplace(dx, dy);
		somB.deplace(dx, dy);
		somC.deplace(dx, dy);
	}

	@Override
	public String toString() {
		return "* Sommets : " + somA + " " + somB + " " + somC + " \n" +
				"* Périmètre : " + Math.round(100 * perimetre()) / 100.0 + "\n" +
				"* Surface : " + Math.round(100 * surface()) / 100.0;
	}
}


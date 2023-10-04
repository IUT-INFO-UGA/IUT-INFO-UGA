import java.util.Scanner;

public class Triangle_Utilitaire {

	public static Point saisirPoint() {
		final Scanner in = new Scanner(System.in);
		// { } => {résultat = un Point dont les coordonnées
		// sont saisies par l'utilisateur}
		System.out.print("enter x du point");
		final int x = in.nextInt();
		in.nextLine();
		System.out.print("enter y du point");
		final int y = in.nextInt();
		in.nextLine();
		return (new Point(x, y));
	}

	public static Point saisirPointNonConfondu(Point lePoint) {
		// { } => {résultat = un Point non confondu avec lePoint,
		// dont les coordonnées sont saisies par l'utilisateur}
		final Scanner in = new Scanner(System.in);
		Point monPoin;
		do {
			monPoin = saisirPoint();
		} while (monPoin.getY() == lePoint.getY() && monPoin.getX() == lePoint.getX());
		return (monPoin);
	}

	private static boolean comparePoint(Point p1, Point p2, Point p3) {
		if ((p1.getX() == p2.getX() && p1.getX() == p3.getX()) || (p1.getY() == p2.getY() && p1.getY() == p3.getY())) {
			return false;
		}
		if ((p1.getX() != p2.getX() && p1.getX() != p3.getX() && p2.getX() != p3.getX()) &&
				((p2.getY() - p1.getY()) / (p2.getX() - p1.getX()) ==
						(p3.getY() - p1.getY()) / (p3.getX() - p1.getX()))) {
			return false;
		}
		return true;
	}

	public static Point saisirPointNonAligneP1P2(Point P1, Point P2) {
		// { } => { résultat = un Point saisi par l'utilisateur, différent de P1 et
		// et de P2 et non aligné avec P1 et P2 }
		final Scanner in = new Scanner(System.in);
		Point pointEntrer = P1;
		while (!comparePoint(P1, P2, pointEntrer)) {
			System.out.print("enter x du point");
			final int x = in.nextInt();
			in.nextLine();
			System.out.print("enter y du point");
			final int y = in.nextInt();
			in.nextLine();
			pointEntrer = new Point(x, y);
		}

		return (pointEntrer);
	}

	public static TriangleCompose symetriqueV(TriangleCompose tComp) {
		// { } =>
		// { résultat = nouveau TriangleCompose dont les sommets sont obtenus par
		// symétrie par rapport à l'axe vertical des sommets de tComp }
		final TriangleCompose myTComp = new TriangleCompose(tComp.getSomA(), tComp.getSomB(), tComp.getSomC());
		myTComp.getSomA().setX(-tComp.getSomA().getX());
		myTComp.getSomB().setX(-tComp.getSomB().getX());
		myTComp.getSomC().setX(-tComp.getSomC().getX());
		return myTComp;
	}

	public static TriangleCompose symetriqueH(TriangleCompose tComp) {
		// { } =>
		// { résultat = nouveau TriangleCompose dont les sommets sont obtenus par
		// symétrie par rapport à l'axe horizontal des sommets de tComp }
		final TriangleCompose myTComp = new TriangleCompose(tComp.getSomA(), tComp.getSomB(), tComp.getSomC());
		myTComp.getSomA().setY(-tComp.getSomA().getY());
		myTComp.getSomB().setY(-tComp.getSomB().getY());
		myTComp.getSomC().setY(-tComp.getSomC().getY());
		return myTComp;
	}
}

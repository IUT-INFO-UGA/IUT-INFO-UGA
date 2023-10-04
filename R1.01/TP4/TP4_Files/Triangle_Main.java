import java.util.Scanner;

public class Triangle_Main {
	public static void main(String[] args) {
		final Scanner in = new Scanner(System.in);
		final Point ptA = new Point(1, 1);
		final Point ptB = new Point(3, 5);
		final Point ptC = new Point(5, 1);
		final TriangleCompose tComp = new TriangleCompose(ptA, ptB, ptC);
		final TriangleAgrege tArg = new TriangleAgrege(ptA, ptB, ptC);
		System.out.println("ptA:" + ptA + "\nptB:" + ptB + "\nptC:" + ptC);
		System.out.println(tComp);
		System.out.println();
		System.out.println(tArg);
		System.out.print("entrer dx (entier) :");
		final int dx = in.nextInt();
		in.nextLine();
		System.out.print("entrer dy (entier) :");
		final int dy = in.nextInt();
		in.nextLine();
		tComp.deplacer(dx, dy);
		System.out.println("ptA:" + ptA + "\nptB:" + ptB + "\nptC:" + ptC);
		System.out.println(tComp);
		System.out.println();
		tArg.deplacer(dx, dy);
		System.out.println("ptA:" + ptA + "\nptB:" + ptB + "\nptC:" + ptC);
		System.out.println(tArg);
	}
}

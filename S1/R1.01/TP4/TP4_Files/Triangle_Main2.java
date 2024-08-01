import java.util.Scanner;

public class Triangle_Main2 {
	public static void main(String[] args) {
		final Scanner in = new Scanner(System.in);
		final Point ptA = Triangle_Utilitaire.saisirPoint();
		System.out.println("point 2");
		final Point ptB = Triangle_Utilitaire.saisirPointNonConfondu(ptA);
		System.out.println("point 3");
		final Point ptC = Triangle_Utilitaire.saisirPointNonAligneP1P2(ptA, ptB);
		final TriangleCompose tComp = new TriangleCompose(ptA, ptB, ptC);
		System.out.println("ptA:" + ptA + "\nptB:" + ptB + "\nptC:" + ptC);
		System.out.println(tComp);
		final TriangleCompose tCompH = Triangle_Utilitaire.symetriqueH(tComp);
		System.out.println(tCompH);
		final TriangleCompose tCompv = Triangle_Utilitaire.symetriqueV(tComp);
		System.out.println(tCompv);
		System.out.print("entrer dx (entier) :");
		final int dx = in.nextInt();
		in.nextLine();
		System.out.print("entrer dy (entier) :");
		final int dy = in.nextInt();
		in.nextLine();
		tComp.deplacer(dx, dy);
		System.out.println(tComp);
		System.out.println(tCompH);
		System.out.println(tCompv);
	}
}

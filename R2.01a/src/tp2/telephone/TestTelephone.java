package tp2.telephone;

public class TestTelephone {
	public static void main(String[] args) {
		// Liste de processeurs disponibles : Octa-Core 2.84Ghz et Octa-Core 3Ghz
		// A COMPLETER
		final Processeur Octa2 = new Processeur("Octa-Core 2.84Ghz", 2.84);
		final Processeur Octa3 = new Processeur("Octa-Core 3Ghz", 3);
		// Liste de ram disponibles : LPDDR5 4G et LPDDR5 8G
		// A COMPLETER
		final Memoire ram4 = new Memoire("LPDDR5 4G", 4);
		final Memoire ram8 = new Memoire("LPDDR5 8G", 8);
		// Liste de stockage disponibles : 3 mémoires UFS Storage 3.1 de grandeur
		// 64/128/256
		// A COMPLETER
		final Memoire stockage64 = new Memoire("UFS Storage 3.1 64G", 64);
		final Memoire stockage128 = new Memoire("UFS Storage 3.1 128G", 128);
		final Memoire stockage256 = new Memoire("UFS Storage 3.1 256G", 256);
		// Liste d'écran disponibles : 3 amoled de tailles 5/6/7
		// A COMPLETER
		final Ecran ecran5 = new Ecran("amoled", 5);
		final Ecran ecran6 = new Ecran("amoled", 6);
		final Ecran ecran7 = new Ecran("amoled", 7);
		///// Construction des téléphones
		// Bas de gamme
		final Telephone telephone1 = new Telephone("Bas de gamme", Octa2, ecran5, stockage64, ram4);
		telephone1.addRam(ram4);
		// A COMPLETER
		System.out.println(telephone1);
		// Moyen de gamme
		System.out.println(new Telephone("Moyen de gamme", Octa2, ecran6, stockage128, ram4));
		// Haut de gamme
		System.out.println(new Telephone("Haut de gamme", Octa3, ecran7, stockage256, ram8));
	}
}

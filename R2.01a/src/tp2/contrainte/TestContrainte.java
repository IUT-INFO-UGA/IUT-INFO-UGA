package tp2.contrainte;

public class TestContrainte {
	public static void main(String[] args) {
		Note note = new Note();
		System.out.println(note.getValeur());
		note.setValeur(10);
		System.out.println(note.getValeur());
		note.setValeur(30);
		System.out.println(note.getValeur());
		note.setValeur(-5);
		System.out.println(note.getValeur());

		System.out.println(ContrainteUtilitaire.saisir(0, 20));
	}
}

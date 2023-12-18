public class ExceptionDefautDispo extends Exception {
	// il faut utiliser extends Exception

	// il faut deux constructeurs
	// un constructeur par défaut comme suit
	public ExceptionDefautDispo() {}

	// un constructeur avec un paramètre s de type String
	// s : est un message d'erreur associé à l'exception
	public ExceptionDefautDispo(String s) {
		super(s);
	}
}

public class ExceptionMauvaisIndice extends Exception {
    // il faut utiliser extends Exception

    // il faut deux constructeurs
    // un constructeur par défaut comme suit
    public ExceptionMauvaisIndice() {
        super();
    }

    // un constructeur avec un paramètre s de type String
    // s : est un message d'erreur associé à l'exception
    public ExceptionMauvaisIndice(String s) {
        super(s);
    }
}

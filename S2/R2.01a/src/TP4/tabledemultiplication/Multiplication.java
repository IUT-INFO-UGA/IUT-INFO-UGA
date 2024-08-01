package TP4.tabledemultiplication;

public class Multiplication {
	private final int terme1;
	private final int terme2;
	private final boolean noError;
	Integer reponseUtilisateur = null;

	public Multiplication(int terme1, int terme2) {
		this.terme1 = terme1;
		this.terme2 = terme2;
		this.noError = false;
	}

	public Multiplication(int terme1, int terme2, boolean noError) {
		this.terme1 = terme1;
		this.terme2 = terme2;
		this.noError = noError;
	}

	public void setReponseUtilisateur(Integer reponseUtilisateur) throws ErreurMultiplicationException {
		this.reponseUtilisateur = reponseUtilisateur;
		if ((!isReponseJuste() && noError) || (reponseUtilisateur == null && !noError))
			throw new ErreurMultiplicationException();
	}

	public boolean isReponseJuste() {
		if (reponseUtilisateur == null)
			return false;
		return (terme1 * terme2) == reponseUtilisateur;
	}

	public String toString() {
		return terme1 + " * " + terme2 + " = ";
	}
}

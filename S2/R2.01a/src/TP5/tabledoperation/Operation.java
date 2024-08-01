package TP5.tabledoperation;

public abstract class Operation {
	private final Double terme1;
	private final Double terme2;
	private Double reponseUtilisateur;

	public abstract double calculResultat(Double terme1, Double terme2);

	public Operation(Double terme1, Double terme2) {
		this.terme1 = terme1;
		this.terme2 = terme2;
	}

	public void setReponseUtilisateur(double reponseUtilisateur) throws ErreurOperationException {
		this.reponseUtilisateur = reponseUtilisateur;
		if (!isReponseJuste())
			throw new ErreurOperationException();
	}

	public boolean existeReponseUtilisateur() {
		return reponseUtilisateur != null;
	}

	public boolean isReponseJuste() {
		return reponseUtilisateur == calculResultat(terme1, terme2);
	}

	public double getTerme1() {
		return terme1;
	}

	public double getTerme2() {
		return terme2;
	}
}

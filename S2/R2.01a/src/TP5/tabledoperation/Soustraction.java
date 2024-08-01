package TP5.tabledoperation;

public class Soustraction extends Operation {

	public Soustraction(Double terme1, Double terme2) {
		super(terme1, terme2);
	}

	public double calculResultat(Double terme1, Double terme2) {
		return getTerme1() - getTerme2();
	}

	@Override
	public String toString() {
		return getTerme1() + " - " + getTerme2() + " = ";
	}
}

package TP5.tabledoperation;

public class Addition extends Operation {

	Addition(double terme1, double terme2) {
		super(terme1, terme2);
	}

	public double calculResultat(Double terme1, Double terme2) {
		return getTerme1() + getTerme2();
	}

	@Override
	public String toString() {
		return getTerme1() + " + " + getTerme2() + " = ";
	}
}

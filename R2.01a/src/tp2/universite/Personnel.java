package tp2.universite;

public class Personnel extends Personne {
	// use short for optimization
	public static final short ECHELON_MIN = 1;
	public static final short ECHELON_Max = 4;
	public static final short POINT_INDICE_MIN = 1_000;
	public static final short POINT_INDICE_MAX = 1_200;
	int echelon;
	double pointDIndice;

	Personnel(String login, String prenom, String nom) {
		super(login, prenom, nom);
	}

	Personnel(String login, String prenom, String nom, int echelon, double pointDIndice) {
		super(login, prenom, nom);
		this.echelon = echelon;
		this.pointDIndice = pointDIndice;
	}

	// getters
	public int getEchelon() {
		return echelon;
	}

	public double getPointDIndice() {
		return pointDIndice;
	}

	public String getMail() {
		return getPrenom() + "." + getNom() + "@univ-grenoble-alpes.fr";
	}

	/**
	 * Calculates and returns the salary of the personnel.
	 * The salary is calculated based on the personnel's echelon and point d'indice.
	 * If the echelon is less than the minimum echelon, it is set to the minimum
	 * echelon.
	 * If the echelon is greater than the maximum echelon, it is set to the maximum
	 * echelon.
	 * If the point d'indice is less than the minimum point d'indice, it is set to
	 * the minimum point d'indice.
	 * If the point d'indice is greater than the maximum point d'indice, it is set
	 * to the maximum point d'indice.
	 * The salary is calculated by multiplying the echelon and point d'indice.
	 *
	 * @return the salary of the personnel
	 */
	public double getSalaire() {
		if (echelon < ECHELON_MIN) {
			echelon = ECHELON_MIN;
		} else if (echelon > ECHELON_Max) {
			echelon = ECHELON_Max;
		}

		if (pointDIndice < POINT_INDICE_MIN) {
			pointDIndice = POINT_INDICE_MIN;
		} else if (pointDIndice > POINT_INDICE_MAX) {
			pointDIndice = POINT_INDICE_MAX;
		}
		return echelon * pointDIndice;
	}

	// setters

	/**
	 * Sets the echelon of the personnel.
	 * If the specified echelon is less than the minimum echelon, it is set to the
	 * minimum echelon.
	 * If the specified echelon is greater than the maximum echelon, it is set to
	 * the maximum echelon.
	 * 
	 * @param echelon the echelon to set
	 */
	public void setEchelon(int echelon) {
		if (echelon < ECHELON_MIN) {
			echelon = ECHELON_MIN;
		} else if (echelon > ECHELON_Max) {
			echelon = ECHELON_Max;
		}
		this.echelon = echelon;
	}

	/**
	 * Sets the point d'indice of the personnel.
	 * If the specified point d'indice is less than the minimum point d'indice, it
	 * is set to the minimum point d'indice.
	 * If the specified point d'indice is greater than the maximum point d'indice,
	 * it is set to the maximum point d'indice.
	 * 
	 * @param pointDIndice the pointDIndice to set
	 */
	public void setPointDIndice(double pointDIndice) {
		if (pointDIndice < POINT_INDICE_MIN) {
			pointDIndice = POINT_INDICE_MIN;
		} else if (pointDIndice > POINT_INDICE_MAX) {
			pointDIndice = POINT_INDICE_MAX;
		}
		this.pointDIndice = pointDIndice;
	}
}

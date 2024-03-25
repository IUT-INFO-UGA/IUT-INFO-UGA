import Guerrier.Guerrier;

public class GuerrieurUtilitaire {
	public static String gerrierToString(Guerrier guerrier) {
		return "Guerrier.Guerrier[force=" + guerrier.getForce() + ",\n	PointDeVie=" + guerrier.getPointDeVie() + "]";
	}

	/**
	 * Throws N dice and calculates the total damage based on the force.
	 *
	 * @param force the force of the warrior
	 * @return the total damage inflicted
	 */
	public static int throwNDice(int force) {
		int degats = 0;
		for (int i = 0; i < force; i++) {
			degats += PlateauFactory.de3();
		}
		return degats;
	}
}
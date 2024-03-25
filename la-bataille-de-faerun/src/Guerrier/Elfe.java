public class Elfe extends Guerrier {
	public Elfe() {
		super();
	}

	/**
	 * Returns the strength of the ChefElfe.
	 * The strength is calculated by multiplying the strength of the superclass
	 * (Guerrier) by 2.
	 *
	 * @return the strength of the ChefElfe
	 */
	public int getForce() {
		return super.getForce() * 2;
	}
}

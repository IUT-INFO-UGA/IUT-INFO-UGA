package jeu.guerrierChild;

public class ChefElfe extends Elfe {
	public ChefElfe() {
		super();
	}

	/**
	 * Returns the strength of the ChefElfe.
	 * The strength is calculated by multiplying the strength of the superclass
	 * (Elfe) by 2.
	 *
	 * @return the strength of the ChefElfe
	 */
	public int getForce() {
		return super.getForce() * 2;
	}
}

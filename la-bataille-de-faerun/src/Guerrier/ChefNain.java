public class ChefNain extends Nain {
	public ChefNain() {
		super();
	}

	/**
	 * Reduces the character's health points by the specified amount of damage.
	 * The damage is divided by 2 before being applied to the character.
	 *
	 * @param degats the amount of damage to be inflicted on the character
	 */
	protected void subirDegats(int degats) {
		super.subirDegats(degats / 2);
	}
}

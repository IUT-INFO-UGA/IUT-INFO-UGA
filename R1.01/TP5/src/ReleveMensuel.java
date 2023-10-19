public class ReleveMensuel {
	private final String mois;
	private final float concentration;
	public ReleveMensuel(String mois, float concentration){
		this.mois = mois;
		this.concentration= concentration;
	}
	public String getMois() {return this.mois;}
	public float getConcentration() {return this.concentration;}

	public String toString() {
		return mois + " : " + concentration;
	}
}

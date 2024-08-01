package exercice1;

public class LoupGarou extends Loup implements Personne {
    public LoupGarou(String nom){
		super(nom);
	}

	public void parle(){
		System.out.println(super.getNom()+ " dit : j'ai une faim de loup :)");
	}
}

package exercice1;

public class Lapin extends Animal {
 public Lapin(String nom){
	 super(nom);
 }

	public void mange() {
		System.out.println(super.getNom() +"mange une carotte");
	}

	public void seDeplace() {
		System.out.println(super.getNom()+ " se deplace tranquillement");
	}
}

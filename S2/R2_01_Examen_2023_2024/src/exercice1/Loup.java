package exercice1;

public class Loup extends Animal {

	public Loup(String nom){
		super(nom);
	}

	public void mange(Animal animal) {
		System.out.println(super.getNom() +" mange "+ animal.getNom());
	}
	public void mange() {
		System.out.println(super.getNom() +" ronge un os");
	}

	public void seDeplace() {
		System.out.println(super.getNom()+ " se deplace silencieusement");
	}
}

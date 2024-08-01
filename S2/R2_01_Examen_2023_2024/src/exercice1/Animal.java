package exercice1;

public class Animal {
    private final String nom;

	public Animal(String nom) {
		this.nom = nom;
	}

	public void seDepace(){
		System.out.printf(nom + " se deplace");
	}

	public void mange(){
		System.out.println(nom + " mange");
	}

	public String getNom(){
		return nom;
	}
}

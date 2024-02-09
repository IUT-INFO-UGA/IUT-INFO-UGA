/**
 * FOURNIE
 */
public class EtudiantMain {

    public static void main(String[] args) {
//        System.out.println("*******************");
//        System.out.println("* Test SaisirNote *");
//        System.out.println("*******************\n");
//        float valFloat;
//        valFloat = EtudiantUtilitaire.saisirNote();

        System.out.println("\n*********************");
        System.out.println("* Test getMoyenneV1 *");
        System.out.println("*******************\n");
        Etudiant etu1 = new Etudiant("Blanchon", "Hervé");
        System.out.println("Saisir une première note pour " + etu1.getNomComplet() + " : ");
        etu1.addNote(EtudiantUtilitaire.saisirNote());
        System.out.println("Saisir une deuxième note pour " + etu1.getNomComplet() + " : ");
        etu1.addNote(EtudiantUtilitaire.saisirNote());
        // calcul de la moyenne avec getMoyenneV1()
        System.out.println("\n"+etu1.getNomComplet()+" a " + etu1.getNbNotes() + " notes\nMoyenne obtenue : " + etu1.getMoyenneV1());

        System.out.println("\n*********************");
        System.out.println("* Test getMoyenneV2 *");
        System.out.println("*******************\n");
        Etudiant etu2 = new Etudiant("Lejeune", "Anne");
        try {
            // calcul de la moyenne avec getMoyenneV2()
            System.out.println("\n"+etu2.getNomComplet()+" a " + etu2.getNbNotes() + " notes\nMoyenne obtenue : " + etu2.getMoyenneV2());
        } catch (ExceptionMoyenneNonCalculable e) {
            System.out.println("Problème...");
            System.out.println(e.getMessage());
        }
    }
}

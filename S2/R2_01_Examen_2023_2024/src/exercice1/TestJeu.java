package exercice1;

public class TestJeu {

    public static void main(String[] args) {

        // ATTENTION :
        // TRACE ATTENDUE DANS LE FICHIER TestJeu-trace.txt

        // DECOMMENTER POUR LANCER L'EXECUTION

        // Création des personnages
        Lapin leLapin = new Lapin("Jeannot");
        Loup leLoup = new Loup("Wolfy");
        LoupGarou MonLoupGarou = new LoupGarou("Remus");

        // Le lapin et le loup se déplacent
        leLapin.seDeplace();
        leLoup.seDeplace();
        leLapin.seDeplace();

        // Le lapin mange ... inconscient du danger
        leLapin.mange();

        // Le loup se déplace et mange le lapin
        leLoup.seDeplace();
        leLoup.mange(leLapin);

        // Le loup ronge les os
        leLoup.mange();

        // Le loupGarou parle, se déplace et mange le loup !
        MonLoupGarou.parle();
        MonLoupGarou.seDeplace();
        MonLoupGarou.mange(leLoup);

    }
    
}

import java.util.ArrayList;

/**
 * FOURNIE
 */
public class IlesMain {

    public static void main(String[] args) {
        ArrayList<Ile> lesIles = CreationArrayListIles.lesIles();
//
//        System.out.println("\n********************************************");
//        System.out.println("* Test de afficheNomIlesHemisphere *");
//        System.out.println("********************************************");
//        IlesEnArrayListUtilitaire.afficheNomIlesHemisphereNord(lesIles, 70);
//        System.out.println();
//        IlesEnArrayListUtilitaire.afficheNomIlesHemisphereSud(lesIles, -45);

//        System.out.println("\n**********************************");
//        System.out.println("* Test de afficheIlesPartagees *");
//        System.out.println("**********************************");
//        IlesEnArrayListUtilitaire.afficheIlesPartagees(lesIles);
//
//        System.out.println("\n*************************************");
//        System.out.println("* Test de afficheNomIlesDePays *");
//        System.out.println("*************************************");
//        IlesEnArrayListUtilitaire.afficheNomIlesDePays(lesIles, "Japan");
//
        System.out.println("\n************************************");
        System.out.println("* Test de triIlesBullesAmeliore *");
        System.out.println("************************************");
        // lesIles est maintenant trié
        IlesEnArrayListUtilitaire.triIlesBullesAmeliore(lesIles);
        //System.out.println(lesIles);
        // vérifier que lesIles est trié
        if (IlesEnArrayListUtilitaire.sontIlesTriees(lesIles)) {
            System.out.println("Les îles sont triés, c'est normal !");
        } else {
            System.out.println("Les îles ne sont pas triées, ce n'est pas normal !");
        }
//
        String nomPays;
        int indice;

        System.out.println("\n*******************************************");
        System.out.println("* Test de indicePremIleDePremPays_seq *");
        System.out.println("*******************************************");
        nomPays = "Japan";
        indice = IlesEnArrayListUtilitaire.indicePremIleDePremPays_seq(lesIles, nomPays);
        if (indice != -1) {
            System.out.println("Indice de la première île de " +  nomPays + " : " + indice);
            System.out.println("Cette île s'appelle : " + lesIles.get(indice).getNom());
        } else {
            System.out.println("Le pays " + nomPays + " n'a pas d'île.");
        }
        System.out.println();
        nomPays = "Switzerland";
        indice = IlesEnArrayListUtilitaire.indicePremIleDePremPays_seq(lesIles, nomPays);
        if (indice != -1) {
            System.out.println("Indice de la première île de " +  nomPays + " : " + indice);
            System.out.println("Cette île s'appelle : " + lesIles.get(indice).getNom());
        } else {
            System.out.println("Le pays " + nomPays + " n'a pas d'île.");
        }
//
        System.out.println("\n*********************************************");
        System.out.println("* Test de indicePremIleDePremPays_dicho *");
        System.out.println("*********************************************");
        nomPays = "Japan";
        indice = IlesEnArrayListUtilitaire.indicePremIleDePremPays_dicho(lesIles, nomPays);
        if (indice != -1) {
            System.out.println("Indice de la première île du pays " +  nomPays + " : " + indice);
            System.out.println("Cette île s'appelle : " + lesIles.get(indice).getNom());
        } else {
            System.out.println("Le pays " + nomPays + " n'a pas d'île.");
        }
        System.out.println();
        nomPays = "Switzerland";
        indice = IlesEnArrayListUtilitaire.indicePremIleDePremPays_dicho(lesIles, nomPays);
        if (indice != -1) {
            System.out.println("Indice de la première île du pays " +  nomPays + " : " + indice);
            System.out.println("Cette île s'appelle : " + lesIles.get(indice).getNom());
        } else {
            System.out.println("Le pays " + nomPays + " n'a pas d'île.");
        }
//
        System.out.println("\n***********************************");
        System.out.println("* Test de afficheIlesDePaysTrie *");
        System.out.println("***********************************");
        IlesEnArrayListUtilitaire.afficheIlesDePaysTrie(lesIles, "Japan");
        System.out.println();
        IlesEnArrayListUtilitaire.afficheIlesDePaysTrie(lesIles, "Switzerland");
    }
}

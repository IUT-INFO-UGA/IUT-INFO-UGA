public class PolarsMain {

    public static void main(String[] args) {

        ListeChaineeTriee<Polar> lesPolars;
        // À DÉCOMMENTER LORSQUE la méthode insereTriee sera codée - Exercice 11
//        lesPolars = CreationListePolars.lesPolars();
//
//        System.out.println("Nombre de polars : " + lesPolars.getLongueur());
//
//        System.out.println("*****************************");
//        System.out.println("* La liste est-elle triée ? *");
//        System.out.println("*****************************");
//        if (ListePolarsUtilitaire.estTriee(lesPolars)) {
//            System.out.println("La liste est bien triée comme attendu !");
//        } else {
//            System.out.println("La liste n'est pas triée malgré ce qu'on attendait !");
//        }


        /**
         * SI VOUS N'ARRIVEZ PAS À FAIRE L'EXERCICE 11
         * VEILLEZ À COMMENTER LES LIGNES 7 À 18
         * ET DÉCOMMENTEZ LA LIGNE 27 POUR DISPOSER D'UNE LISTE TRIÉE
         */
        // fabrication d'une liste triée
        lesPolars = CreationListePolars.chargementFichierTie();

//        System.out.println("\n*******************************************");
//        System.out.println("* Nombre de livres pour une année *");
//        System.out.println("*******************************************");
//        System.out.println("Nombre de livres en récursif pour 1900 : " + ListePolarsUtilitaire.nbLivresAnneeRec(lesPolars, 1900));
//        System.out.println("Nombre de livres en récursif pour 1975 : " + ListePolarsUtilitaire.nbLivresAnneeRec(lesPolars, 1975));
//        System.out.println("Nombre de livres en récursif pour 2000 : " + ListePolarsUtilitaire.nbLivresAnneeRec(lesPolars, 2000));
//
//        System.out.println("\n**************************************");
//        System.out.println("* Nombre de livres d'un auteur *");
//        System.out.println("**************************************");
//        String auteur = "RAYNAL";
//        System.out.println("Nombre de livres de " + auteur + " : " + ListePolarsUtilitaire.nbLivresAuteurIter(lesPolars, auteur));
//        auteur = "LEHANNE";
//        System.out.println("Nombre de livres de " + auteur + " : " + ListePolarsUtilitaire.nbLivresAuteurIter(lesPolars, auteur));
//        auteur = "POUY";
//        System.out.println("Nombre de livres de " + auteur + " : " + ListePolarsUtilitaire.nbLivresAuteurIter(lesPolars, auteur));
//
        System.out.println("\n*********************************************");
        System.out.println("* Nombre de livres de chaque auteur *");
        System.out.println("*********************************************");
        ListePolarsUtilitaire.afficheNbLivresAuteurs(lesPolars);
    }
}

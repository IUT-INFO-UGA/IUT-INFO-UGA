package exercice3;

import exercice3.utilitaires.MaquetteUtilitaire;

/**
 * 
 * NE PAS MODIFIER
 * 
 * @author fbm
 */
public class TestMaquette {
    
    public static void main(String[] args) {


        // ATTENTION :
        // TRACE ATTENDUE DANS LE FICHIER TestMaquette-trace.txt

        // DECOMMENTER POUR LANCER L'EXECUTION


        ///////////////////////////////////////
        // ETAPE 1
        System.out.println("Etape 1 : création de la maquette pédagogique");
        
        // Creer le semestre 1 (une version très simplifiée)
        // - contenant 2 modules : "M1102 (Algo)" et "M1106 (PT)"
        // - M1102 à 2 épreuves : controle continu coeff. 5 et une controle final coeff. 15
        // - M1106 à 1 épreuve : projet coeff. 10
        //
        // Creer le semestre 2 (une version très simplifiée)
        // - contenant 2 modules : "M2103 (Programmation)" et "M2104 (Conception)"
        // - M2103 à 2 épreuves : controle continu coeff. 10 et une controle final coeff. 20
        // - M2104 à 3 épreuves : projet coeff. 12, controle continu coeff. 8 et une controle final coeff. 10
        // 
        // PUIS afficher la maquette
        
        // Créer le semestre 1
        Semestre semestre1 = new Semestre("semestre 1");
        
        // Créer les modules et les épreuves associées
        // Algo
        Module m1102 = new Module("M1102 (Algo)", semestre1);
        Epreuve algo_intermediaire = new Epreuve(TypeEpreuve.ControleContinu, m1102, 5);
        Epreuve algo_machine = new Epreuve(TypeEpreuve.ControleFinal, m1102, 15);
        // M1106
        Module m1106 = new Module("M1106 (PT)", semestre1);
        Epreuve m1106_projet = new Epreuve(TypeEpreuve.Projet, m1106, 10);
        
        // Créer le semestre 2
        Semestre semestre2 = new Semestre("semestre 2");
        
        // Créer les modules et les épreuves associées
        // ATTENTION POO n'est pas dans le semestre 2 à la création. Il est ajouté après !!!
        Module m2103 = new Module("M2103 (Programmation)", null);
        Epreuve poo_qcm = new Epreuve(TypeEpreuve.ControleContinu, m2103, 10);
        Epreuve poo_machine = new Epreuve(TypeEpreuve.ControleFinal, m2103, 20);
        semestre2.addModule(m2103);
        // COO
        Module m2104 = new Module("M2104 (Conception)", semestre2);
        Epreuve coo_projet = new Epreuve(TypeEpreuve.Projet, m2104, 12);
        Epreuve coo_continu = new Epreuve(TypeEpreuve.ControleContinu, m2104, 8);
        Epreuve coo_final = new Epreuve(TypeEpreuve.ControleFinal, m2104, 10);
        
        // Afficher les semestres
        MaquetteUtilitaire.afficherSemestre(semestre1);
        MaquetteUtilitaire.afficherSemestre(semestre2);

        //
        System.out.println("\n========================");
        System.out.println("ATTENTION M1106 ETAIT MAL PLACE, on le replace dans le semestre 2");
        System.out.println("Ci-dessous, affichage des semestres après modification");
        semestre2.addModule(m1106);
        MaquetteUtilitaire.afficherSemestre(semestre1);
        MaquetteUtilitaire.afficherSemestre(semestre2);
        
        
        System.out.println("\n========================");
        System.out.println("Tester le lien etudiant/note/epreuve");
        
        // Création des notes de Francis
        Etudiant fbm = new Etudiant("Francis", "BM");
        Note note1 = new Note(poo_qcm, fbm, 17);
        Note note2 = new Note(poo_machine, fbm, 20);
        
        // Création des notes d'Hervé
        Etudiant hb = new Etudiant("Hervé", "B");
        note1 = new Note(poo_qcm, hb, 20);
        note2 = new Note(poo_machine, hb, 20);
        
        System.out.print("Note de l'epreuve POO QCM pour Francis : ");
        if (poo_qcm.containsNote(fbm)) {
            System.out.println(poo_qcm.getValeurNote(fbm));
        }
        
        System.out.print("Note de l'epreuve POO QCM pour Hervé : ");
        if (poo_qcm.containsNote(hb)) {
            System.out.println(poo_qcm.getValeurNote(hb));
        }


    }
}

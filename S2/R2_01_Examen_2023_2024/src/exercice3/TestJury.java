/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercice3;

import exercice3.utilitaires.JuryUtilitaire;
import exercice3.utilitaires.MaquetteUtilitaire;

/**
 *
 * @author fbm
 */
public class TestJury {
    
    public static void main(String[] args) {

        // DECOMMENTER POUR LANCER L'EXECUTION
/*
        // ATTENTION :
        // TRACE ATTENDUE DANS LE FICHIER TestJury-trace.txt

        ///////////////////////////////////////
        // Creation de la maquette pédagogique du semestre 2 (une version très simplifiée)
        // - contenant 2 modules : "M2103 (Programmation)" et "M2104 (Conception)"
        // - M2103 à 2 épreuves : controle continu coeff. 10 et une controle final coeff. 20
        // - M2104 à 3 épreuves : projet coeff. 12, controle continu coeff. 8 et une controle final coeff. 10
        //
        // PUIS affichage de cette maquette


        // Semestre
        Semestre semestre2 = new Semestre("semestre 2");

        // Modules + Epreuves
        // Programmation
        Module m2103 = new Module("M2103 (Programmation)", semestre2);
        Epreuve poo_qcm = new Epreuve(TypeEpreuve.ControleContinu, m2103, 10);
        Epreuve poo_machine = new Epreuve(TypeEpreuve.ControleFinal, m2103, 20);
        // Conception
        Module m2104 = new Module("M2104 (Conception)", semestre2);
        Epreuve coo_projet = new Epreuve(TypeEpreuve.Projet, m2104, 12);
        Epreuve coo_continu = new Epreuve(TypeEpreuve.ControleContinu, m2104, 8);
        Epreuve coo_final = new Epreuve(TypeEpreuve.ControleFinal, m2104, 10);


        ///////////////////////////////////////
        // ETAPE 1
        System.out.println("Etape 1 : création d'un étudiant et du jury associé");

        // Creer un étudiant fictif avec des notes (pour tester le "jury")
        // Francis BM :
        // - M2103 controle continu 17 et controle final 20
        // - M2104 projet 10, controle continu 14 et controle final 12)
        //
        // Creer un jury étudiant pour cette étudiant et le semestre 2
        // Afficher le résultat de ce jury avec la méthode afficherJuryEtudiant de la classe JuryUtilitaire

        // FBM
        Etudiant fbm = new Etudiant("Francis", "BM");
        Note note1 = new Note(poo_qcm, fbm, 17);
        Note note2 = new Note(poo_machine, fbm, 20);
        Note note3 = new Note(coo_projet, fbm, 10);
        Note note4 = new Note(coo_continu, fbm, 14);
        Note note5 = new Note(coo_final, fbm, 12);


        // Jury pour un étudiant
        JuryEtudiant juryFBM = new JuryEtudiant(semestre2, fbm);
        JuryUtilitaire.afficherJuryEtudiant(juryFBM);

        ///////////////////////////////////////
        // ETAPE 2 :
        System.out.println("\nEtape 2 : création d'un groupe d'étudiants et du jury associé");

        // Creer deux autres étudiants fictifs avec des notes
        // Hervé B :
        // - M2103 controle continu 20 et controle final 20
        // - M2104 projet 20, controle continu 20 et controle final 20)
        // Jerome G :
        // - M2103 controle continu 12 et controle final 13
        // - M2104 projet 20, controle continu 16 et controle final 17)


        // HB
        Etudiant hb = new Etudiant("Hervé", "B");
        note1 = new Note(poo_qcm, hb, 20);
        note2 = new Note(poo_machine, hb, 20);
        note3 = new Note(coo_projet, hb, 20);
        note4 = new Note(coo_continu, hb, 20);
        note5 = new Note(coo_final, hb, 20);
        // JG
        Etudiant jg = new Etudiant("Jérôme", "G");
        note1 = new Note(poo_qcm, jg, 12);
        note2 = new Note(poo_machine, jg, 13);
        note3 = new Note(coo_projet, jg, 20);
        note4 = new Note(coo_continu, jg, 16);
        note5 = new Note(coo_final, jg, 17);
        // Groupe
        Groupe groupeA = new Groupe("A");
        fbm.setGroupe(groupeA);
        hb.setGroupe(groupeA);
        jg.setGroupe(groupeA);

        // Creer une jury pour le groupe A et le semestre 2
        JuryGroupe juryGroupeA = new JuryGroupe(semestre2, groupeA);
        JuryUtilitaire.afficherJuryGroupe(juryGroupeA);

        */
        
    }
}

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CreationListePolars {
    public static ListeChaineeTriee<Polar> lesPolars() {
        String ligne;
        String auteur, titre;
        int annee;
        ListeChaineeTriee<Polar> resultat = new ListeChaineeTriee<>();
        try (BufferedReader br = new BufferedReader(new FileReader("Polars.txt"))) {
            while ((ligne = br.readLine()) != null) {
                titre = ligne;
                ligne = br.readLine();
                annee = Integer.parseInt(ligne);
                ligne = br.readLine();
                auteur = ligne;
                resultat.insereTrie(new Polar(annee, auteur, titre));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return resultat;
    }

    public static ListeChaineeTriee<Polar> chargementFichierTie() {
        String ligne;
        String auteur, titre;
        int annee;
        ListeChaineeTriee<Polar> resultat = new ListeChaineeTriee<>();
        try (BufferedReader br = new BufferedReader(new FileReader("/users/info/etu-1a/diiorioe/examen-r101/ControleMachine_R101_2023_2024/PolarsTries.txt"))) {
            while ((ligne = br.readLine()) != null) {
                titre = ligne;
                ligne = br.readLine();
                annee = Integer.parseInt(ligne);
                ligne = br.readLine();
                auteur = ligne;
                resultat.constructionTriee(new Polar(annee, auteur, titre));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return resultat;
    }

}

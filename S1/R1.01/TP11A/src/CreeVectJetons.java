import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CreeVectJetons {
    public static ArrayList<Jeton> lesJetons() {
        String ligne;
        char lettre;
        int valeur;
        ArrayList<Jeton> resultat = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("./fic_jetons_scrabble.txt"))) {
            while ((ligne = br.readLine()) != null) {
                lettre = ligne.charAt(0);
                ligne = br.readLine();
                valeur = Integer.parseInt(ligne);
                resultat.add(new Jeton(lettre, valeur));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return resultat;
    }
}

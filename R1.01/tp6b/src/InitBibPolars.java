import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class InitBibPolars{
    public static ArrayList<Polar> lesPolars() {
        String ligne;
        String auteur, titre;
        int annee;
        ArrayList<Polar> resultat = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("Polars.txt"))) {
            while ((ligne = br.readLine()) != null) {
                annee = Integer.parseInt(ligne);
                ligne = br.readLine();
                auteur = ligne;
                ligne = br.readLine();
                titre = ligne;
                resultat.add(new Polar(annee, auteur, titre));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return resultat;
    }
}

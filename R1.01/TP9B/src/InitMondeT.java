import java.io.BufferedReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

////////////////////////////////////////////////////////////////////////////////////////////
// -- À NE PAS MODIFIER !!! ////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////
public class InitMondeT {

    public static ArrayList<Pays> creerMondeT() {
        String ligne;
        String nom, continent;
        int superficie, population;
        ArrayList<Pays> resultat = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("./Monde2019Trie.txt"))) {
            while ((ligne = br.readLine()) != null) {
                nom = ligne;
                ligne = br.readLine();
                continent = ligne;
                ligne = br.readLine();
                population = Integer.parseInt(ligne);
                ligne = br.readLine();
                superficie = Integer.parseInt(ligne);
                resultat.add(new Pays(nom, continent, population, superficie));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return resultat;
    }
}
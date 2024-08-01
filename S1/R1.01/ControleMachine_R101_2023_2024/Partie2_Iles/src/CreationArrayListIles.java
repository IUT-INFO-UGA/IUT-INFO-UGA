import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class CreationArrayListIles {

    public static ArrayList<Ile> lesIles() {
        String ligne, nom;
        float superficie,latitude, longitude, elevation;
        ArrayList<String> pays;
        ArrayList<Ile> resultat = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("InfoIles.txt"))) {
            while ((ligne = br.readLine()) != null) {
                // skip separator
                ligne = br.readLine();
                nom = ligne;
                ligne = br.readLine();
                // ligne de pays
                pays = new ArrayList<>(Arrays.asList(ligne.split(" / ")));
                ligne = br.readLine();
                superficie = Float.parseFloat(ligne);
                ligne = br.readLine();
                latitude = Float.parseFloat(ligne);
                ligne = br.readLine();
                longitude = Float.parseFloat(ligne);
                ligne = br.readLine();
                elevation = Float.parseFloat(ligne);
                resultat.add(new Ile(nom, pays, superficie, latitude, longitude, elevation));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return resultat;
    }
}

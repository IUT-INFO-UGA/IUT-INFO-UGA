import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class CreationFicJetons {
    public static void main(String[] args) {
        ArrayList<Jeton> vJetons = new ArrayList<>();
        vJetons.add(new Jeton('J',8));
        vJetons.add(new Jeton('Q',8));
        vJetons.add(new Jeton('K',10));
        vJetons.add(new Jeton('W',10));
        vJetons.add(new Jeton('X',10));
        vJetons.add(new Jeton('Y',10));
        vJetons.add(new Jeton('Z',10));
        for (int i = 0; i < 2; i++) {
            vJetons.add(new Jeton(' ',0));
            vJetons.add(new Jeton('G',2));
            vJetons.add(new Jeton('B',3));
            vJetons.add(new Jeton('C',3));
            vJetons.add(new Jeton('P',3));
            vJetons.add(new Jeton('F',4));
            vJetons.add(new Jeton('H',4));
            vJetons.add(new Jeton('V',4));
        }
        for (int i = 0; i < 3; i++) {
            vJetons.add(new Jeton('D',3));
            vJetons.add(new Jeton('M',3));
        }
        for (int i = 0; i < 5; i++) {
            vJetons.add(new Jeton('L',1));
        }
        for (int i = 0; i < 6; i++) {
            vJetons.add(new Jeton('N',1));
            vJetons.add(new Jeton('O',1));
            vJetons.add(new Jeton('R',1));
            vJetons.add(new Jeton('S',1));
            vJetons.add(new Jeton('T',1));
            vJetons.add(new Jeton('U',1));
        }
        for (int i = 0; i < 8; i ++) {
            vJetons.add(new Jeton('I',1));
        }
        for (int i = 0; i < 9; i ++) {
            vJetons.add(new Jeton('A',1));
        }
        for (int i = 0; i < 15; i++) {
            vJetons.add(new Jeton('E',1));
        }
        try {
            FileWriter file = new FileWriter("fic_jetons_scrabble..txt");
            for (int i = 0; i < vJetons.size(); i++) {
                file.write(vJetons.get(i).getLettre()+"\n");
                file.write(vJetons.get(i).getValeur()+"\n");
            }
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

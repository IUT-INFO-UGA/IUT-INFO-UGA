package fr.iut2.androidtp;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import fr.iut2.androidtp.exercice3Data.Jeu;
import fr.iut2.androidtp.exercice3Data.Resultat;

public class Exercice3Activity extends AppCompatActivity {
    Resultat globalResult = new Resultat();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // On charge le XML pour créer l'arbre graphique
        setContentView(R.layout.activity_exercice3);
        ImageView ciseau = findViewById(R.id.ex3ciseau);
        ciseau.setOnClickListener(ex2select);
        ImageView pierre = findViewById(R.id.ex3Pierre);
        pierre.setOnClickListener(ex2select);
        ImageView feuille = findViewById(R.id.ex3feuille);
        feuille.setOnClickListener(ex2select);
    }

    @SuppressLint("SetTextI18n")
    private final View.OnClickListener ex2select = v -> {
        Jeu game = new Jeu();

        int id = v.getId();
        if (id == R.id.ex3ciseau) {
            game.setMainJoueur(1);
        } else if (id == R.id.ex3Pierre) {
            game.setMainJoueur(0);
        } else if (id == R.id.ex3feuille) {
            game.setMainJoueur(2);
        }

        int resultComputer = game.getMainOrdinateur();
        ImageView ciseau = findViewById(R.id.ex3ciseauOrdi);
        ImageView feuille = findViewById(R.id.ex3feuilleOrdi);
        ImageView pierre = findViewById(R.id.ex3PierreOrdi);
        switch (resultComputer){
            case 0:
                ciseau.setVisibility(View.GONE);
                feuille.setVisibility(View.GONE);
                pierre.setVisibility(View.VISIBLE);
                break;
            case 1:
                ciseau.setVisibility(View.VISIBLE);
                feuille.setVisibility(View.GONE);
                pierre.setVisibility(View.GONE);
                break;
            case 2:
                ciseau.setVisibility(View.GONE);
                feuille.setVisibility(View.VISIBLE);
                pierre.setVisibility(View.GONE);
                break;
        }

        TextView result = findViewById(R.id.ex3result);
        if(game.joueurGagne()){
            if(game.egalite()){
                result.setText("egalité !");
                globalResult.addEgalite();
            }else {
                result.setText("Victoire !");
                globalResult.addVictoire();
            }
        } else{
            result.setText("Defaite !");
            globalResult.addDefaite();
        }
        TextView globalResultText = findViewById(R.id.ex3GlobalResult);
        globalResultText.setText("nombre de victroire: "+ globalResult.getNombreVictoire() +"\nnombre de défaite: "+ globalResult.getNombreDefaite()+"\nnombre d'egalité: "+globalResult.getNombreEgalite());
    };

}

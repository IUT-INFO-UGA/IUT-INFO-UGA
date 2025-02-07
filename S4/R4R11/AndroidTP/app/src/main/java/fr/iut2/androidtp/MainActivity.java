package fr.iut2.androidtp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    // ID REQUETES
    public final static int EXERCICE_4_ACTIVITY_REQUEST = 3;
    public final static int EXERCICE_5_ACTIVITY_REQUEST = 4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onExercice1(View view) {

        // Création d'une intention
        Intent Exercice1ViewActivityIntent = new Intent(MainActivity.this, Exercice1Activity.class);

        // Lancement de la demande de changement d'activité
        startActivity(Exercice1ViewActivityIntent);
    }

    public void onExercice2(View view) {

        // Création d'une intention
        Intent Exercice2EventActivityIntent = new Intent(MainActivity.this, Exercice2Activity.class);

        // Lancement de la demande de changement d'activité
        startActivity(Exercice2EventActivityIntent);
    }

    public void onExercice3(View view) {

        // Création d'une intention
        Intent Exercice3EventActivityIntent = new Intent(MainActivity.this, Exercice3Activity.class);

        // Lancement de la demande de changement d'activité
        startActivity(Exercice3EventActivityIntent);
    }

    public void onExercice4(View view) {

        // Création d'une intention
        Intent intent = new Intent(this, Exercice4Activity.class);

        // Lancement de la demande de changement d'activité avec attente de résultat par la méthode onActivityResult
        startActivityForResult(intent, EXERCICE_4_ACTIVITY_REQUEST);
    }

    public void onExercice5(View view) {

        // Création d'une intention
        Intent intent = new Intent(this, Exercice5Activity.class);

        // Lancement de la demande de changement d'activité avec attente de résultat par la méthode onActivityResult
        startActivityForResult(intent, EXERCICE_5_ACTIVITY_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Vérification du retour à l'aide du code requête
        if (requestCode == EXERCICE_4_ACTIVITY_REQUEST) {

            // Afficher une notification
            String notification = "Retour exercice 4";
            Toast.makeText(this, notification, Toast.LENGTH_SHORT).show();

        } else if (requestCode == EXERCICE_5_ACTIVITY_REQUEST) {

            // Afficher une notification
            String notification = "Retour exercice 5";
            Toast.makeText(this, notification, Toast.LENGTH_SHORT).show();

        }
    }
}

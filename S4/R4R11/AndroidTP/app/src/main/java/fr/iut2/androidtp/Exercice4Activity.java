package fr.iut2.androidtp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class Exercice4Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // On charge le XML pour créer l'arbre graphique
        setContentView(R.layout.activity_exercice4);

        Button button = findViewById(R.id.exercice4Valider);
        button.setOnClickListener(exercice4_Valider);
    }

    private final View.OnClickListener exercice4_Valider = v -> {
        EditText input = findViewById(R.id.exercice4_input);
        String prenom = input.getText().toString();
        Intent intent = new Intent(Exercice4Activity.this, HelloActivity.class);
        intent.putExtra(HelloActivity.PRENOM_KEY, prenom);

        startActivity(intent);
    };
}

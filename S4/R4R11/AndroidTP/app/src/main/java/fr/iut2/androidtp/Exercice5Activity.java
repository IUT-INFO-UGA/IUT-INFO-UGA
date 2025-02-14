package fr.iut2.androidtp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class Exercice5Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // On charge le XML pour créer l'arbre graphique
        setContentView(R.layout.activity_exercice5);

        Button button = findViewById(R.id.ex5_validating);
        button.setOnClickListener(exercice5_Valider);
    }

    private final View.OnClickListener exercice5_Valider = v -> {
        EditText input = findViewById(R.id.exo5_input);
        int table = Integer.parseInt(input.getText().toString());
        Intent intent = new Intent(Exercice5Activity.this, TableMultiplicationActivity.class);
        intent.putExtra("TABLE", table);

        startActivity(intent);
    };
}

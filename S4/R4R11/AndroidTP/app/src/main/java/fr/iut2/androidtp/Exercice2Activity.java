package fr.iut2.androidtp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Exercice2Activity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // On charge le XML pour créer l'arbre graphique
        setContentView(R.layout.activity_exercice2);

        Button button = findViewById(R.id.exercice2_button);
        button.setOnClickListener(exercice2Valider);
    }

    private final View.OnClickListener exercice2Valider = v -> {
        RadioButton radioButton = findViewById(R.id.radioButton);
        TextView textView = findViewById(R.id.exercice2_text);

        if (radioButton.isChecked()) {
            textView.setText("Bonne réponse !");
        } else {
            textView.setText("Mauvaise réponse");
        }

    };
}

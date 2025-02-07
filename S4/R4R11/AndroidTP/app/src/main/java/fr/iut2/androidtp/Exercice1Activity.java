package fr.iut2.androidtp;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Exercice1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // On charge le XML pour créer l'arbre graphique
        setContentView(R.layout.activity_exercice1);

        Button button = findViewById(R.id.exercice1_button);
        button.setOnClickListener(exercice1Valider);
    }

    private final View.OnClickListener exercice1Valider = v -> {
        TextView helloView = findViewById(R.id.exercice1_hello);

        EditText prenomView = findViewById(R.id.exercice1_input);

        if (!TextUtils.isEmpty(prenomView.getText())) {
            helloView.setText("Hello " + prenomView.getText() + " !");
        }
    };
}

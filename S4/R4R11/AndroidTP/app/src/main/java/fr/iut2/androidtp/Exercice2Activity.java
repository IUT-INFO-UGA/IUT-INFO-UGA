package fr.iut2.androidtp;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Exercice2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // On charge le XML pour créer l'arbre graphique
        setContentView(R.layout.activity_exercice2);

        Button button = findViewById(R.id.ex2validateBtn);
        button.setOnClickListener(ex2validateBtn);
    }

    private final View.OnClickListener ex2validateBtn = v -> {
        TextView helloView = findViewById(R.id.ex2Text);

        RadioButton radioButton = findViewById(R.id.ex2goodAnwser);

        if (radioButton.isChecked()) {
            helloView.setText("bonne reponse !");
        }else{
            helloView.setText("ha ha non");
        }
    };
}

package fr.iut2.androidtp;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class TableMultiplicationActivity extends AppCompatActivity {

    public static final int TABLE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_table_multiplication);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        int table = Integer.parseInt(getIntent().getStringExtra(String.valueOf(TABLE)));

        TextView text1 = findViewById(R.id.exercice5_text1);
        TextView text2 = findViewById(R.id.exercice5_text2);
        TextView text3 = findViewById(R.id.exercice5_text3);

    }
}
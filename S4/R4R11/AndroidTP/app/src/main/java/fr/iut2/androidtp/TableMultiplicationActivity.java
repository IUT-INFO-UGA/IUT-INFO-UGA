package fr.iut2.androidtp;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Objects;

public class TableMultiplicationActivity extends AppCompatActivity {

    public static int TABLE = 1;

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

        TABLE = getIntent().getIntExtra("TABLE", 0);

        TextView text1 = findViewById(R.id.ex5_string_text1);
        text1.setText(TABLE+"*1");
        TextView text2 = findViewById(R.id.ex5_string_text2);
        text2.setText(TABLE+"*2");
        TextView text3 = findViewById(R.id.ex5_string_text3);
        text3.setText(TABLE+"*3");


    }
}
package org.tensorflow.lite.examples.classification;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main3Activity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        DatabaseHelper db;
        Button button = findViewById(R.id.AIButton);
        Button login = findViewById(R.id.button2);


        button.setOnClickListener(v -> {
            Intent intent=new Intent(this, ClassifierActivity.class);
            startActivity(intent);
        });

        login.setOnClickListener(v -> {
            Intent intent=new Intent(this, CountActivity.class);
            startActivity(intent);
        });

    }



}

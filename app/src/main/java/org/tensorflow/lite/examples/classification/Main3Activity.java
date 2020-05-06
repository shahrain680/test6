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


        button.setOnClickListener(v -> {
            Intent intent=new Intent(this, ClassifierActivity.class);
            startActivity(intent);
        });

        db = new DatabaseHelper(this);
        db.addUsers("test","test");
    }



}

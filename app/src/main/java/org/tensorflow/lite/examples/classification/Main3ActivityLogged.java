package org.tensorflow.lite.examples.classification;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Main3ActivityLogged extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3_logged);
        DatabaseHelper db;
        Button button = findViewById(R.id.AIButton);
        Button logout = findViewById(R.id.logout);


        button.setOnClickListener(v -> {
            Intent intent=new Intent(this, ClassifierActivity.class);
            startActivity(intent);
        });

        logout.setOnClickListener(v -> {
            ActLActivity.logout();
            Intent intent=new Intent(this, Main3Activity.class);
            startActivity(intent);
        });

    }

    @Override
    public void onBackPressed() {
        this.moveTaskToBack(true);
    }


}

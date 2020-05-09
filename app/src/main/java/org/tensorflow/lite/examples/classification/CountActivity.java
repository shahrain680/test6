package org.tensorflow.lite.examples.classification;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CountActivity extends AppCompatActivity {
    DatabaseHelper db;
    Button b1,b2;
    EditText t1,t2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_count);

        db = new DatabaseHelper(this);
        b1 = findViewById(R.id.actlbutton);
        b2 = findViewById(R.id.actrbutton);
        t1 = findViewById(R.id.username);
        t2 = findViewById(R.id.password);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = t1.getText().toString();
                String pass = t2.getText().toString();


                if (db.verifyUser(user, pass)) {

                    Intent intent = new Intent(CountActivity.this, Main3Activity.class);
                    startActivity(intent);
                    Toast.makeText(CountActivity.this, "Login Successful!", Toast.LENGTH_SHORT).show();


                } else {
                    Toast.makeText(CountActivity.this, "Invalid Username or Password!", Toast.LENGTH_SHORT).show();
                }
            }
        });


        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CountActivity.this, ActRActivity.class);
                startActivity(intent);
            }
        });
    }
}

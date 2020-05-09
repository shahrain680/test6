package org.tensorflow.lite.examples.classification;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ActRActivity extends AppCompatActivity {
    DatabaseHelper db;
    EditText t1,t2,t3;
    Button b5;
    String u1,u2;
    boolean status;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_r);
        db = new DatabaseHelper(this);
        t1 = findViewById(R.id.usernamer);
        t2 = findViewById(R.id.passwordr);
        t3 = findViewById(R.id.cfmpasswordr);
        b5 = findViewById(R.id.actrbuttonr);

        status = false;
        u1 = t1.getText().toString();
        u1 = t1.getText().toString();

        if (t1.length() > 1) {
            status = true;
        }

        if (t2.equals(t3)) {
            status = true;
        }

        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (status == true) {
                    t1.setText(u1);
                    t1.setText(u2);
                    Toast.makeText(ActRActivity.this, "Register Successful!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(ActRActivity.this, "Invalid Username or Password!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}

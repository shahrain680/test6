package org.tensorflow.lite.examples.classification;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    EditText e1,e2;
    Button b1,b2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_screen);

        e1=(EditText)findViewById(R.id.username);
        e2=(EditText)findViewById(R.id.password);
        b1=(Button)findViewById(R.id.loginbutton);
        b2=(Button)findViewById(R.id.regisbutton);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = e1.getText().toString();
                String pass = e2.getText().toString();
            }
        });
    }
}

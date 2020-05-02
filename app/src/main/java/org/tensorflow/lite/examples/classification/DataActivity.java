package org.tensorflow.lite.examples.classification;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;


public class DataActivity extends AppCompatActivity {
    private Button button;
    protected TextView materialTextView,
            confidenceTextView;
    public String material;
    public float confidence;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.data_review);

        button = findViewById(R.id.addData);
        materialTextView = findViewById(R.id.materialvalue);
        confidenceTextView = findViewById(R.id.confidencevalue);
        Intent intent= getIntent();
        material = intent.getStringExtra("result_name");
        confidence = intent.getFloatExtra("result_percent",2);
        materialTextView.setText(material);
        confidenceTextView.setText(String.format("%.2f", (100 * confidence)) + "%");
    }

}

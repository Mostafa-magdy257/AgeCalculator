package com.example.agecalculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    EditText edtBirthYear;
    TextView txtAgeCalculated;
    Button btnCalculate;
    int numCalculatedAge;
    public static final String age ="AGE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtBirthYear = (EditText) findViewById(R.id.edtTxtBitheYear);
        txtAgeCalculated = (TextView) findViewById(R.id.txtCalculatedAge);
        if (savedInstanceState != null){
            numCalculatedAge = savedInstanceState.getInt(age);
            txtAgeCalculated.setText(""+numCalculatedAge);
        }
        btnCalculate = (Button) findViewById(R.id.btnCalculate);
        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numCalculatedAge = Calendar.getInstance().get(Calendar.YEAR) - Integer.parseInt(edtBirthYear.getText().toString());
                txtAgeCalculated.setText("" + numCalculatedAge);
            }
        });
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState, @NonNull PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        outState.putInt(age,numCalculatedAge);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        numCalculatedAge = savedInstanceState.getInt(age);
    }
}
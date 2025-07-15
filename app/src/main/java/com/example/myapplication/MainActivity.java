package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import java.text.DecimalFormat;


public class MainActivity extends AppCompatActivity {

    Button button;
    RadioButton radio1;
    RadioButton radio2;
    RadioGroup radioGroup;
    TextView tV1;
    TextView tV2;
    TextView tV3;
    TextView tV4;
    EditText eT1;
    EditText eT2;




    @Override
    protected void onCreate(Bundle savedInstanceState) { 
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        button = findViewById(R.id.button);
        radio1 = findViewById(R.id.radio1);
        radio2 = findViewById(R.id.radio2);
        tV1 = findViewById(R.id.tV1);
        tV2 = findViewById(R.id.tV2);
        tV3 = findViewById(R.id.tV3);
        tV4 = findViewById(R.id.tV4);
        radioGroup = findViewById(R.id.radioGroup);
        eT1 = findViewById(R.id.eT1);
        eT2 = findViewById(R.id.eT2);
        //
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DecimalFormat df = new DecimalFormat("0.0");
                if(radioGroup.getCheckedRadioButtonId()== R.id.radio1){
                    float temp = Integer.parseInt(eT1.getText().toString());
                    eT2.setText(df.format((temp * 9 / 5.0) + 32));
                }else {
                    float temp = Integer.parseInt(eT1.getText().toString());
                    eT2.setText(df.format((temp - 32) * 5 / 9.0));
                }
            }
        });
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId == R.id.radio1){
                    tV1.setText("攝氏");
                    tV2.setText("C");
                    tV3.setText("華氏");
                    tV4.setText("F");
                }else{
                    tV1.setText("華氏");
                    tV2.setText("F");
                    tV3.setText("攝氏");
                    tV4.setText("C");
                }
            }
        });
    }
}
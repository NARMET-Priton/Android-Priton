package it.volta.ts.smirnovartur.mainapplication.verifica1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import it.volta.ts.smirnovartur.mainapplication.R;

public class ActivityVerifica1 extends AppCompatActivity implements View.OnFocusChangeListener {

    Button exitButton;
    EditText inputEditText1, inputEditText2;
    TextView middleTextView;

    int num_1, num_2 , result = 0;
    String strNum_1, strNum_2, strOutput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verifica1);

        exitButton     = findViewById(R.id.ExitButton);
        middleTextView = findViewById(R.id.MiddleTextView);
        inputEditText1 = findViewById(R.id.InputEditText1);
        inputEditText2 = findViewById(R.id.InputEditText2);

        strOutput = (String) middleTextView.getText();

        inputEditText1.setOnFocusChangeListener(this);
        inputEditText2.setOnFocusChangeListener(this);
        exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { finish(); }
        });
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onFocusChange(View view, boolean hasFocus) {
        if (!hasFocus) {
            String strOutput = (String) middleTextView.getText();
            switch (view.getId()) {
                case R.id.InputEditText1:
                    num_1 = Integer.parseInt(inputEditText1.getText().toString());


                    strOutput = strOutput.replace(" null?? ", String.valueOf(sqrt()));
                    middleTextView.setText(strOutput);

                    strOutput = strOutput.replace(" null??? ", String.valueOf(log()));
                    middleTextView.setText(strOutput);
                    break;

                case R.id.InputEditText2:
                    num_2 = Integer.parseInt(inputEditText2.getText().toString());

                    strOutput = strOutput.replace(" null? ",  String.valueOf(div()));
                    middleTextView.setText(strOutput);
                    break;
            }
        }
    }

    // непривильно
    protected int div (){
        return num_2 == 0? 0 : num_1/num_2;
    }

    protected double sqrt (){
        double a = Math.pow(num_1, 1.0 / 3.0);
        return Math.round(a * 10000.0) / 10000.0;
    }

    protected double log (){
        return Math.round(Math.log(num_1) / Math.log(10) * 100000.0) / 100000.0 ;
    }
}
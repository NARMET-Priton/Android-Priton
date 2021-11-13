package it.volta.ts.smirnovartur.mainapplication.verifica1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import it.volta.ts.smirnovartur.mainapplication.R;

public class ActivityVerifica1 extends AppCompatActivity {

    EditText inputEditText1, inputEditText2;
    TextView middleTextView;
    Button exitButton, countButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verifica1);

        inputEditText1 = findViewById(R.id.InputEditText1);
        inputEditText2 = findViewById(R.id.InputEditText2);
        middleTextView = findViewById(R.id.MiddleTextView);
        countButton    = findViewById(R.id.CountButton);
        exitButton     = findViewById(R.id.ExitButton);

        countButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                middleTextView.setText(R.string.textMiddle);
                if (checkNums()){
                    Counts counts = new Counts(Integer.parseInt(inputEditText1.getText().toString()), Integer.parseInt(inputEditText2.getText().toString()));

                    middleTextView.setText(middleTextView.getText().toString().replace(" null? ", String.valueOf(counts.div())));
                    middleTextView.setText(middleTextView.getText().toString().replace(" null?? ", String.valueOf(counts.sqrt())));
                    middleTextView.setText(middleTextView.getText().toString().replace(" null??? ", String.valueOf(counts.log())));
                }
            }
        });

        exitButton.setOnClickListener(view -> {
            finish();
        });
    }

    protected boolean checkNums(){
        if(inputEditText1.getText().toString().isEmpty() || inputEditText2.getText().toString().isEmpty()){
            Toast.makeText(ActivityVerifica1.this,"Error: no input of numbers!",Toast.LENGTH_LONG).show();
            return false;
        }else if (Integer.parseInt(inputEditText1.getText().toString()) == 0 || Integer.parseInt(inputEditText2.getText().toString()) == 0){
            Toast.makeText(ActivityVerifica1.this,"Error: result with input 0 doesn't exist!",Toast.LENGTH_LONG).show();
            return false;
        }else if (Integer.parseInt(inputEditText1.getText().toString()) < 0){
            Toast.makeText(ActivityVerifica1.this,"Error: result with NEGATIVE input doesn't exist!",Toast.LENGTH_LONG).show();
            return false;
        }else{
            return true;
        }
    }
}

class Counts{

    private final int num_1;
    private final int num_2;

    Counts (int num_1, int num_2){
        this.num_1 = num_1;
        this.num_2 = num_2;
    }
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
package it.volta.ts.smirnovartur.mainapplication.verifica1;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

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

        countButton.setOnClickListener(view -> {
            middleTextView.setText(R.string.textMiddle);
            if (checkNums()){
                int num_1 = Integer.parseInt(inputEditText1.getText().toString()),
                    num_2 = Integer.parseInt(inputEditText2.getText().toString());

                middleTextView.setText(middleTextView.getText().toString().replace(" null? ", String.valueOf(Counts.div(num_1, num_2))));
                middleTextView.setText(middleTextView.getText().toString().replace(" null?? ", String.valueOf(Counts.sqrt3(num_1, 4))));
                middleTextView.setText(middleTextView.getText().toString().replace(" null??? ", String.valueOf(Counts.log10(num_1, 5))));
            }
        });

        exitButton.setOnClickListener(view -> finish());
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


class Counts {

        public static int div (double numero, double divisore)
        {
            int result = 0;

            if (divisore > 0)
            {
                if (numero == 0)
                    result = 1;
                else if (numero % divisore == 0)
                    result = result + 1 + div(numero / divisore, divisore);
            }
            return result;
        }

        public static double sqrt2(double numero, int numDecimali)
        {
            boolean esci     = false;
            double  result   = 0d;
            double  decimale = 1d;

            for (int idx=0; idx < numDecimali; idx++)
                decimale /= 10d;

            while (!esci)
            {
                double quadrato = result * result;

                if (quadrato == numero)
                    esci = true;
                else if (quadrato < numero)
                    result += decimale;
                else {
                    result -= decimale;
                    esci = true;
                }
            }

            return result;
        }

        public static double sqrt3(double numero, int numDecimali)
        {
            boolean esci     = false;
            double   result   = 0d;
            double   decimale = 1d;

            for (int idx=0; idx < numDecimali; idx++)
                decimale /= 10d;

            while (!esci)
            {
                double cubo = result * result * result;

                if (cubo == numero)
                    esci = true;
                else if (cubo < numero)
                    result += decimale;
                else {
                    result -= decimale;
                    esci = true;
                }
            }

            return result;
        }


        public static double log10(double numero, int numDecimali)
        {
            boolean esci     = false;
            double  result   = 0d;
            double  decimale = 1d;

            for (int idx=0; idx < numDecimali; idx++)
                decimale /= 10d;

            while (!esci)
            {
                double quadrato = Math.pow(10d, decimale);

                if (quadrato == numero)
                    esci = true;
                else if (quadrato < numero)
                    result += decimale;
                else {
                    result -= decimale;
                    esci = true;
                }
            }

            return result;
        }

    }
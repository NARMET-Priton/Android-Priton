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

        String strNum_1, strNum_2;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_verifica1);

            exitButton     = findViewById(R.id.ExitButton);
            middleTextView = findViewById(R.id.MiddleTextView);
            inputEditText1 = findViewById(R.id.InputEditText1);
            inputEditText2 = findViewById(R.id.InputEditText2);

            inputEditText1.setOnFocusChangeListener(this);
            inputEditText2.setOnFocusChangeListener(this);
        }

        @SuppressLint("NonConstantResourceId")
        @Override
        public void onFocusChange(View view, boolean hasFocus) {
            if (!hasFocus) {
                String strOutput = (String) middleTextView.getText();
                switch (view.getId()) {
                    case R.id.InputEditText1:
                        strNum_1 = inputEditText1.getText().toString().replaceAll("[^\\\\d.]","");


                        break;

                    case R.id.InputEditText2:
                        strNum_2 = inputEditText2.getText().toString().replaceAll("[^\\\\d.]","");

                        strOutput = strOutput.replace(" null? ", "23");
                        middleTextView.setText(strOutput);

                        strOutput = strOutput.replace(" null?? ", "43");
                        middleTextView.setText(strOutput);

                        strOutput = strOutput.replace(" null??? ", "63");
                        middleTextView.setText(strOutput);

                        break;
                }
            }
        }
    }
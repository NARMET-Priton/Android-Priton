package it.volta.ts.smirnovartur.mainapplication.verifica1;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.biometrics.BiometricManager;
import android.os.Bundle;
import android.text.Editable;
import android.util.Xml;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.xmlpull.v1.XmlPullParser;

import it.volta.ts.smirnovartur.mainapplication.R;

public class ActivityVerifica1 extends AppCompatActivity {

    Button exitButton;
    EditText inputEditText1, inputEditText2;
    TextView middleTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verifica1);

        exitButton = (Button) findViewById(R.id.ExitButton);


    }

    protected int[] checkNumbers(){
        inputEditText1 = findViewById(R.id.InputEditText1);
        inputEditText2 = findViewById(R.id.InputEditText2);
        middleTextView = findViewById(R.id.MiddleTextView);

        String str1 = inputEditText1.getText().toString().replaceAll("\\s",""),
               str2 = inputEditText2.getText().toString().replaceAll("\\s","");

        // добавить проверок

        return new int[]{Integer.parseInt(str1), Integer.parseInt(str2)};
    }

    protected int divideFirstSecond(int num1, int num2){
        return num1%num2;
    }


}
package it.volta.ts.smirnovartur.recursionApp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import it.volta.ts.smirnovartur.recursionApp.recurs.Recurs;

public class MainActivity extends AppCompatActivity {

    Button buttonRecurs, buttonExit;
    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = findViewById(R.id.centerText);

        buttonExit = findViewById(R.id.bottomButtExit);
        buttonExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        buttonRecurs = findViewById(R.id.recursButt);
        buttonRecurs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // инверсия строки при помощи рекурсии
                String str = new Recurs().initRecurs((String) text.getText());
                text.setText(str);
            }
        });
    }
}
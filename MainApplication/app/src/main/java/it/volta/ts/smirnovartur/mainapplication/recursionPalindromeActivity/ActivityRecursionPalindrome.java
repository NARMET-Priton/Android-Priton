package it.volta.ts.smirnovartur.mainapplication.recursionPalindromeActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import it.volta.ts.smirnovartur.mainapplication.R;
import it.volta.ts.smirnovartur.mainapplication.recursionPalindromeActivity.recursion.*;

public class ActivityRecursionPalindrome extends AppCompatActivity {

    Button buttonRecurs, buttonExit;
    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recursion_palindrome);

        text = findViewById(R.id.centerText);

        buttonExit = findViewById(R.id.bottomButtExit);
        buttonExit.setOnClickListener(view -> finish());

        buttonRecurs = findViewById(R.id.recursButt);
        buttonRecurs.setOnClickListener(view -> {
            String str = new Recursion().recursionPalindrome((String) text.getText());
            text.setText(str);
        });
    }
}
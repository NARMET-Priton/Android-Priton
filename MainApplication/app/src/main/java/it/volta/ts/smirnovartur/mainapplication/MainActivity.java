package it.volta.ts.smirnovartur.mainapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import it.volta.ts.smirnovartur.mainapplication.recursionPalindromeActivity.ActivityRecursionPalindrome;
import it.volta.ts.smirnovartur.mainapplication.verifica1.ActivityVerifica1;
import it.volta.ts.smirnovartur.mainapplication.weatherActivity.*;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnRecursionPalindrome;
    Button btnWeather;
    Button btnVerifica1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        btnRecursionPalindrome = (Button) findViewById(R.id.btnRecursionPalindrome);
        btnRecursionPalindrome.setOnClickListener(this);

        btnWeather = (Button) findViewById(R.id.btnWeather);
        btnWeather.setOnClickListener(this);

        btnVerifica1 = (Button) findViewById(R.id.btnVerifica1);
        btnVerifica1.setOnClickListener(this);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(@NonNull View view) {
        Intent intent;
        switch (view.getId()){
            case R.id.btnRecursionPalindrome:
                intent = new Intent(this, ActivityRecursionPalindrome.class);
                startActivity(intent);
                break;
            case R.id.btnWeather:
                intent = new Intent(this, ActivityWeather.class);
                startActivity(intent);
                break;
            case R.id.btnVerifica1:
                intent = new Intent(this, ActivityVerifica1.class);
                startActivity(intent);
                break;
            default:
                break;

        }

    }
}
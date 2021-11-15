package it.volta.ts.smirnovartur.mainapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import it.volta.ts.smirnovartur.mainapplication.recursionPalindromeActivity.*;
import it.volta.ts.smirnovartur.mainapplication.verifica1.*;
import it.volta.ts.smirnovartur.mainapplication.weatherActivity.*;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btnRecursionPalindrome).setOnClickListener(this);
        findViewById(R.id.btnWeather).setOnClickListener(this);
        findViewById(R.id.btnVerifica1).setOnClickListener(this);
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
package it.volta.ts.smirnovartur.mainapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import it.volta.ts.smirnovartur.mainapplication.recursionPalindromeActivity.ActivityRecursionPalindrome;
import it.volta.ts.smirnovartur.mainapplication.weatherActivity.ActivityWeather;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnRecursionPalindrome;
    Button btnWeather;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnRecursionPalindrome = (Button) findViewById(R.id.btnRecursionPalindrome);
        btnRecursionPalindrome.setOnClickListener(this);

        btnWeather = (Button) findViewById(R.id.btnWeather);
        btnWeather.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnRecursionPalindrome:
                Intent intent1 = new Intent(this, ActivityRecursionPalindrome.class);
                startActivity(intent1);
                break;
            case R.id.btnWeather:
                Intent intent2 = new Intent(this, ActivityWeather.class);
                startActivity(intent2);
                break;
            default:
                break;

        }

    }
}
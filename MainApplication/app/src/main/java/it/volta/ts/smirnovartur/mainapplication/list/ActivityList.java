package it.volta.ts.smirnovartur.mainapplication.list;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import it.volta.ts.smirnovartur.mainapplication.R;
import it.volta.ts.smirnovartur.mainapplication.list.db.Person;
import it.volta.ts.smirnovartur.mainapplication.list.db.PersonDB;
import it.volta.ts.smirnovartur.mainapplication.recursionPalindromeActivity.ActivityRecursionPalindrome;
import it.volta.ts.smirnovartur.mainapplication.verifica1.ActivityVerifica1;
import it.volta.ts.smirnovartur.mainapplication.weatherActivity.ActivityWeather;

public class ActivityList extends AppCompatActivity {

    EditText inputTextName, inputTextLastname;
    Button   buttonAddInDB;
    TextView viewDBout;

    Person person;
    PersonDB personDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        inputTextName     = findViewById(R.id.inputTextName);
        inputTextLastname = findViewById(R.id.inputTextLastname);
        buttonAddInDB     = findViewById(R.id.buttonAddInDB);
        viewDBout         = findViewById(R.id.viewDBout);

        personDB = new PersonDB();

        buttonAddInDB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                person = new Person();
                person.setPersonData(inputTextName.getText().toString(), inputTextLastname.getText().toString());

                personDB.addNewPerson(person);
                personDB.sortPersonDB();

                viewDBout.setText(personDB.getDB());
            }
        });
    }
}
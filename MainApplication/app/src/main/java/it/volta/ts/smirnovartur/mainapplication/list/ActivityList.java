package it.volta.ts.smirnovartur.mainapplication.list;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import it.volta.ts.smirnovartur.mainapplication.R;
import it.volta.ts.smirnovartur.mainapplication.list.db.Person;
import it.volta.ts.smirnovartur.mainapplication.list.db.PersonList;

public class ActivityList extends AppCompatActivity {

    EditText inputTextName, inputTextLastname;
    Button   buttonAddInDB;
    TextView viewDBout;

    Person     person;
    PersonList personList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        inputTextName     = findViewById(R.id.inputTextName);
        inputTextLastname = findViewById(R.id.inputTextLastname);
        buttonAddInDB     = findViewById(R.id.buttonAddInDB);
        viewDBout         = findViewById(R.id.viewDBout);

        personList = new PersonList();

        buttonAddInDB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                person = new Person();
                person.setPersonData(inputTextName.getText().toString(), inputTextLastname.getText().toString());

                personList.addNewPerson(person);
//                personList.alphSortPearsonList();
                viewDBout.setText(personList.getPersonList());
            }
        });
    }
}
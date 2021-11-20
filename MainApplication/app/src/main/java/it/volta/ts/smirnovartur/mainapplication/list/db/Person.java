package it.volta.ts.smirnovartur.mainapplication.list.db;

import androidx.annotation.NonNull;

public class Person {
    // Struct
    private String name, lastname;
    private Person nextPerson;
    private int id = 0;

    // Person Data I/O
    public void setPersonData(String name, String lastname) {
        this.name = name;
        this.lastname = lastname;
        this.nextPerson = null;
        id++;
    }


    @NonNull
    @Override
    public String toString() {
        return "\n [" + id + "] " + lastname + " " + name;
    }

    // Lastname I/O
    public String getPersonLastname() {
        return lastname;
    }

    // Name I/O
    public String getPersonName() {
        return name;
    }

    // Next Person I/O
    public void setNextPerson(Person person) {
        this.nextPerson = person;
    }

    public Person getNextPerson() {
        return nextPerson;
    }
}

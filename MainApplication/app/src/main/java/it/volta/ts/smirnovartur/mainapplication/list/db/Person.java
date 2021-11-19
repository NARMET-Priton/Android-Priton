package it.volta.ts.smirnovartur.mainapplication.list.db;

import java.util.HashMap;

public class Person {

    // Struct DB
    private String name, lastname;

    // I/O Person Data
    public void setPersonData(String name, String lastname) {
        this.name     = name;
        this.lastname = lastname;
    }

    public String getPersonData(){
        return "\nName: " + name + " LastName: " + lastname;
    }

    public String getPersonLastname() {
        return lastname;
    }
}

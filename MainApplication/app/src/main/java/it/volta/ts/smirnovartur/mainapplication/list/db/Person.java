package it.volta.ts.smirnovartur.mainapplication.list.db;

public class Person {
    // Struct
    private String name, lastname;
    private Person nextPerson;

    // Person Data I/O
    public void setPersonData(String name, String lastname) {
        this.name       = name;
        this.lastname   = lastname;
        this.nextPerson = null;
    }

    public String getPersonData(){
        return "\nName: " + name + " LastName: " + lastname;
    }

    // Lastname, name Person O

    public String getPersonLastname() {
        return lastname;
    }

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

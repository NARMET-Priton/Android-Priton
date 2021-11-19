package it.volta.ts.smirnovartur.mainapplication.list.db;

public class PersonList {

    // 1) Связать персон между собой   X
    // 1.1) Вывести на экран           X

    // 2) Отсортировать персон по фамилии
    // 2.1) Вывести на экран

    // 3) Отсортировать персон первостепенно по фамилии и второстепенно по имени
    // 3.1) Вывести на экран

    Person firstPerson, tempPerson;

    public PersonList() {
        firstPerson = new Person();  // HEAD (link)
        tempPerson = new Person();
    }


    public void addNewPerson(Person person) {
        if (firstPerson.getNextPerson() == null) {
            firstPerson.setNextPerson(person);
            tempPerson = person;
        } else {
            tempPerson.setNextPerson(person);
            tempPerson = person;
        }
    }

    public String getPersonList() {
        Person temp = firstPerson;
        StringBuilder str = new StringBuilder();

        while (temp.getNextPerson() != null) {
            temp = temp.getNextPerson();
            if (temp.getPersonData() != null) {
                str.append(temp.getPersonData());
            }
        }
        return str.toString();
    }
}

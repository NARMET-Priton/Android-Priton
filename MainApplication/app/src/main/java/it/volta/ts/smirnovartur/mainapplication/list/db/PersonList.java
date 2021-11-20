package it.volta.ts.smirnovartur.mainapplication.list.db;

import java.util.Locale;

public class PersonList {

    Person firstPerson, tempPerson;

    // добавить вторичную проверку по имени

    public PersonList() {
        firstPerson = new Person();  // HEAD (link)
        tempPerson = new Person();
    }

    public void addNewPerson(Person person) {
        if (firstPerson.getNextPerson() == null) {
            firstPerson.setNextPerson(person);
            tempPerson = person;
        } else {
            newSortedPerson(person);
        }
    }

    public void newSortedPerson(Person person) {
        Person temp = firstPerson.getNextPerson();
        Person hash = firstPerson;
        int action = 0;

        if (temp.getNextPerson() == null) {
            for (int i = 0; (i < temp.getPersonLastname().length()) && (i < person.getPersonLastname().length()); i++) {
                if (person.getPersonLastname().toLowerCase(Locale.ROOT).compareTo(temp.getPersonLastname().toLowerCase(Locale.ROOT)) == 0) {
                    action = 0;
                    continue;
                }
                if (person.getPersonLastname().toLowerCase(Locale.ROOT).compareTo(temp.getPersonLastname().toLowerCase(Locale.ROOT)) > 0) {
                    action = 1;
                    break;
                }
                if (person.getPersonLastname().toLowerCase(Locale.ROOT).compareTo(temp.getPersonLastname().toLowerCase(Locale.ROOT)) < 0) {
                    action = -1;
                    break;
                }
            }
            switch (action) {
                case 1:
                case 0:
                    temp.setNextPerson(person);
                    break;
                case -1:
                    firstPerson.setNextPerson(person);
                    person.setNextPerson(temp);
                    temp.setNextPerson(null);
                    break;
            }
        } else {
            do {
                for (int i = 0; (i < temp.getPersonLastname().length()) || (i < person.getPersonLastname().length()); i++) {
                    if (person.getPersonLastname().toLowerCase(Locale.ROOT).compareTo(temp.getPersonLastname().toLowerCase(Locale.ROOT)) == 0) {
                        action = 0;
                        continue;
                    }
                    if (person.getPersonLastname().toLowerCase(Locale.ROOT).compareTo(temp.getPersonLastname().toLowerCase(Locale.ROOT)) > 0) {
                        action = 1;
                        continue;
                    }
                    if (person.getPersonLastname().toLowerCase(Locale.ROOT).compareTo(temp.getPersonLastname().toLowerCase(Locale.ROOT)) < 0) {
                        action = -1;
                        break;
                    }
                }
                switch (action) {
                    case 1:
                        temp = temp.getNextPerson();
                        hash = hash.getNextPerson();
                        continue;
                    case 0:
                        person.setNextPerson(temp.getNextPerson());
                        temp.setNextPerson(person);
                        return;
                    case -1:
                        // отрезает всех выше
                        person.setNextPerson(temp);
                        hash.setNextPerson(person);
                        return;
                    default:
                        throw new IllegalStateException("Unexpected value: " + action);
                }
            } while (hash.getNextPerson() != null);

            // Если не сработает return;
            hash.setNextPerson(person);

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

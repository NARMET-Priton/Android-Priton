package it.volta.ts.smirnovartur.mainapplication.list.db;

public class PersonList {

    Person firstPerson, tempPerson;
    int counter;

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
                if (person.getPersonLastname().charAt(i < person.getPersonLastname().length()? i : person.getPersonLastname().length() - 1) == temp.getPersonLastname().charAt(i < temp.getPersonLastname().length()? i : temp.getPersonLastname().length() - 1)) {
                    action = 0;
                    continue;
                }
                if (person.getPersonLastname().charAt(i < person.getPersonLastname().length()? i : person.getPersonLastname().length() - 1) > temp.getPersonLastname().charAt(i < temp.getPersonLastname().length()? i : temp.getPersonLastname().length() - 1)) {
                    action = 1;
                    break;
                }
                if (person.getPersonLastname().charAt(i < person.getPersonLastname().length()? i : person.getPersonLastname().length() - 1) < temp.getPersonLastname().charAt(i < temp.getPersonLastname().length()? i : temp.getPersonLastname().length() - 1)) {
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
            while (temp.getNextPerson() != null) {
                for (int i = 0; (i < temp.getPersonLastname().length()) || (i < person.getPersonLastname().length()); i++) {
                    if (person.getPersonLastname().charAt(i < person.getPersonLastname().length()? i : person.getPersonLastname().length() - 1) == temp.getPersonLastname().charAt(i < temp.getPersonLastname().length()? i : temp.getPersonLastname().length() - 1)) {
                        action = 0;
                    }
                    if (person.getPersonLastname().charAt(i < person.getPersonLastname().length()? i : person.getPersonLastname().length() - 1) > temp.getPersonLastname().charAt(i < temp.getPersonLastname().length()? i : temp.getPersonLastname().length() - 1)) {
                        action = 1;
                    }
                    if (person.getPersonLastname().charAt(i < person.getPersonLastname().length()? i : person.getPersonLastname().length() - 1) < temp.getPersonLastname().charAt(i < temp.getPersonLastname().length()? i : temp.getPersonLastname().length() - 1)) {
                        action = -1;
                        break;
                    }
                }
                switch (action) {
                    case 1:
                        temp = temp.getNextPerson();
                        continue;
                    case 0:
                        person.setNextPerson(temp.getNextPerson());
                        temp.setNextPerson(person);
                        return;
                    case -1:
                        person.setNextPerson(temp);
                        hash.setNextPerson(person);
                        return;
                }
            }
            if (action == 1) {
                temp.setNextPerson(person);
            }
        }
    }

    // посмотреть код сортировщика sort

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

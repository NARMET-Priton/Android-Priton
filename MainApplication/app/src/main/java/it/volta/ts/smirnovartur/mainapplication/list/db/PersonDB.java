package it.volta.ts.smirnovartur.mainapplication.list.db;

// в классе содержащем структуру добавить проверку на одинаковые классы

public class PersonDB {

    private int freeIndex = 0;
    private final Person[] personDB = new Person[10];

    public void addNewPerson(Person person) {
        personDB[freeIndex] = person;
        freeIndex++;

//        System.out.println(size + person.getPersonData());
    }

    public void sortPersonDB() {git
        boolean done = false;
        while (!done) {
            done = true;
            for (int i = 0; i < personDB.length - 1; i++) {
                int num = 0;
                if (personDB[i] != null && personDB[i + 1] != null) {
                    String name1 = personDB[i].getPersonLastname();
                    String name2 = personDB[i + 1].getPersonLastname();
                    num = name1.compareTo(name2);
                } else if (personDB[i] == null && personDB[i + 1] == null) {
                    num = 0;
                } else if (personDB[i] == null) {
                    num = 1;
                } else {
                    num = -1;
                }
                if (num > 0) {
                    Person temp = personDB[i];
                    personDB[i] = personDB[i + 1];
                    personDB[i + 1] = temp;
                    done = false;
                }
            }
        }
    }

    public String getDB() {
        String str = "";
        for (int i = 0; i < freeIndex; i++) {
            str += personDB[i].getPersonData();
        }
        return str;
    }
}

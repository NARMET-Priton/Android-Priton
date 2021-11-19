package it.volta.ts.smirnovartur.mainapplication.list.db;

public class PersonList {

    // 1) Связать персон между собой   X
    // 1.1) Вывести на экран           X

    // 2) Отсортировать персон по фамилии
    // 2.1) Вывести на экран

    // 3) Отсортировать персон первостепенно по фамилии и второстепенно по имени
    // 3.1) Вывести на экран



    // попробовать сделать сортировку сразу при вводе
    // ввод элемента --> проверка с головы кужа ставить --> вставка

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

    // Change positions of persons Version
//    public void alphSortPearsonList() {
//        Person temp = firstPerson;
//
//        while (temp.getNextPerson() != null) {
//            if (temp.getNextPerson() != null && temp.getNextPerson().getNextPerson() != null) {
//                if (temp.getNextPerson().getPersonLastname() != null && temp.getNextPerson().getNextPerson().getPersonLastname() != null) {
//                    int compare = temp.getNextPerson().getPersonLastname().compareTo(temp.getNextPerson().getNextPerson().getPersonLastname());
//                    if (compare == 0) {
//                        continue;
//                    } else if (compare > 0) {
//                        continue;
//                    } else if (compare < 0) {
//                        // Change positions of persons Version
//                        Person toSwapPerson = temp.getNextPerson();
//                        temp.setNextPerson(temp.getNextPerson().getNextPerson());
//                        temp.getNextPerson().setNextPerson(toSwapPerson);
//                    }
//                }
//            } else {
//                break;
//            }
//
//            if (temp.getNextPerson() != null && temp.getNextPerson().getNextPerson() != null) {
//                if (temp.getNextPerson().getPersonName() != null && temp.getNextPerson().getNextPerson().getPersonName() != null) {
//                    int compare = temp.getNextPerson().getPersonName().compareTo(temp.getNextPerson().getNextPerson().getPersonName());
//                    if (compare == 0) {
//                        continue;
//                    } else if (compare > 0) {
//                        continue;
//                    } else if (compare < 0) {
//                        Person toSwapPerson = temp.getNextPerson();
//                        temp.setNextPerson(temp.getNextPerson().getNextPerson());
//                        temp.getNextPerson().setNextPerson(toSwapPerson);
//                    }
//                }
//            } else {
//                break;
//            }
//            temp = temp.getNextPerson();
//        }
//    }

    // Метод работает исправно
    // добавить в case 1 и 0 дополнительную проверку для имени

    // Change value of persons VersionSgit 
    public void alphSortPearsonList() {
        Person temp = firstPerson;
        int action = 0;
        // 1  - first > second
        // 0  - first == second
        // -1 - second < first

        while (temp.getNextPerson() != null) {
            if (temp.getPersonLastname() != null && temp.getNextPerson().getPersonLastname() != null) {
                for (int i = 0; (i < temp.getPersonLastname().length()) && (i < temp.getNextPerson().getPersonLastname().length()); i++) {
                    if (temp.getPersonLastname().charAt(Math.min(i, temp.getPersonLastname().length())) == temp.getNextPerson().getPersonLastname().charAt(Math.min(i, temp.getNextPerson().getPersonLastname().length()))) {
                        action = 0;;
                        continue;
                    } else if (temp.getPersonLastname().charAt(Math.min(i, temp.getPersonLastname().length())) < temp.getNextPerson().getPersonLastname().charAt(Math.min(i, temp.getNextPerson().getPersonLastname().length()))) {
                        action = 1;
                        break;
                    } else if (temp.getPersonLastname().charAt(Math.min(i, temp.getPersonLastname().length())) > temp.getNextPerson().getPersonLastname().charAt(Math.min(i, temp.getNextPerson().getPersonLastname().length()))) {
                        action = -1;
                        break;
                    }
                }
                switch (action){
                    case 1:
                        System.out.println("Result = " + action);
                        break;
                    case 0:
                        System.out.println("Result = " + action);
                        break;
                    case -1:
                        System.out.println("Result = " + action);

                        String toSwapPerson = temp.getPersonLastname();
                        temp.setPersonLastname(temp.getNextPerson().getPersonLastname());
                        temp.getNextPerson().setPersonLastname(toSwapPerson);
                        break;
                }
            }
            temp = temp.getNextPerson();
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

package geekbrains.java_level2;

public class TestPhoneBook {

    public static void main(String[] args) {

        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Ivanov", "89996665522");
        phoneBook.add("Petrov", "87775552211");
        phoneBook.add("Ivanov", "88883334422");
        phoneBook.add("Sidorov", "81114448899");

        phoneBook.get("Ivanov");
        phoneBook.get("Sobolev");
    }

  }

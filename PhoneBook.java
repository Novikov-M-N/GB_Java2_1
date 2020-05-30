package geekbrains.java_level2;

import java.util.ArrayList;
import java.util.HashMap;

public class PhoneBook {

    private HashMap<String, ArrayList<String>> phoneBook;

    public PhoneBook(){
        this.phoneBook = new HashMap<>();
    }

    public void add(String surname, String phone){
        ArrayList<String> phoneNum = new ArrayList<>();
        if(!this.phoneBook.containsKey(surname)){
            phoneNum.add(phone);
            this.phoneBook.put(surname, phoneNum);
        } else {
            this.phoneBook.get(surname).add(phone);
        }
    }

    public void get(String surname){
        if (this.phoneBook.containsKey(surname)){
            System.out.println("User under name " + surname + " has the following phone number(s): " + this.phoneBook.get(surname));;
        } else {
            System.out.println("User under name " + surname + " can not be found in your phone book");
        }
    }
}

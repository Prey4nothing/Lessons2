import java.util.ArrayList;
import java.util.HashMap;

public class Phonebook {
    private HashMap<String, ArrayList<String>> hm = new HashMap<>();


    public Phonebook(){

    }

    public void add(String lastName, String phoneNumber){
        ArrayList<String> phoneNumbers = hm.get(lastName);
        if (phoneNumbers != null) {
            phoneNumbers.add(phoneNumber);

        } else {
            phoneNumbers = new ArrayList<>();
            phoneNumbers.add(phoneNumber);
            hm.put(lastName,phoneNumbers);

        }
    }

    public void get (String lastName){
        System.out.println(lastName + hm.get(lastName));
    }

}

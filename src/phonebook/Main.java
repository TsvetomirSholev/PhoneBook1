package phonebook;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args){
        //Phonebook creation
        File file = new File("phonebook.txt");
        PhoneBookUtils phoneBookUtils = new PhoneBookUtils();
        PhoneBook phonebook = phoneBookUtils.createPhoneBook(file);

        //Phonebook entry deletion
        phoneBookUtils.deleteByName("Васето Васков Васков", phonebook);
        System.out.println(phonebook.getPhonebook().get("Васето Васков Васков") + "\n");

        //PhoneBook entry adding
        phoneBookUtils.addPair("Васето Васков Васков", "0878123456", phonebook);
        System.out.println(phonebook.getPhonebook().get("Васето Васков Васков") + "\n");
        System.out.println(phoneBookUtils.getNumberByName("Васето Васков Васков", phonebook));

        //Printing sorted by name
        phoneBookUtils.printEntriesSortedByName(phonebook);
    }
}

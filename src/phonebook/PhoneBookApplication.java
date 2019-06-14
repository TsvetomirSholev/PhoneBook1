package phonebook;

import phonebook.utils.PhoneBookUtils;
import phonebook.entities.PhoneBook;

import java.io.File;

public class PhoneBookApplication {
    public static void main(String[] args) {

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

        //Get Number by name
        System.out.println(phoneBookUtils.getNumberByName("Васето Васков Васков", phonebook) + "\n");

        //Set calls
        phonebook.getPhonebook().get("Goshko Гогов Gogov").setOutGoingCallsCount(5);
        phonebook.getPhonebook().get("Атанаско Насков Насков").setOutGoingCallsCount(0);
        phonebook.getPhonebook().get("Васето Васков Васков").setOutGoingCallsCount(17);
        phonebook.getPhonebook().get("dobre de stavaa").setOutGoingCallsCount(10);
        phonebook.getPhonebook().get("Май de Работи").setOutGoingCallsCount(3);
        phonebook.getPhonebook().get("dobre de Ehaaa").setOutGoingCallsCount(6);
        phonebook.getPhonebook().get("dobre de stava").setOutGoingCallsCount(43);

        //Printing sorted by name without calls
//        phoneBookUtils.printEntriesSortedByName(phonebook);

        //Prints entries
//        phonebook.getPhonebook().forEach((key,value)-> System.out.println(value));

        //Prints top five entries sorted by calls
        phoneBookUtils.printTopFive(phonebook);


    }
}

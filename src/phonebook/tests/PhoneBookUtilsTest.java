package phonebook.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import phonebook.entities.PhoneBook;
import phonebook.utils.PhoneBookUtils;

import java.io.File;

class PhoneBookUtilsTest {

    @Test
    void createPhoneBook() {
        File file = new File("phonebook.txt");
        PhoneBookUtils phoneBookUtils = new PhoneBookUtils();
        PhoneBook phonebook = phoneBookUtils.createPhoneBook(file);

        Assertions.assertNotNull(phonebook);
    }

    @Test
    void deleteByName() {
        File file = new File("phonebook.txt");
        PhoneBookUtils phoneBookUtils = new PhoneBookUtils();
        PhoneBook phonebook = phoneBookUtils.createPhoneBook(file);

        String name = "Васето Васков Васков";

        phoneBookUtils.deleteByName("Васето Васков Васков", phonebook);

        Assertions.assertNull(phonebook.getPhonebook().get(name));
    }

    @Test
    void addPair() {
        File file = new File("phonebook.txt");
        PhoneBookUtils phoneBookUtils = new PhoneBookUtils();
        PhoneBook phonebook = phoneBookUtils.createPhoneBook(file);

        String name = "Петър Петров Петровов";
        String number = "0878123456";

        phoneBookUtils.addPair(name,number , phonebook);

        Assertions.assertNotNull(phonebook.getPhonebook().get(name));
    }

    @Test
    void getNumberByName() {
        File file = new File("phonebook.txt");
        PhoneBookUtils phoneBookUtils = new PhoneBookUtils();
        PhoneBook phonebook = phoneBookUtils.createPhoneBook(file);

        String name = "Васето Васков Васков";

        Assertions.assertNotNull(phonebook.getPhonebook().get(name));
    }

    @Test
    void printEntriesSortedByName() {
        File file = new File("phonebook.txt");
        PhoneBookUtils phoneBookUtils = new PhoneBookUtils();
        PhoneBook phonebook = phoneBookUtils.createPhoneBook(file);

        // ?
    }

    @Test
    void printTopFive() {
        // ?
    }
}
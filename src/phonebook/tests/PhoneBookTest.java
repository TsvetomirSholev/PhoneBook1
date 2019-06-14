package phonebook.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import phonebook.entities.PhoneBook;
import phonebook.entities.PhoneBookEntry;
import phonebook.utils.PhoneBookUtils;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class PhoneBookTest {

    @Test
    void getPhonebook() {
    }

    @Test
    void setPhonebook() {
    }

    @Test
    void addToPhonebook() {
        File file = new File("phonebook.txt");
        PhoneBookUtils phoneBookUtils = new PhoneBookUtils();
        PhoneBook phonebook = phoneBookUtils.createPhoneBook(file);
        PhoneBookEntry entry = new PhoneBookEntry("Cvetko Cvetkov Cvetkovv","0884711066");

        phonebook.addToPhonebook(entry);

        Assertions.assertNotNull(phonebook.getPhonebook().get("Cvetko Cvetkov Cvetkovv"));
    }
}
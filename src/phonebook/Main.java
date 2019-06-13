package phonebook;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        File file = new File("phonebook.txt");

        PhoneBook phoneBook = new PhoneBook();
        phoneBook.readFromFile(file);


    }
}

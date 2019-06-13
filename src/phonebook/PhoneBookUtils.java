package phonebook;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

public class PhoneBookUtils {

    // +359878123456 - normalized form
    //Reads from a text file a pair like (name, number)
    // name is a random name, number is a phone number
    //Ignore invalid pairs
    public PhoneBook createPhoneBook(File file) {
        PhoneBook phoneBook = new PhoneBook();
        try (final LineNumberReader lineNumberReader = new LineNumberReader(new FileReader(file))) {
            String line;

            while ((line = lineNumberReader.readLine()) != null) {
                if (isEntryValid(line)) {
                    String[] splitLine = line.split("[ ][,][ ]");
                    PhoneBookEntry entry = new PhoneBookEntry(splitLine[1], makeNumberNormal(splitLine[0]));
                    phoneBook.addToPhonebook(entry);
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return phoneBook;

    }


    private String makeNumberNormal(String number) {
        StringBuilder normalNumber = new StringBuilder();
        if (number.startsWith("00359")) {
            normalNumber.append("+359");
            normalNumber.append(number.substring(5));
        } else if (number.startsWith("08")) {
            normalNumber.append("+359");
            normalNumber.append(number.substring(1));

        } else {
            normalNumber.append(number);

        }


        return String.valueOf(normalNumber);
    }

    //checks if the pair name - phone number is valid
    //ignores invalid entries
    private boolean isEntryValid(String entry) {
        String[] splitEntry = entry.split("[ ][,][ ]");
        boolean checkValidation;
        if (splitEntry.length != 2) {
            checkValidation = false;
        } else {
            try {
                long checker = Long.parseLong(makeNumberNormal(splitEntry[0]).substring(1));
                checkValidation = isNumberValid(splitEntry[0]) && isNameValid(splitEntry[1]);
            } catch (NumberFormatException e) {
                System.out.println("Phone number should contain only Integers: " + makeNumberNormal(splitEntry[0]).substring(1) + "\n");
                checkValidation = false;
            }
        }

        return checkValidation;
    }

    //Validates the number from a string
    private boolean isNumberValid(String number) {
        boolean checkNumberValidity = false;
        if (number.startsWith("0")) {

            if (number.startsWith("003598")) {

                checkNumberValidity = number.charAt(6) <= 57 && number.charAt(6) >= 50 && number.length() == 14;

            } else if (number.startsWith("08")) {
                checkNumberValidity = number.charAt(2) <= 57 && number.charAt(2) >= 55 && number.length() == 10;
            }

        } else if (number.startsWith("+3598")) {

            checkNumberValidity = number.charAt(5) <= 57 && number.charAt(5) >= 55 && number.length() == 13;

        }
        return checkNumberValidity;
    }

    //Validates the name of the entry from a string
    private boolean isNameValid(String name) {
        boolean checkNameValidity;

        checkNameValidity = name.matches("^(?:[\\p{L}\\p{Mn}\\p{Pd}\\'\\x{2019}]+\\s[\\p{L}\\p{Mn}\\p{Pd}\\'\\x{2019}]+\\s?)+$");

        return checkNameValidity;
    }

    //deletes an entry from the phone book by the entry's name
    public void deleteByName(String name, PhoneBook phoneBook) {
        System.out.println("Deleting: " + "\n" + phoneBook.getPhonebook().get(name) + "\n");
        phoneBook.getPhonebook().remove(name);

    }

    //adds a pair to a phonebook
    public void addPair(String name, String number, PhoneBook phonebook) {

        if (isNameValid(name) && isNumberValid(number)) {

            PhoneBookEntry newEntry = new PhoneBookEntry(name, makeNumberNormal(number));
            phonebook.getPhonebook().put(name, newEntry);
            System.out.println("Adding: " + phonebook.getPhonebook().get(name) + "\n");
        } else {
            System.out.println("Invalid Entry with Name: " + name + " and number: " + number);

        }


    }

    //gets the number from the phonebook by name
    public String getNumberByName(String name, PhoneBook phoneBook) {
        return phoneBook.getPhonebook().get(name).getPhoneNumber();
    }

    //prints all entries sorted by name Automatically sorted by TreeMap already
    public void printEntriesSortedByName(PhoneBook phoneBook) {
        phoneBook.getPhonebook().forEach((key, value) -> System.out.println("Name: " + key + "\nNumber: " + value.getPhoneNumber() + "\n"));
    }
}

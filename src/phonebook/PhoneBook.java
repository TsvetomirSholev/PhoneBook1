package phonebook;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

public class PhoneBook {
    // +359878123456 - normalized form
    //Reads from a text file a pair like (name, number)
    // name is a random name, number is a phone number
    //Ignore invalid pairs
    public void readFromFile(File file) {
        try (final LineNumberReader lineNumberReader = new LineNumberReader(new FileReader(file))) {
            String line;
            while ((line = lineNumberReader.readLine()) != null) {

                if (isEntryValid(line)) {
                    System.out.println(line);
                }


            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    //checks if the pair name - phone number is valid
    //ignores invalid entries
    private boolean isEntryValid(String entry) {
        String[] splitEntry = entry.split("[ ][,][ ]");
        boolean checkValidation;
        if (splitEntry.length != 2) {
            checkValidation = false;
        } else {
            checkValidation = isNumberValid(splitEntry[0]) && isNameValid(splitEntry[1]);
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
        boolean checkNameValidity = false;

        checkNameValidity = name.matches("^(?:[\\p{L}\\p{Mn}\\p{Pd}\\'\\x{2019}]+\\s[\\p{L}\\p{Mn}\\p{Pd}\\'\\x{2019}]+\\s?)+$");

        return checkNameValidity;
    }

    //deletes an entry from the phone book by the entry's name
    public void deleteByName(/* name / phonebook */) {

    }

    //adds a pair to a phonebook
    public void addPair(/* name / number / phonebook*/) {

    }

    //gets the number from the phonebook by name
    public void getNumberByName( /* name */) {


    }


}

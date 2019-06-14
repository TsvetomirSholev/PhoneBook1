package phonebook.entities;

import java.util.TreeMap;

public class PhoneBook {
    //    private List<PhoneBook> phonebookList = new ArrayList<>();
    private TreeMap<String, PhoneBookEntry> phonebook = new TreeMap<>();

    public TreeMap<String, PhoneBookEntry> getPhonebook() {
        return phonebook;
    }

    public void setPhonebook(TreeMap<String, PhoneBookEntry> phonebook) {
        this.phonebook = phonebook;
    }

    public void addToPhonebook(PhoneBookEntry entry) {
        this.phonebook.put(entry.getPersonName(), entry);

    }
}

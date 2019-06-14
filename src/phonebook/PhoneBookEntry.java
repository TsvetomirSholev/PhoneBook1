package phonebook;

import java.util.Objects;

public class PhoneBookEntry {
    private String personName;
    private String phoneNumber;
    private int outGoingCallsCount;

    public PhoneBookEntry(String personName, String phoneNumber) {
        this.personName = personName;
        this.phoneNumber = phoneNumber;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getOutGoingCallsCount() {
        return outGoingCallsCount;
    }

    public void setOutGoingCallsCount(int outGoingCallsCount) {
        this.outGoingCallsCount = outGoingCallsCount;
    }

    @Override
    public String toString() {
        return "PhoneBookEntry is: " + personName + '\n' +
                "Phone number is: " + phoneNumber + '\n' +
                "Has outgoing calls: " + outGoingCallsCount + "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PhoneBookEntry that = (PhoneBookEntry) o;
        return Objects.equals(personName, that.personName) &&
                Objects.equals(phoneNumber, that.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(personName, phoneNumber);
    }
}

package events.paiya.accountmanager.domains;

import events.paiya.accountmanager.enumerations.Gender;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceCreator;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Objects;

@Document
@Getter @Setter
public class User {
    @Id
    private String id;
    private String lastname;
    private String firstname;
    private String email;
    private Gender gender;
    private String phoneNumber;
    private Organizer organizer;
    private Address address;
    private List<FinancialOperationAccount> financialOperationAccounts;
    private boolean isEnabled;

    public void enableUser(){
        this.isEnabled = true;
    }

    public void disableUser(){
        this.isEnabled = false;
    }

    @PersistenceCreator
    public User(String id, String lastname, String firstname, String email, Gender gender, String phoneNumber, Organizer organizer, Address address) {
        this.id = id;
        this.lastname = lastname;
        this.firstname = firstname;
        this.email = email;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.organizer = organizer;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id='" + id + '\'' +
                ", lastname='" + lastname + '\'' +
                ", firstname='" + firstname + '\'' +
                ", email='" + email + '\'' +
                ", gender=" + gender +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", organizer=" + organizer +
                ", adress=" + address +
                '}';
    }

    @Getter @Setter
    public static class Organizer{
        private EventOrganizer eventOrganizer;
        private String poste;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Organizer organizer = (Organizer) o;
            return eventOrganizer.equals(organizer.eventOrganizer) && poste.equals(organizer.poste);
        }

        @Override
        public int hashCode() {
            return Objects.hash(eventOrganizer, poste);
        }
    }

    @Getter @Setter
    public static class Address {
        private String country;
        private String city;
        private String state;
        private String postal;
        private String adressDetail;
    }
}

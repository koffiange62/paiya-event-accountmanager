package events.paiya.accountmanager.domain;

import events.paiya.accountmanager.enumeration.FinancialAccountType;
import events.paiya.accountmanager.enumeration.Gender;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceCreator;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
@Getter @Setter
public class Account {
    @Id
    private String id;
    private String lastname;
    private String firstname;
    private String email;
    private Gender gender;
    private String phoneNumber;
    private Organizer organizer;
    private Address address;
    private List<FinancialAccount> financialAccounts;

    @PersistenceCreator
    public Account(String id, String lastname, String firstname, String email, Gender gender, String phoneNumber, Organizer organizer, Address address) {
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
    private static class Organizer{
        private EventOrganizer eventOrganizer;
        private String poste;

    }

    @Getter @Setter
    private static class Address {
        private String country;
        private String city;
        private String state;
        private String postal;
        private String adressDetail;
    }
}

package events.paiya.accountmanager.domains;

import events.paiya.accountmanager.enumerations.Gender;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
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
    private boolean active;

    public void enableUser(){
        this.active = true;
    }

    public void disableUser(){
        this.active = false;
    }

}

package objects;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
    public String title;
    public String username;
    public String password;
    public String firstName;
    public String lastName;
    public String phone;
    public TenantId tenantId;
    public AdditionalInfo additionalInfo;

    public User(String email, String password) {
        this.username = email;
        this.password = password;
    }

    public User(String email, String password, String firstName, String lastName) {
        this.username = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public User(String email, String password, String firstName, String lastName, AdditionalInfo additionalInfo) {
        this.username = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.additionalInfo = additionalInfo;
    }

    public User(String email, String firstName, String lastName) {
        this.username = email;
        this.firstName = firstName;
        this.lastName = lastName;
    }
}

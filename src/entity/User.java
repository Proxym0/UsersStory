package entity;

import java.util.List;
import java.util.Set;

public class User {
    private String name;
    private String lastname;
    private String email;
    private String phone;
    private RoleEnum role;
    private List<Phone> phoneNumbers;

    public User(String name, String lastname, String email, String phone) {
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.phone = phone;
    }

    public User(String name, String lastname, String email, String phone, RoleEnum role) {
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.phone = phone;
        this.role = role;
    }

    public User() {
    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }


    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}

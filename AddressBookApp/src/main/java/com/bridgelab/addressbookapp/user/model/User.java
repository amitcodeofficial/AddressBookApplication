package com.bridgelab.addressbookapp.user.model;

import com.bridgelab.addressbookapp.addressBook.model.AddressBook;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private long phoneNumber;
    @OneToMany(targetEntity = AddressBook.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "ua_fk",referencedColumnName = "id")
    private List<AddressBook> addressBookList = new ArrayList<AddressBook>();

    public User(String firstName, String lastName, String email, String password, long phoneNumber, List<AddressBook> addressBookList) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.addressBookList = addressBookList;
    }

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<AddressBook> getAddressBookList() {
        return addressBookList;
    }

    public void setAddressBookList(List<AddressBook> addressBookList) {
        this.addressBookList = addressBookList;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", addressBookList=" + addressBookList +
                '}';
    }
}

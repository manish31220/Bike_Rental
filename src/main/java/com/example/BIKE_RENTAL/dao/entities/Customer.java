package com.example.BIKE_RENTAL.dao.entities;

import jakarta.persistence.*;

@Entity
@Table(name="Customer", catalog = "Bike_Rental")
public class Customer {
    private String email;

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getActiveUser() {
        return activeUser;
    }

    public void setActiveUser(int activeUser) {
        this.activeUser = activeUser;
    }

    @Column(name="Customer_Id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer customerId;
    @Column(name="FirstName")
    private String  firstName;
    @Column(name="LastName")
    private String  lastName;
    @Column(name="Address")
    private String  address;
    @Column(name="PhoneNumber")
    private int  phoneNumber;
    @Column(name="ActiveUser")
    private int activeUser;


}

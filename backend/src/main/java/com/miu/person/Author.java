package com.miu.person;

import com.miu.Address;

import java.io.Serializable;

public class Author implements Serializable {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String credentials;
    private String shortBio;
    private Address address;

    public Author(String firstName, String lastName, String phoneNumber, String credentials, String shortBio, Address address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.credentials = credentials;
        this.shortBio = shortBio;
        this.address = address;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getCredentials() {
        return credentials;
    }

    public String getShortBio() {
        return shortBio;
    }

    public Address getAddress() {
        return address;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;

    }

    public void setCredentials(String credentials) {
        this.credentials = credentials;
    }

    public void setShortBio(String shortBio) {
        this.shortBio = shortBio;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

}
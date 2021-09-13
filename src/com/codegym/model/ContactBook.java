package com.codegym.model;

public class ContactBook {
    private int numberPhone;
    private String fullName;
    private String gender;
    private String address;
    private ContactGroup contactGroup;

    public ContactBook(){}

    public ContactBook(int numberPhone, String fullName, String gender, String address, ContactGroup contactGroup) {
        this.numberPhone = numberPhone;
        this.fullName = fullName;
        this.gender = gender;
        this.address = address;
        this.contactGroup = contactGroup;
    }

    public int getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(int numberPhone) {
        this.numberPhone = numberPhone;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public ContactGroup getContactGroup() {
        return contactGroup;
    }

    public void setContactGroup(ContactGroup contactGroup) {
        this.contactGroup = contactGroup;
    }

    @Override
    public String toString() {
        return "numberPhone=" + numberPhone +
                ", fullName='" + fullName + '\'' +
                ", gender='" + gender + '\'' +
                ", address='" + address + '\'' +
                ", contactGroup=" + contactGroup;
    }
}

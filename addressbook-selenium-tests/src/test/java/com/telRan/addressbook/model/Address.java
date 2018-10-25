package com.telRan.addressbook.model;

public class Address {
  private String addressName;
  private String familyName;
  private String address;
  private String email;
  private String phone;


  public Address setAddressName(String addressName) {
    this.addressName=addressName;
    return this;
  }

  public Address setFamilyName(String familyName) {
    this.familyName=familyName;
    return this;
  }

  public Address setAddress(String address) {
    this.address=address;
    return this;
  }

  public Address setEmail(String email) {
    this.email=email;
    return this;
  }

  public Address setPhone(String phone) {
    this.phone=phone;
    return this;
  }

  public String getAddressName() {
    return addressName;
  }

  public String getFamilyName() {
    return familyName;
  }

  public String getAddress() {
    return address;
  }

  public String getEmail() {
    return email;
  }

  public String getPhone() {
    return phone;
  }
}

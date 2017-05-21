package ru.stqa.pft.addressbook.model;

public class ContactData {
  private final String firstName;
  private final String lastNAme;
  private final String address;
  private final String mobile;

  public ContactData(String firstName, String lastNAme, String address, String mobile) {
    this.firstName = firstName;
    this.lastNAme = lastNAme;
    this.address = address;
    this.mobile = mobile;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastNAme() {
    return lastNAme;
  }

  public String getAddress() {
    return address;
  }

  public String getMobile() {
    return mobile;
  }
}

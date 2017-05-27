package ru.stqa.pft.addressbook.model;

public class ContactData {
  private final String firstName;
  private final String lastNAme;
  private final String address;
  private final String mobile;
  private String group;

  public ContactData(String firstName, String lastNAme, String address, String mobile, String group) {
    this.firstName = firstName;
    this.lastNAme = lastNAme;
    this.address = address;
    this.mobile = mobile;
    this.group = group;
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

  public String getGroup() {
    return group;
  }
}

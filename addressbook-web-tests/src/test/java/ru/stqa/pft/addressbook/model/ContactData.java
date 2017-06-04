package ru.stqa.pft.addressbook.model;

public class ContactData {
  private int id;
  private final String firstName;
  private final String lastNAme;
  private final String address;
  private final String mobile;
  private String group;

  public ContactData(int id, String firstName, String lastNAme, String address, String mobile, String group) {
    this.id = id;
    this.firstName = firstName;
    this.lastNAme = lastNAme;
    this.address = address;
    this.mobile = mobile;
    this.group = group;
  }

  public ContactData(String firstName, String lastNAme, String address, String mobile, String group) {
    this.id = Integer.MAX_VALUE;
    this.firstName = firstName;
    this.lastNAme = lastNAme;
    this.address = address;
    this.mobile = mobile;
    this.group = group;
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

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    ContactData that = (ContactData) o;

    if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null) return false;
    return lastNAme != null ? lastNAme.equals(that.lastNAme) : that.lastNAme == null;
  }

  @Override
  public int hashCode() {
    int result = firstName != null ? firstName.hashCode() : 0;
    result = 31 * result + (lastNAme != null ? lastNAme.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "ContactData{" +
            "firstName='" + firstName + '\'' +
            ", lastNAme='" + lastNAme + '\'' +
            '}';
  }

}

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

  @Override
  public String toString() {
    return "ContactData{" +
            "firstName='" + firstName + '\'' +
            ", lastNAme='" + lastNAme + '\'' +
            ", address='" + address + '\'' +
            ", mobile='" + mobile + '\'' +
            ", group='" + group + '\'' +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    ContactData that = (ContactData) o;

    if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null) return false;
    if (lastNAme != null ? !lastNAme.equals(that.lastNAme) : that.lastNAme != null) return false;
    if (address != null ? !address.equals(that.address) : that.address != null) return false;
    if (mobile != null ? !mobile.equals(that.mobile) : that.mobile != null) return false;
    return group != null ? group.equals(that.group) : that.group == null;
  }

  @Override
  public int hashCode() {
    int result = firstName != null ? firstName.hashCode() : 0;
    result = 31 * result + (lastNAme != null ? lastNAme.hashCode() : 0);
    result = 31 * result + (address != null ? address.hashCode() : 0);
    result = 31 * result + (mobile != null ? mobile.hashCode() : 0);
    result = 31 * result + (group != null ? group.hashCode() : 0);
    return result;
  }
}

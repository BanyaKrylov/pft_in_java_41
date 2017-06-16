package ru.stqa.pft.addressbook.model;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

import java.io.File;

@XStreamAlias("contacts")
public class ContactData {
  @XStreamOmitField
  private int id = Integer.MAX_VALUE;
  private String firstName;
  private String lastNAme;
  private String address;
  private String mobile;
  private String group;
  private String homePhone;
  private String workPhone;
  private String allPhones;
  private String email;
  private String email2;
  private String email3;
  private String allEmails;
  private File photo;

  public File getPhoto() {
    return photo;
  }

  public ContactData withPhoto(File photo) {
    this.photo = photo;
    return this;
  }

  public ContactData withAllPhones(String allPhones) {
    this.allPhones = allPhones;
    return this;
  }

  public ContactData withAllEmails(String allEmails) {
    this.allEmails = allEmails;
    return this;
  }

  public int getId() {
    return id;
  }

  public ContactData withId(int id) {
    this.id = id;
    return this;
  }

  public ContactData withFirstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  public ContactData withLastName(String lastNAme) {
    this.lastNAme = lastNAme;
    return this;
  }

  public ContactData withAddress(String address) {
    this.address = address;
    return this;
  }

  public ContactData withMobile(String mobile) {
    this.mobile = mobile;
    return this;
  }

  public ContactData withHomePhone(String homePhone) {
    this.homePhone = homePhone;
    return this;
  }


  public ContactData withWorkPhone(String workPhone) {
    this.workPhone = workPhone;
    return this;
  }

  public ContactData withEmail(String email) {
    this.email = email;
    return this;
  }

  public ContactData withEmail2(String email2) {
    this.email2 = email2;
    return this;
  }

  public ContactData withEmail3(String email3) {
    this.email3 = email3;
    return this;
  }

  public ContactData withGroup(String group) {
    this.group = group;
    return this;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastNAme;
  }

  public String getAddress() {
    return address;
  }

  public String getMobilePhone() {
    return mobile;
  }

  public String getHomePhone() {
    return homePhone;
  }

  public String getWorkPhone() {
    return workPhone;
  }

  public String getAllPhones() {
    return allPhones;
  }

  public String getEmail() {
    return email;
  }

  public String getEmail2() {
    return email2;
  }

  public String getEmail3() {
    return email3;
  }

  public String getAllEmails() {
    return allEmails;
  }

  public String getGroup() {
    return group;
  }

  public boolean equals(Object object) {
    if (this == object) return true;
    if (object == null || getClass() != object.getClass()) return false;
    if (!super.equals(object)) return false;

    ContactData that = (ContactData) object;

    if (id != that.id) return false;
    if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null) return false;
    if (lastNAme != null ? !lastNAme.equals(that.lastNAme) : that.lastNAme != null) return false;
    if (address != null ? !address.equals(that.address) : that.address != null) return false;
    if (allPhones != null ? !allPhones.equals(that.allPhones) : that.allPhones != null) return false;
    if (allEmails != null ? !allEmails.equals(that.allEmails) : that.allEmails != null) return false;

    return true;
  }

  public int hashCode() {
    int result = super.hashCode();
    result = 31 * result + id;
    result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
    result = 31 * result + (lastNAme != null ? lastNAme.hashCode() : 0);
    result = 31 * result + (address != null ? address.hashCode() : 0);
    result = 31 * result + (allPhones != null ? allPhones.hashCode() : 0);
    result = 31 * result + (allEmails != null ? allEmails.hashCode() : 0);
    return result;
  }

  @java.lang.Override
  public java.lang.String toString() {
    return "ContactData{" +
            "id=" + id +
            ", firstName='" + firstName + '\'' +
            ", lastNAme='" + lastNAme + '\'' +
            ", address='" + address + '\'' +
            ", allPhones='" + allPhones + '\'' +
            ", allEmails='" + allEmails + '\'' +
            '}';
  }

}

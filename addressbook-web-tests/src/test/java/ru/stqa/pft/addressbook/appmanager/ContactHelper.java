package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.pft.addressbook.model.ContactData;

/**
 * Created by ivan8 on 22.05.2017.
 */
public class ContactHelper extends HelperBase {

  public ContactHelper(FirefoxDriver wd) {
    super(wd);
  }

  public void submitContact() {
    click(By.name("submit"));
  }

  public void fillContact(ContactData contactData) {
    type(By.name("firstname"), contactData.getFirstName());
    type(By.name("lastname"), contactData.getLastNAme());
    type(By.name("address"), contactData.getAddress());
    type(By.name("mobile"), contactData.getMobile());
  }

  public void initNewContact() {
    click(By.linkText("add new"));
  }

  public void confirmation() {
    Alert alert = wd.switchTo().alert();
    alert.accept();
  }

  public void deleteContact() {
    click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));
  }

  public void selectContact() {
    click(By.name("selected[]"));
  }
}

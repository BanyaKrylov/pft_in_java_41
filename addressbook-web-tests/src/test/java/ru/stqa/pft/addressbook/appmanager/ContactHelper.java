package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.util.List;

/**
 * Created by ivan8 on 22.05.2017.
 */
public class ContactHelper extends HelperBase {

  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  public void submitContact() {
    click(By.name("submit"));
  }

  public void fillContact(ContactData contactData, boolean creation) {
    type(By.name("firstname"), contactData.getFirstName());
    type(By.name("lastname"), contactData.getLastNAme());
    type(By.name("address"), contactData.getAddress());
    type(By.name("mobile"), contactData.getMobile());


    if (creation) {
      new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
    } else {
      Assert.assertFalse(isElementPresent(By.name("new_group")));
    }
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

  public void selectContactById(int id) {
    wd.findElement(By.cssSelector("input[value ='" + id + "']")).click();
  }

  public void initContactModification(int id) {
    wd.findElement(By.cssSelector("a[href = 'edit.php?id=" + id + "']")).click();
  }

  public void submitContactModification() {
    click(By.xpath("//div[@id='content']/form[1]/input[22]"));
  }

  public void create(ContactData contact, boolean b) {
    initNewContact();
    fillContact(contact, b);
    submitContact();
    returnHomePage();
  }

  public void modify(ContactData contact) {
    selectContactById(contact.getId());
    initContactModification(contact.getId());
    fillContact(contact, false);
    submitContactModification();
    returnHomePage();
  }

  public void delete(ContactData contact) {
    selectContactById(contact.getId());
    deleteContact();
    confirmation();
    returnHomePage();
  }

  public void returnHomePage() {
    click(By.linkText("home"));
  }

  public boolean isThereAContact() {
    return isElementPresent(By.name("selected[]"));
  }

  public int getContactCount() {
    return wd.findElements(By.name("selected[]")).size();
  }

  public Contacts all() {
    Contacts contacts = new Contacts();
    List<WebElement> elements = wd.findElements(By.name("entry"));
    for (WebElement element : elements) {
      List<WebElement> name = element.findElements(By.tagName("td"));
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      contacts.add(new ContactData().withId(id).withFirstName(name.get(2).getText()).
              withLastName(name.get(1).getText()));
    }
    return contacts;
  }
}

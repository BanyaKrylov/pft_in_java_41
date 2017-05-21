package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

/**
 * Created by ivan8 on 22.05.2017.
 */
public class ContactModificationTests extends TestBase {

  @Test
  public void testContactModification() {
    app.getContactHelper().selectContact();
    app.getContactHelper().initContactModification();
    app.getContactHelper().fillContact(new ContactData("Ivan", "Rubinn", "Moscow", "896512354"));
    app.getContactHelper().submitContactModification();
    app.getNavigationHelper().returnHomePage();
  }
}

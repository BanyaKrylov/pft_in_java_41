package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() {
    app.initNewContact();
    app.fillContact(new ContactData("Ivan", "Rubin", "Moscow", "896512354"));
    app.submitContact();
    app.returnHomePage();
  }
}

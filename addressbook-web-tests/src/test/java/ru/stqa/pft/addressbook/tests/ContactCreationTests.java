package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() {
    app.getContactHelper().initNewContact();
    app.getContactHelper().fillContact(new ContactData("Ivan", null, "Moscow", "896512354", "test1"), true);
    app.getContactHelper().submitContact();
    app.getNavigationHelper().returnHomePage();
  }
}

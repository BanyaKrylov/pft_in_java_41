package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

/**
 * Created by ivan8 on 22.05.2017.
 */
public class ContactModificationTests extends TestBase {

  @Test
  public void testContactModification() {
    app.getNavigationHelper().goToHomePage();
    int before = app.getContactHelper().getContactCount();
    if (!app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new ContactData("Ivan", null, "Moscow", "896512354", "test1"), true);
    }
    app.getContactHelper().selectContact(before - 1);
    app.getContactHelper().initContactModification();
    app.getContactHelper().fillContact(new ContactData("Ivan", "Rubinni", "Moscow", "896512354", null), false);
    app.getContactHelper().submitContactModification();
    app.getContactHelper().returnHomePage();
    int after = app.getContactHelper().getContactCount();

    Assert.assertEquals(after, before);
  }
}

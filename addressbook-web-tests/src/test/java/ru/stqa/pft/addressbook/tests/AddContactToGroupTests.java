package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by ivan8 on 05.07.2017.
 */
public class AddContactToGroupTests extends TestBase {
  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().groupPage();
    if (app.db().groups().size() == 0) {
      app.group().create(new GroupData().withName("Test1").withHeader("Test2").withFooter("Test3"));
    }
    app.goTo().homePage();
    Groups groups = app.db().groups();
    if (app.db().contacts().size() == 0) {
      app.contact().create(new ContactData().withFirstName("Ivan").withLastName("Krylov")
              .withAddress("Moscow").withMobile("789546").withEmail("ivan8532@mdfs.fdsf").inGroup(groups.iterator()
                      .next()), true);
    }
  }

  @Test
  public void testAddContactToGroup() {
    int contactId = 0;
    boolean completed = false;
    Groups beforeAddGroups = null;
    Groups beforeWithAddedGroups = null;
    Groups existedGroups = app.db().groups();
    Contacts contacts = app.db().contacts();

    for (ContactData editedContact : contacts) {
      beforeAddGroups = editedContact.getGroups();
      GroupData newGroup = app.contact().getGroupToAdd(existedGroups, editedContact);
      if (newGroup != null) {
        app.contact().addContact(editedContact, newGroup);
        contactId = editedContact.getId();
        beforeWithAddedGroups = beforeAddGroups.withAdded(newGroup);
        completed = true;
        break;
      }
    }

    if (!completed) {
      app.goTo().groupPage();
      app.group().create(new GroupData().withName("Test10").withHeader("Test2").withFooter("Test3"));
      Groups extendedGroups = app.db().groups();
      GroupData lastAddedGroup = extendedGroups.stream().max((g1, g2) -> Integer.compare(g1.getId(), g2.getId())).get();
      ContactData contact = contacts.iterator().next();
      contactId = contact.getId();
      app.contact().addContact(contact, lastAddedGroup);
      beforeWithAddedGroups = beforeAddGroups.withAdded(lastAddedGroup);

    }
    Groups groupAfter = app.db().contactById(contactId).getGroups();
    assertThat(groupAfter, equalTo(beforeWithAddedGroups));
  }
}

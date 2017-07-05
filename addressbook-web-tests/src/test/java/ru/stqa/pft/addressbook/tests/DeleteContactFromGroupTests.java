package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by ivan8 on 05.07.2017.
 */
public class DeleteContactFromGroupTests extends TestBase {
  @BeforeMethod
  public void ensurePreconditions() {

    app.goTo().groupPage();
    if (app.db().groups().size() == 0) {
      app.group().create(new GroupData().withName("Test1").withHeader("Test2").withFooter("Test3"));
    }
    app.goTo().homePage();
    Groups groups = app.db().groups();
    if (app.db().contacts().size() == 0) {
      app.contact().create(new ContactData().withFirstName("Ivan").withLastName("Krylov").withAddress("Moscow").withMobile("456876")
              .withEmail("ivan@re.fdsf").inGroup(groups.iterator().next()), true);
    } else {
      ContactData contact = app.db().contacts().iterator().next();
      if (contact.getGroups().size() == 0) {
        contact.inGroup(groups.iterator().next());
      }

    }
  }

  @Test
  public void testDeleteContactFromGroup() {

    ContactData contact = app.db().contacts().iterator().next();
    Groups before = contact.getGroups();
    GroupData deletedGroup = before.iterator().next();
    app.contact().deleteFromGroup(contact, deletedGroup);
    Groups after = app.db().contactById(contact.getId()).getGroups();
    assertThat(after, equalTo(before.without(deletedGroup)));

  }
}

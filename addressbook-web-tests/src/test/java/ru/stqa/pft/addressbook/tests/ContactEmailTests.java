package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.junit.MatcherAssert.assertThat;

/**
 * Created by ivan8 on 12.06.2017.
 */
public class ContactEmailTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().homePage();
    if (app.contact().all().size() == 0) {
      app.contact().create(new ContactData().withFirstName("Ivan").withLastName("Krylov").withAddress("г. Москва, 4-й" +
              " Вятский пер., д. 18к2, кв. 74").withGroup("test1")
              .withHomePhone("222").withMobile("111").withWorkPhone("555").withEmail("ivan@me.com").withEmail2
                      ("ivan123@com.ru").withEmail3("ivanivan@ru.com"), true);
    }
  }

  @Test
  public void testEmails() {
    app.goTo().homePage();
    ContactData contact = app.contact().all().iterator().next();
    ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);
    assertThat(contact.getAllEmails(), equalTo(mergeEmails(contactInfoFromEditForm)));
  }

  public static String mergeEmails(ContactData contact) {
    return Arrays.asList(contact.getEmail(), contact.getEmail2(), contact.getEmail3()).stream().filter((s) -> s != null && !s
            .equals("")).collect(Collectors.joining("\n"));
  }
}

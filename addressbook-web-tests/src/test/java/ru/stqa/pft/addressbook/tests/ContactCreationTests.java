package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.junit.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase {

  @DataProvider
  public Iterator<Object[]> validContact() {
    File photo = new File("src/test/resources/stru.png");
    List<Object[]> list = new ArrayList<>();
    list.add(new Object[] {new ContactData().withFirstName("Ivan 1").withLastName("Krylov 1").withAddress("Moscow 1").withGroup("test1").withPhoto(photo)});
    list.add(new Object[] {new ContactData().withFirstName("Ivan 2").withLastName("Krylov 2").withAddress("Moscow 2").withGroup("test1").withPhoto(photo)});
    list.add(new Object[] {new ContactData().withFirstName("Ivan 3").withLastName("Krylov 3").withAddress("Moscow 3").withGroup("test1").withPhoto(photo)});
    return list.iterator();
  }

  @Test(dataProvider = "validContact")
  public void testContactCreation(ContactData contact) {
    app.goTo().homePage();
    Contacts before = app.contact().all();
    app.contact().create((contact), true);
    assertThat(app.contact().count(), equalTo(before.size() + 1));
    Contacts after = app.contact().all();
    assertThat(after, equalTo(before.withAdded(
            contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));
  }

  @Test
  public void testBadContactCreation() {
    app.goTo().homePage();
    Contacts before = app.contact().all();
    ContactData contact = new ContactData().withFirstName("Ivan'").withLastName("Krylov").withGroup("test1");
    app.contact().create((contact), true);
    assertThat(app.contact().count(), equalTo(before.size()));
    Contacts after = app.contact().all();
    assertThat(after, equalTo(before));
  }

  /*Метод описывает поиск абсолютного пути к файлу
  @Test
  public void testCurrentDir() {
    File currentDir = new File(".");
    System.out.println(currentDir.getAbsolutePath());
    File photo = new File("src/test/resources/stru.png");
    System.out.println(photo.getAbsolutePath());
    System.out.println(photo.exists());
  }*/
}

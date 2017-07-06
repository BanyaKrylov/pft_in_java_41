package ru.stqa.pft.mantis.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.mantis.model.MailMessage;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;

import static org.testng.Assert.assertTrue;

/**
 * Created by ivan8 on 06.07.2017.
 */
public class ResetPasswordTests extends TestBase {
  @BeforeMethod
  public void startMailServer() {
    app.mail().start();
  }

  @Test
  public void testResetPassword() throws IOException, MessagingException {
    String username = "user1499329548671";
    app.resetPassword().login("administrator", "root");

    app.resetPassword().selectUser(username);
    app.resetPassword().reset();
    List<MailMessage> mailMessages = app.mail().waitForMail(1, 10000);
    String confirmationLink = findConfirmationLink(mailMessages, "user1499329548671@localhost.localdomain");
    String newPassword = String.valueOf(System.currentTimeMillis());
    app.resetPassword().update(confirmationLink, newPassword);
    assertTrue(app.newSession().login(username, newPassword));
  }

  @AfterMethod(alwaysRun = true)
  public void stopMailServer() {
    app.mail().stop();
  }
}

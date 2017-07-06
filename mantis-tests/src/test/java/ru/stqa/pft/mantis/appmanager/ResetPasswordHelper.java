package ru.stqa.pft.mantis.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by ivan8 on 06.07.2017.
 */
public class ResetPasswordHelper extends HelperBase {

  private ApplicationManager app;
  private WebDriver wd;

  public ResetPasswordHelper(ApplicationManager app) {
    super(app);
    wd = app.getDriver();
  }

  public void login(String username, String password) {
    type(By.name("username"), username);
    type(By.name("password"), password);
    click(By.xpath("//input[@value='Войти']"));
    click(By.linkText("управление"));
    click(By.linkText("Управление пользователями"));
  }

  public void selectUser(String username) {
    click(By.linkText(username));
  }

  public void reset() {
    click(By.xpath("//input[@value='Сбросить пароль']"));

  }

  public void update(String confirmationLink, String password) {
    wd.get(confirmationLink);
    type(By.name("password"), password);
    type(By.name("password_confirm"), password);
    click(By.cssSelector("input[value='Изменить учетную запись']"));
  }
}

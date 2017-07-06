package ru.stqa.pft.mantis.tests;

import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import ru.stqa.pft.mantis.appmanager.ApplicationManager;

import java.io.File;
import java.io.IOException;

/**
 * Created by ivan8 on 21.05.2017.
 */
public class TestBase {

  protected static final ApplicationManager app = new ApplicationManager(System.getProperty("browser", BrowserType.CHROME));

  @BeforeSuite
  public void setUp() throws Exception {
    app.init();
    app.ftp().upload(new File("C:/xampp/htdocs/mantisbt-1.3.11/config/config_inc.php"), "config_inc.php", "config_inc.php.bak");
  }

  @AfterSuite
  public void tearDown() throws IOException {
    app.ftp().restore("config_inc.php.bak", "config_inc.php");
    app.stop();
  }

  /*@Test
  public void testCurrentDir() {
    File currentDir = new File(".");
    System.out.println(currentDir.getAbsolutePath());
    File photo = new File("C:/xampp/htdocs/mantisbt-1.3.11/config/config_inc.php");
    System.out.println(photo.getAbsolutePath());
    System.out.println(photo.exists());
  }*/
}

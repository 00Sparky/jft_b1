package ru.stqa.pft.addressbook;

import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class NewUserCreation {
  private WebDriver wd;


  @BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
    wd = new FirefoxDriver();
    wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    login("admin", "secret");
  }

  @Test
  public void testNewUserCreation() throws Exception {
    goToAddNewUserPage();
    fillNewUserForm(new UserData_Mainpage("Firstname", "Lastname", "Fill address form", "3224441123", "mailname@mail.do"));
    submitNewUserCreation();
    assertNewUserData();
  }

  private void assertNewUserData() {
    assertEquals(wd.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='import'])[1]/following::td[2]")).getText(), "Lastname");
    assertEquals(wd.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Lastname'])[1]/following::td[1]")).getText(), "Firstname");
    assertEquals(wd.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Firstname'])[1]/following::td[1]")).getText(), "Fill address form");
    assertEquals(wd.findElement(By.linkText("mailname@mail.do")).getText(), "mailname@mail.do");
    assertEquals(wd.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='mailname@mail.do'])[1]/following::td[1]")).getText(), "3224441123");
  }

  private void submitNewUserCreation() {
    wd.findElement(By.xpath("(//input[@name='submit'])[2]")).click();
  }

  private void fillNewUserForm(UserData_Mainpage userData_Mainpage) {
    wd.findElement(By.name("firstname")).clear();
    wd.findElement(By.name("firstname")).sendKeys(userData_Mainpage.getNewUserName());
    wd.findElement(By.name("lastname")).clear();
    wd.findElement(By.name("lastname")).sendKeys(userData_Mainpage.getNewUserLastname());
    wd.findElement(By.name("address")).clear();
    wd.findElement(By.name("address")).sendKeys(userData_Mainpage.getNewUserAddress());
    wd.findElement(By.name("mobile")).clear();
    wd.findElement(By.name("mobile")).sendKeys(userData_Mainpage.getNewUserMoblle());
    wd.findElement(By.name("email")).clear();
    wd.findElement(By.name("email")).sendKeys(userData_Mainpage.getNewUserEmail());
  }

  private void goToAddNewUserPage() {
    wd.findElement(By.linkText("add new")).click();
  }

  private void login(String username, String password) {
    wd.get("http://127.0.0.1/addressbook");
    wd.findElement(By.name("user")).clear();
    wd.findElement(By.name("user")).sendKeys(username);
    wd.findElement(By.name("pass")).clear();
    wd.findElement(By.name("pass")).sendKeys(password);
    wd.findElement(By.xpath("//input[@value='Login']")).click();
  }

  @AfterClass(alwaysRun = true)
  public void tearDown() throws Exception {
    wd.quit();
    }


  private boolean isElementPresent(By by) {
    try {
      wd.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      wd.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

}

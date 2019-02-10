package ru.stqa.pft.addressbook.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.appmanager.ApplicationManager;
import ru.stqa.pft.addressbook.appmanager.ContactHelper;
import ru.stqa.pft.addressbook.model.UserData_Mainpage;

public class NewUserCreation extends TestBase {


  @Test
  public void testNewUserCreation() throws Exception {
    app.getNavigationHelper().goToAddNewUserPage();
    app.getContactHelper().fillNewUserForm(new UserData_Mainpage("Firstname", "Lastname", "Fill address form", "3224441123", "mailname@mail.do"));
    app.getContactHelper().submitNewUserCreation();
  }




}

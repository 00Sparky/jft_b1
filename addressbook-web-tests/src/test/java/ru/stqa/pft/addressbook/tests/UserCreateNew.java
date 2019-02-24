package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.UserData_Mainpage;

import java.util.List;

public class UserCreateNew extends TestBase {


  @Test(enabled = false)
  public void testNewUserCreation() throws Exception {
    app.goTo().gotoHomepage();
    List<UserData_Mainpage> before = app.getContactHelper().getContactList();
    app.getContactHelper().goToAddNewUserPage();
    app.getContactHelper().fillUserForm(new UserData_Mainpage("Firstname", "Lastname", "Fill address form", "3224441123", "mailname@mail.do", "test1"), true);
    app.getContactHelper().submitNewUserCreation();
    app.getContactHelper().returnToHomePage();
    List<UserData_Mainpage> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size()+1);
  }

}

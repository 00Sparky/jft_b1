package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.UserData_Mainpage;

public class UserCreateNew extends TestBase {


  @Test
  public void testNewUserCreation() throws Exception {
    app.getNavigationHelper().gotoHomepage();
    app.getNavigationHelper().goToAddNewUserPage();
    app.getContactHelper().fillUserForm(new UserData_Mainpage("Firstname", "Lastname", "Fill address form", "3224441123", "mailname@mail.do"));
    app.getContactHelper().submitNewUserCreation();
  }




}

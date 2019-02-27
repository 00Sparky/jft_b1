package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.UserData_Mainpage;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class UserCreateNew extends TestBase {


  @Test
  public void testNewUserCreation() throws Exception {
    app.goTo().gotoHomepage();
    Contacts before = app.contact().getContactList();
    app.contact().goToAddNewUserPage();
    UserData_Mainpage contact = new UserData_Mainpage()
            .withNewUserName("Firstname")
            .withNewUserLastname("Fluent")
            .withNewUserAddress("Fill address form")
            .withNewUserMoblle("3224441123")
            .withNewUserEmail("mailname@mail.do")
            .withGroup("test1");
    app.contact().fillUserForm(contact, true);
    app.contact().submitNewUserCreation();
    app.contact().returnToHomePage();
    Contacts after = app.contact().getContactList();
    Assert.assertEquals(after.size(), before.size()+1);

    assertThat(after, equalTo(before.withAdded(contact)));
  }

}

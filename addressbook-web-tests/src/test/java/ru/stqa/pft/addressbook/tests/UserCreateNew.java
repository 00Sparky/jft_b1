package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class UserCreateNew extends TestBase {


  @Test
  public void testNewUserCreation() throws Exception {
    app.goTo().gotoHomepage();
    Contacts before = app.contact().all();
    app.contact().goToAddNewUserPage();
    ContactData contact = new ContactData()
            .withNewUserName("Firstname")
            .withNewUserLastname("Fluent")
            .withNewUserAddress("Fill address form")
            .withNewUserMoblle("3224441123")
            .withNewUserEmail1("mailname@mail.do")
            .withGroup("test1");
    app.contact().fillUserForm(contact, true);
    app.contact().submitNewUserCreation();
    app.contact().returnToHomePage();
    Contacts after = app.contact().all();
    Assert.assertEquals(after.size(), before.size()+1);

    assertThat(after, equalTo(before.withAdded(contact)));
  }

}

package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class UserCreateNew extends TestBase {


    @Test
    public void testNewUserCreation() throws Exception {
        app.goTo().gotoHomepage();
        Contacts before = app.contact().all();
        app.contact().goToAddNewUserPage();
        File photo = new File("src/test/resources/file.jpg");
        ContactData contact = new ContactData()
                .withNewUserName("Firstname")
                .withNewUserLastname("Fluent")
                .withNewUserAddress("Fill address form")
                .withNewUserMoblle("3224441123")
                .withNewUserEmail1("mailname@mail.do")
                .withGroup("test1");
        app.contact().createNewContact(contact, true);

        Contacts after = app.contact().all();
        Assert.assertEquals(after.size(), before.size() + 1);
        assertThat(after, equalTo(before.withAdded(contact)));
    }
}

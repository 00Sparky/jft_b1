package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.UserData_Mainpage;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class UserModificationTest extends TestBase {

    @BeforeMethod
    public void Preconditions() {
        app.goTo().gotoHomepage();
        if (!app.contact().isContactExists()) {
            app.contact().createNewContact(new UserData_Mainpage()
                    .withNewUserName("Firstname")
                    .withNewUserLastname("Lastname"), true);
        }
    }

    @Test
    public void testUserModification() {
        app.goTo().gotoHomepage();
        Contacts before = app.contact().getContactList();
        UserData_Mainpage modifiedContact = before.iterator().next();
        UserData_Mainpage contact = new UserData_Mainpage()
                .withId(modifiedContact.getId())
                .withNewUserName("Newname")
                .withNewUserLastname("Modified");
        app.contact().modifyContact(contact, false);
        Contacts after = app.contact().getContactList();
        Assert.assertEquals(after.size(), before.size());
        assertThat(after, equalTo(before
                .without(modifiedContact)
                .withAdded(contact)));
    }
}

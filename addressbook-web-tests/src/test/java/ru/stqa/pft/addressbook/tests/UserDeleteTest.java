package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class UserDeleteTest extends TestBase {

    @BeforeMethod
    public void Preconditions() {
        app.goTo().gotoHomepage();
        if (!app.contact().isContactExists()) {
            app.contact().createNewContact(new ContactData()
                    .withNewUserName("Firstname")
                    .withNewUserLastname("Lastname"), true);
        }
    }

    @Test
    public void testUserDelete() {
        app.goTo().gotoHomepage();
        Contacts before = app.contact().all();
        ContactData deletedContact = before.iterator().next();
        app.contact().deleteContact(deletedContact);
        Contacts after = app.contact().all();

        Assert.assertEquals(after.size(), before.size() - 1);

        assertThat(after, equalTo(before.without(deletedContact)));

    }
}

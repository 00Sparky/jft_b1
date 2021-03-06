package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class UserModificationTest extends TestBase {

    @BeforeMethod
    public void Preconditions() {
        if (app.db().contacts().size() == 0) {
            app.goTo().gotoHomepage();
            app.contact().createNewContact(new ContactData()
                    .withNewUserName("Firstname")
                    .withNewUserLastname("Lastname"), true);
        }
    }


    @Test
    public void testUserModification() {
        app.goTo().gotoHomepage();
        Contacts before = app.db().contacts();
        ContactData modifiedContact = before.iterator().next();
        ContactData contact = new ContactData()
                .withId(modifiedContact.getId())
                .withNewUserName("Newname")
                .withNewUserLastname("Modified");
        app.contact().modifyContact(contact, false);
        Contacts after = app.db().contacts();
        Assert.assertEquals(after.size(), before.size());
        Contacts a=before.without(modifiedContact).withAdded(contact);
        assertThat(after, equalTo(before.without(modifiedContact).withAdded(contact)));

    }


}

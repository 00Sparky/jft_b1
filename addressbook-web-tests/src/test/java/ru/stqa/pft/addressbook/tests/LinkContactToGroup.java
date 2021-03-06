package ru.stqa.pft.addressbook.tests;

import org.hamcrest.MatcherAssert;
import org.hibernate.sql.Select;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.*;


public class LinkContactToGroup extends TestBase {

    @BeforeMethod
    public void contactPreconditions() {
        if (app.db().contacts().size() == 0) {
            app.goTo().gotoHomepage();
            app.contact().createNewContact(new ContactData()
                    .withNewUserName("Firstname")
                    .withNewUserLastname("Lastname"), true);
        }
    }

    @BeforeMethod
    public void groupPreconditions() {
        if (app.db().groups().size() == 0) {
            app.goTo().GroupPage();
            app.group().create(new GroupData().withGroupName("test 1"));
        }
    }

    @Test
    public void testContactLink() {
        app.goTo().gotoHomepage();
        Contacts allContacts = app.db().contacts();
        ContactData contact = allContacts.iterator().next();
        Groups allGroups = app.db().groups();
        GroupData group = allGroups.iterator().next();
        Contacts beforeLink = group.getContacts();
        app.contact().selectContactById(contact.getId());
        app.contact().contactToGroup(group.getGroupName());
        app.contact().returnToHomePage();
        Groups g = app.db().getGroupById(group.getId());
        GroupData gr=g.iterator().next();
        Contacts afterLink = gr.getContacts();
        assertThat(afterLink, equalTo(beforeLink.withAdded(contact)));
    }

    @Test
    public void testContactUnlink() {
        app.goTo().gotoHomepage();
        Groups allGroups = app.db().groups();
       // for (int i=0; i<allGroups.size(); i++){
            GroupData group = allGroups.iterator().next();
            app.contact().selectGroupWithContacts(group.getGroupName());
            Contacts beforeRemove = group.getContacts();
            if (beforeRemove.size() != 0){
                ContactData contact = beforeRemove.iterator().next();
                app.contact().selectContactById(contact.getId());
                app.contact().removeContactFromGroup();
                app.contact().returnToHomePage();
                app.contact().returnToAllGroups();
                Groups g = app.db().getGroupById(group.getId());
                GroupData gr=g.iterator().next();
                Contacts afterRemove = gr.getContacts();
                assertThat(afterRemove, equalTo(beforeRemove.without(contact)));
          //  }
        }

    }
}

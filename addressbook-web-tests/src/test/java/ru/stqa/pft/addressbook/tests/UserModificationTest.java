package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.UserData_Mainpage;

import java.util.HashSet;
import java.util.List;

public class UserModificationTest extends TestBase {

    @Test (enabled = false)
    public void testUserModification(){
        app.getNavigationHelper().gotoHomepage();
        if (! app.getContactHelper().isContactExists()) {
            app.getContactHelper().createNewContact(new UserData_Mainpage("Firstname", "Lastname", "Fill address form", "3224441123", "mailname@mail.do", "test1"), true);
        }
        List<UserData_Mainpage> before = app.getContactHelper().getContactList();
        app.getContactHelper().selectContact(before.size()-1);
        app.getContactHelper().initUserModification();
        UserData_Mainpage contact = new UserData_Mainpage("Firstname-edit", "Lastname", "Fill address form", "3224441123", "mailname@mail.do", null);
        app.getContactHelper().fillUserForm(contact, false);
        app.getContactHelper().submitUserModification();
        app.getContactHelper().returnToHomePage();
        List<UserData_Mainpage> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size());

        before.remove(0);
        before.add(contact);

        //Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
        Assert.assertEquals(before, after);
    }
}

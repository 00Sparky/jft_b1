package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.UserData_Mainpage;

import java.util.List;

public class UserDeleteTest extends TestBase {

    @Test (enabled = false)
    public void testUserDelete(){
        app.getNavigationHelper().gotoHomepage();
        if (! app.getContactHelper().isContactExists()) {
            app.getContactHelper().createNewContact(new UserData_Mainpage("Firstname", "Lastname", "Fill address form", "3224441123", "mailname@mail.do", "test1"), true);
        }
        List<UserData_Mainpage> before = app.getContactHelper().getContactList();
        app.getContactHelper().selectContact(before.size()-1);
        app.getContactHelper().deleteSelectedUsers();
        app.getContactHelper().submitDelete();
        app.getContactHelper().returnToHomePage();
        List<UserData_Mainpage> after = app.getContactHelper().getContactList();

        Assert.assertEquals(after.size(), before.size() - 1);

        before.remove(before.size() - 1);
        Assert.assertEquals(before, after);

    }
}

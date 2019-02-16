package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.UserData_Mainpage;

public class UserDeleteTest extends TestBase {

    @Test
    public void testUserDelete(){
        app.getNavigationHelper().gotoHomepage();
        if (! app.getContactHelper().isContactExists()) {
            app.getContactHelper().createNewContact(new UserData_Mainpage("Firstname", "Lastname", "Fill address form", "3224441123", "mailname@mail.do", "test1"), true);
        }
        app.getContactHelper().selectContact();
        app.getContactHelper().deleteSelectedUsers();
        app.getContactHelper().submitDelete();
    }
}

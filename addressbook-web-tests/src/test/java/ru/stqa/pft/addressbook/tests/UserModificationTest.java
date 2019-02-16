package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.UserData_Mainpage;

public class UserModificationTest extends TestBase {

    @Test
    public void testUserModification(){
        app.getNavigationHelper().gotoHomepage();
        if (! app.getContactHelper().isContactExists()) {
            app.getContactHelper().createNewContact(new UserData_Mainpage("Firstname", "Lastname", "Fill address form", "3224441123", "mailname@mail.do", "test1"), true);
        }
        app.getNavigationHelper().gotoHomepage();
        app.getContactHelper().selectContact();
        app.getContactHelper().initUserModification();
        app.getContactHelper().fillUserForm(new UserData_Mainpage("Firstname-edit", "Lastname", "Fill address form", "3224441123", "mailname@mail.do", null), false);
        app.getContactHelper().submitUserModification();
    }
}

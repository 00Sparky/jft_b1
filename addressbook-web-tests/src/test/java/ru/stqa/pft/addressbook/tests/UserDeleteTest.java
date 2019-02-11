package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

public class UserDeleteTest extends TestBase {

    @Test
    public void testUserDelete(){
        app.getNavigationHelper().gotoHomepage();
        app.getContactHelper().selectContact();
        app.getContactHelper().deleteSelectedUsers();
        app.getContactHelper().submitDelete();
    }
}

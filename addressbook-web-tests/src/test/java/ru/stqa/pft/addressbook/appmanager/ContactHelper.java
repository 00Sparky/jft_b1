package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.stqa.pft.addressbook.model.UserData_Mainpage;

public class ContactHelper extends HelperBase {

    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void fillNewUserForm(UserData_Mainpage userData_Mainpage) {
        type(By.name("firstname"), userData_Mainpage.getNewUserName());
        type(By.name("lastname"), userData_Mainpage.getNewUserLastname() );
        type(By.name("address"), userData_Mainpage.getNewUserAddress());
        type(By.name("mobile"), userData_Mainpage.getNewUserMoblle());
        type(By.name("email"), userData_Mainpage.getNewUserEmail());
    }

    public void submitNewUserCreation() {
        click(By.xpath("(//input[@name='submit'])[2]"));
    }

}

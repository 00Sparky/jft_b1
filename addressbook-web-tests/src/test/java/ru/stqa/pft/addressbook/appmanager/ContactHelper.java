package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.stqa.pft.addressbook.model.UserData_Mainpage;

public class ContactHelper extends HelperBase {

    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void fillUserForm(UserData_Mainpage userData_Mainpage) {
        type(By.name("firstname"), userData_Mainpage.getNewUserName());
        type(By.name("lastname"), userData_Mainpage.getNewUserLastname() );
        type(By.name("address"), userData_Mainpage.getNewUserAddress());
        type(By.name("mobile"), userData_Mainpage.getNewUserMoblle());
        type(By.name("email"), userData_Mainpage.getNewUserEmail());
    }

    public void submitNewUserCreation() {
        click(By.xpath("(//input[@name='submit'])[2]"));
    }

    public void selectContact() {
        click(By.name("selected[]"));
    }

    public void submitUserModification() {
        click(By.name("update"));
    }

    public void initUserModification() {
        click(By.xpath("//img[@alt='Edit']"));
    }

    public void deleteSelectedUsers() {
        click(By.xpath("//input[@value='Delete']"));
    }

    public void submitDelete() {
        wd.switchTo().alert().accept();
    }
}

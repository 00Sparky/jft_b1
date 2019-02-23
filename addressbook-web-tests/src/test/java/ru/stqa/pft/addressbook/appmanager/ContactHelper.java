package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.UserData_Mainpage;

import java.util.ArrayList;
import java.util.List;

public class ContactHelper extends HelperBase {

    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void goToAddNewUserPage() {
        click(By.linkText("add new"));
    }

    public void fillUserForm(UserData_Mainpage userData_Mainpage, boolean creation) {
        type(By.name("firstname"), userData_Mainpage.getNewUserName());
        type(By.name("lastname"), userData_Mainpage.getNewUserLastname());
        type(By.name("address"), userData_Mainpage.getNewUserAddress());
        type(By.name("mobile"), userData_Mainpage.getNewUserMoblle());
        type(By.name("email"), userData_Mainpage.getNewUserEmail());

        if (creation) {
            new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(UserData_Mainpage.getGroup());
        } else {
            Assert.assertFalse(isElementPrestnt(By.name("new_group")));
        }
    }

    public void submitNewUserCreation() {
        click(By.xpath("(//input[@name='submit'])[2]"));
    }

    public void returnToHomePage() {
        click(By.linkText("home"));
    }

    public void selectContact(int index) {
        wd.findElements(By.name("selected[]")).get(index).click();
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

    public void createNewContact(UserData_Mainpage contactData, boolean creation) {
        goToAddNewUserPage();
        fillUserForm(contactData, true);
        submitNewUserCreation();
        returnToHomePage();
    }

    public boolean isContactExists() {
        return isElementPrestnt(By.name("selected[]"));
    }

    public List<UserData_Mainpage> getContactList() {
        List<UserData_Mainpage> contacts = new ArrayList<UserData_Mainpage>();
        List<WebElement> elements = wd.findElements(By.xpath("//table[@id='maintable']/tbody/tr[@name='entry']"));
        for (WebElement element : elements) {
            String first_name = element.findElement(By.xpath("./td[3]")).getText();
            String last_name = element.findElement(By.xpath("./td[2]")).getText() ;
            UserData_Mainpage contact = new UserData_Mainpage(first_name, last_name, null, null, null, null);
            contacts.add(contact);
        }
        return contacts;
    }
}

package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.Contacts;
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

    public void selectContactById(int id) {
        wd.findElement(By.cssSelector("input[value='" + id + "' ]")).click();
        // wd.findElements(By.name("selected[]")).get(index).click();
    }

    public void submitUserModification() {
        click(By.name("update"));
    }

    public void initUserModificationById(int id) {
        click(By.xpath("//a[@href='edit.php?id="+id+"']"));
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

    public void modifyContact(UserData_Mainpage contact, boolean creation) {
        initUserModificationById(contact.getId());
        fillUserForm(contact, false);
        submitUserModification();
        returnToHomePage();
    }

    public void deleteContact(UserData_Mainpage contact) {
        selectContactById(contact.getId());
        deleteSelectedUsers();
        submitDelete();
        returnToHomePage();
    }

    public boolean isContactExists() {
        return isElementPrestnt(By.name("selected[]"));
    }

    public Contacts getContactList() {
        Contacts contacts = new Contacts();
        List<WebElement> elements = wd.findElements(By.xpath("//table[@id='maintable']/tbody/tr[@name='entry']"));
        for (WebElement element : elements) {
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            String first_name = element.findElement(By.xpath("./td[3]")).getText();
            String last_name = element.findElement(By.xpath("./td[2]")).getText();
            contacts.add(new UserData_Mainpage()
                    .withId(id)
                    .withNewUserName(first_name)
                    .withNewUserLastname(last_name));
        }
        return contacts;
    }
}

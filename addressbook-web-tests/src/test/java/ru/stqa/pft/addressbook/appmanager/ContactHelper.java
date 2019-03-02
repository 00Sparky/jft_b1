package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.util.List;

public class ContactHelper extends HelperBase {

    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void goToAddNewUserPage() {
        click(By.linkText("add new"));
    }

    public void fillUserForm(ContactData contactData_, boolean creation) {
        type(By.name("firstname"), contactData_.getNewUserName());
        type(By.name("lastname"), contactData_.getNewUserLastname());
        type(By.name("address"), contactData_.getNewUserAddress());
        type(By.name("mobile"), contactData_.getNewUserMoblle());
        type(By.name("email"), contactData_.getNewUserEmail1());

        if (creation) {
            new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(ContactData.getGroup());
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
        wd.findElement(By.cssSelector(String.format("input[value='%s' ]", id))).click();
        // wd.findElements(By.name("selected[]")).get(index).click();
    }

    public void submitUserModification() {
        click(By.name("update"));
    }

    public void initUserModificationById(int id) {
        click(By.xpath("//a[@href='edit.php?id=" + id + "']"));
    }

    public void deleteSelectedUsers() {
        click(By.xpath("//input[@value='Delete']"));
    }

    public void submitDelete() {
        wd.switchTo().alert().accept();
    }

    public void createNewContact(ContactData contactData, boolean creation) {
        goToAddNewUserPage();
        fillUserForm(contactData, true);
        submitNewUserCreation();
        returnToHomePage();
    }

    public void modifyContact(ContactData contact, boolean creation) {
        initUserModificationById(contact.getId());
        fillUserForm(contact, false);
        submitUserModification();
        returnToHomePage();
    }

    public void deleteContact(ContactData contact) {
        selectContactById(contact.getId());
        deleteSelectedUsers();
        submitDelete();
        returnToHomePage();
    }

    public boolean isContactExists() {
        return isElementPrestnt(By.name("selected[]"));
    }

    public Contacts all() {
        Contacts contacts = new Contacts();
        List<WebElement> rows = wd.findElements(By.name("entry"));
        for (WebElement row : rows) {
            List<WebElement> cells = row.findElements(By.tagName("td"));
            int id = Integer.parseInt(cells.get(0).findElement(By.tagName("input")).getAttribute("value"));
            String first_name = cells.get(1).getText();
            String last_name = cells.get(2).getText();
            String address = cells.get(3).getText();
            String allEmail = cells.get(4).getText();
            String allPhones = cells.get(5).getText();
            contacts.add(new ContactData()
                    .withId(id)
                    .withNewUserName(first_name)
                    .withNewUserLastname(last_name)
                    .withNewUserAddress(address)
                    .withAllEmail(allEmail)
                    .withAllPhones(allPhones));
        }
        return contacts;
    }

    public ContactData infoFromEditForm(ContactData contact) {
        initUserModificationById(contact.getId());
        String firstname = wd.findElement(By.name("firstname")).getAttribute("value");
        String lastname = wd.findElement(By.name("lastname")).getAttribute("value");
        String email1 = wd.findElement(By.name("email")).getAttribute("value");
        String email2 = wd.findElement(By.name("email2")).getAttribute("value");
        String email3 = wd.findElement(By.name("email3")).getAttribute("value");
        String home = wd.findElement(By.name("home")).getAttribute("value");
        String moblle = wd.findElement(By.name("mobile")).getAttribute("value");
        String work = wd.findElement(By.name("work")).getAttribute("value");
        String address = wd.findElement(By.name("address")).getText();
        return new ContactData().withId(contact.getId())
                .withNewUserName(firstname)
                .withNewUserLastname(lastname)
                .withNewUserEmail1(email1)
                .withNewUserEmail2(email2)
                .withNewUserEmail3(email3)
                .withNewUserHomephone(home)
                .withNewUserMoblle(moblle)
                .withNewUserWorkphone(work)
                .withNewUserAddress(address);
    }
}

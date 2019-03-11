package ru.stqa.pft.mantis.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ManageUserHelper extends HelperBase {


    public ManageUserHelper(ApplicationManager app) {
        super(app);
    }

    public void gotoManageUsersPage() {
        if (isElementPrestnt(By.cssSelector("td.form-title"))){
            return;
        } else
        click(By.linkText("Manage Users "));
    }

    public void selectUser(By locator){
        click(locator);
    }

    public void resetPassword() {
        click(By.cssSelector("form > input.button"));
    }
}

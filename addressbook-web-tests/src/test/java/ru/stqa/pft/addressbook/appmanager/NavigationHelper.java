package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationHelper extends HelperBase {


    public NavigationHelper(WebDriver wd) {
        super(wd);
    }

    public void gotoGroupPage() {
        if (isElementPrestnt(By.tagName("h1"))
                && wd.findElement(By.tagName("h1")).getText().equals("Groups")
                && isElementPrestnt(By.name("new"))) {
            return;
        } else
        click(By.linkText("groups"));
    }



    public void gotoHomepage() {
        if (isElementPrestnt(By.id("maintable"))){
            return;
        } else
        click(By.linkText("home"));
    }
}

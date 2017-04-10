package ru.stqa.training.selenium.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by luk on 2017-04-10.
 */
public class NavigationHelper {
   private WebDriver chDriver;

    public NavigationHelper(WebDriver chDriver) {
        this.chDriver=chDriver;
    }

    public void gotoMainPage() {
        chDriver.findElement(By.cssSelector("#logotype-wrapper a")).click();
    }
}

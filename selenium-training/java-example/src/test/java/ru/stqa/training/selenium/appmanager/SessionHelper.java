package ru.stqa.training.selenium.appmanager;

import org.openqa.selenium.WebDriver;

/**
 * Created by luk on 2017-04-10.
 */
public class SessionHelper {
    private WebDriver chDriver;

    public SessionHelper(WebDriver chDriver) {
        this.chDriver = chDriver;
        chDriver.navigate().to("http://localhost/litecart");
    }
}

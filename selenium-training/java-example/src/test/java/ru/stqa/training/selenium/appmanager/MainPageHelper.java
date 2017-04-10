package ru.stqa.training.selenium.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by luk on 2017-04-10.
 */
public class MainPageHelper {
    protected WebDriver chDriver;

    public MainPageHelper(WebDriver chDriver) {
        this.chDriver=chDriver;
    }

    public void chooseThirdProduct() {
        chDriver.findElement(By.cssSelector("#box-latest-products li:nth-child(3) img[class=image]")).click();
    }

    public void chooseSecondProduct() {
        chDriver.findElement(By.cssSelector("#box-latest-products li:nth-child(2) img[class=image]")).click();
    }

    public void chooseFirstProduct() {
        chDriver.findElement(By.cssSelector("#box-latest-products li:nth-child(1) img[class=image]")).click();
    }
}

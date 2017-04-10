package ru.stqa.training.selenium.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.stalenessOf;

/**
 * Created by luk on 2017-04-10.
 */
public class CartPageHelper {
    private WebElement table;
    private WebDriver chDriver;
    protected WebDriverWait wait;

    public CartPageHelper(WebDriver chDriver) {
        this.chDriver = chDriver;
    }

    public void waitForChangeOfTableProduct() {
        wait.until(stalenessOf(table));
    }

    public void getTableOfProduct() {
        table = chDriver.findElement(By.cssSelector("#order_confirmation-wrapper"));
    }

    public void deleteFromCart() {
        chDriver.findElement(By.cssSelector("button[name=remove_cart_item]")).click();
    }

    public void checkToRemoveProduct() {
        chDriver.findElement(By.cssSelector("div#cart a.content")).click();
    }
}

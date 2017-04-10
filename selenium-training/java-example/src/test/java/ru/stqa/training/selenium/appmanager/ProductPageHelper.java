package ru.stqa.training.selenium.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by luk on 2017-04-10.
 */
public class ProductPageHelper {
    private WebDriver chDriver;
    protected WebDriverWait wait;
    private String element;

    public ProductPageHelper(WebDriver chDriver) {
        this.chDriver = chDriver;
    }

    public void waitForChangeCartStatus() {
        wait.until(ExpectedConditions.invisibilityOfElementWithText((By.cssSelector("span.quantity")), element));
    }

    public void getCurrentCartStatus() {
        element = chDriver.findElement(By.cssSelector("span.quantity")).getAttribute("textContent");
    }

    public void addToCart() {
        //some products have size to choose
        if (isElementPresent(chDriver, By.cssSelector("select[name='options[Size]']"))) {
            new Select(chDriver.findElement(By.cssSelector("select[name='options[Size]']"))).selectByIndex(1);
            chDriver.findElement(By.cssSelector("button[name=add_cart_product]")).click();
        } else {
            chDriver.findElement(By.cssSelector("button[name=add_cart_product]")).click();
        }

    }

    public boolean isElementPresent(WebDriver driver, By locator) {
        try {
            driver.findElement(locator);
            return true;
        } catch (NoSuchElementException ex) {
            return false;
        }

    }
}



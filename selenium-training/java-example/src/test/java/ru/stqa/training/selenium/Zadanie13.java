package ru.stqa.training.selenium;

/**
 * Created by luk on 2017-03-19.
 */
import org.junit.Before;
import org.junit.Test;
import org.junit.After;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import static org.openqa.selenium.support.ui.ExpectedConditions.stalenessOf;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;


public class Zadanie13 {
    private WebDriver chDriver;
    private  WebDriverWait wait;
    private String element;
    private WebElement table;

    @Before
    public void before(){
        chDriver = new ChromeDriver();
        chDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        wait = new WebDriverWait(chDriver,5);
    }
    @Test
    public void test(){
        chDriver.navigate().to("http://localhost/litecart");

        chDriver.findElement(By.cssSelector("#box-latest-products li:nth-child(1) img[class=image]")).click();
        element= chDriver.findElement(By.cssSelector("span.quantity")).getAttribute("textContent");
        chDriver.findElement(By.cssSelector("button[name=add_cart_product]")).click();
        wait.until(ExpectedConditions.invisibilityOfElementWithText((By.cssSelector("span.quantity")),element));
       //waiting for refresh the number of items in upper right side
        chDriver.findElement(By.cssSelector("#logotype-wrapper a")).click();

        chDriver.findElement(By.cssSelector("#box-latest-products li:nth-child(2) img[class=image]")).click();
        element= chDriver.findElement(By.cssSelector("span.quantity")).getAttribute("textContent");
        chDriver.findElement(By.cssSelector("button[name=add_cart_product]")).click();
        wait.until(ExpectedConditions.invisibilityOfElementWithText((By.cssSelector("span.quantity")),element));
        chDriver.findElement(By.cssSelector("#logotype-wrapper a")).click();

        chDriver.findElement(By.cssSelector("#box-latest-products li:nth-child(3) img[class=image]")).click();
        element= chDriver.findElement(By.cssSelector("span.quantity")).getAttribute("textContent");
        chDriver.findElement(By.cssSelector("button[name=add_cart_product]")).click();
        wait.until(ExpectedConditions.invisibilityOfElementWithText((By.cssSelector("span.quantity")),element));
        chDriver.findElement(By.cssSelector("#logotype-wrapper a")).click();

        chDriver.findElement(By.cssSelector("div#cart a.content")).click();

        table = chDriver.findElement(By.cssSelector("#order_confirmation-wrapper"));
        chDriver.findElement(By.cssSelector("button[name=remove_cart_item]")).click();
        wait.until(stalenessOf(table));
        //waiting to refresh the table with items on the lower side

        table = chDriver.findElement(By.cssSelector("#order_confirmation-wrapper"));
        chDriver.findElement(By.cssSelector("button[name=remove_cart_item]")).click();
        wait.until(stalenessOf(table));

        table = chDriver.findElement(By.cssSelector("#order_confirmation-wrapper"));
        chDriver.findElement(By.cssSelector("button[name=remove_cart_item]")).click();
        wait.until(stalenessOf(table));

    }

    @After
    public void after(){
        chDriver.quit();
        chDriver=null;
    }

}

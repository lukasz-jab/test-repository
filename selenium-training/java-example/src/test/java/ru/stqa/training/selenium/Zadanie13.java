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

        chDriver.navigate().to("http://localhost/litecart");
    }
    @Test
    public void test(){


        chooseFirstProduct();
        getCurrentCartStatus();
        addToCart();
        waitForChangeCartStatus();
        gotoMainPage();

        chooseSecondProduct();
        getCurrentCartStatus();
        addToCart();
        waitForChangeCartStatus();
        gotoMainPage();

        chooseThirdProduct();
        getCurrentCartStatus();
        addToCart();
        waitForChangeCartStatus();
        gotoMainPage();

        checkToRemoveProduct();
        getTableOfProduct();
        deleteFromCart();
        waitForChangeOfTableProduct();

        getTableOfProduct();
        deleteFromCart();
        waitForChangeOfTableProduct();

        getTableOfProduct();
        deleteFromCart();
        waitForChangeOfTableProduct();


    }

    private void waitForChangeOfTableProduct() {
        wait.until(stalenessOf(table));
    }

    private void getTableOfProduct() {
        table = chDriver.findElement(By.cssSelector("#order_confirmation-wrapper"));
    }

    private void waitForChangeCartStatus() {
        wait.until(ExpectedConditions.invisibilityOfElementWithText((By.cssSelector("span.quantity")),element));
    }

    private void getCurrentCartStatus() {
        element= chDriver.findElement(By.cssSelector("span.quantity")).getAttribute("textContent");
    }

    private void deleteFromCart() {
        chDriver.findElement(By.cssSelector("button[name=remove_cart_item]")).click();
    }

    private void checkToRemoveProduct() {
        chDriver.findElement(By.cssSelector("div#cart a.content")).click();
    }

    private void chooseThirdProduct() {
        chDriver.findElement(By.cssSelector("#box-latest-products li:nth-child(4) img[class=image]")).click();
    }

    private void chooseSecondProduct() {
        chDriver.findElement(By.cssSelector("#box-latest-products li:nth-child(3) img[class=image]")).click();
    }

    private void gotoMainPage() {
        chDriver.findElement(By.cssSelector("#logotype-wrapper a")).click();
    }

    private void addToCart() {
        chDriver.findElement(By.cssSelector("button[name=add_cart_product]")).click();
    }

    private void chooseFirstProduct() {
        chDriver.findElement(By.cssSelector("#box-latest-products li:nth-child(2) img[class=image]")).click();
    }

    @After
    public void after(){
        chDriver.quit();
        chDriver=null;
    }

}
package ru.stqa.training.selenium;

/**
 * Created by luk on 2017-03-16.
 */
import org.junit.Before;
import org.junit.Test;
import org.junit.After;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.Keys;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;


public class Zadanie12 {

    private WebDriver chDriver;

    @Before
    public void befor(){
        chDriver=new ChromeDriver();
        chDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    public void test(){
        chDriver.navigate().to("http://localhost/litecart/admin");
        chDriver.findElement(By.cssSelector("div.content input[name=username]")).sendKeys("admin");
        chDriver.findElement(By.cssSelector("div.content input[name=password]")).sendKeys("admin");
        chDriver.findElement(By.cssSelector("div#box-login button[name=login]")).click();
        chDriver.findElement(By.linkText("Catalog")).click();
        List<WebElement>numOfDucks1=chDriver.findElements(By.cssSelector(".dataTable a"));
        System.out.println(numOfDucks1.size());
        //checking numbers of the ducks before added
        chDriver.findElement(By.xpath("//td[@id='content']/div[1]/a[2]")).click();
        chDriver.findElement(By.cssSelector("input[name=status]")).click();
        chDriver.findElement(By.cssSelector("input[name='name[en]']")).sendKeys("SuperDuck");
        chDriver.findElement(By.cssSelector("#tab-general > table > tbody > tr:nth-child(4) > td > div > table > tbody > tr:nth-child(2) > td:nth-child(1) > input[type='checkbox']")).click();
        WebElement category=chDriver.findElement(By.cssSelector("select[name='default_category_id']"));
        new Select(category).selectByValue("1");
        chDriver.findElement(By.cssSelector("input[name='product_groups[]']:nth-child(1)")).click();
        chDriver.findElement(By.cssSelector("#tab-general > table > tbody > tr:nth-child(7) > td > div > table > tbody > tr:nth-child(3) > td:nth-child(1) > input[type=checkbox]")).click();
        chDriver.findElement(By.cssSelector("input[name=quantity]")).clear();
        chDriver.findElement(By.cssSelector("input[name=quantity]")).sendKeys("3");
        chDriver.findElement(By.cssSelector("input[name=date_valid_from]")).sendKeys("2017"+ Keys.TAB+"03"+"16");
        chDriver.findElement(By.cssSelector("input[name=date_valid_to]")).sendKeys("2019"+ Keys.TAB+"03"+"16");
        chDriver.findElement(By.linkText("Information")).click();
        WebElement Manufacturer=chDriver.findElement(By.cssSelector("select[name='manufacturer_id']"));
        new Select(Manufacturer).selectByValue("1");
        chDriver.findElement(By.cssSelector("input[name='short_description[en]']")).sendKeys("suuuper duck");
        chDriver.findElement(By.cssSelector(".trumbowyg-editor")).sendKeys(" very suuuper duck");
        chDriver.findElement(By.cssSelector("input[name='head_title[en]']")).sendKeys("suuuper duck");
        chDriver.findElement(By.linkText("Prices")).click();
        chDriver.findElement(By.cssSelector("input[name='purchase_price']")).clear();
        chDriver.findElement(By.cssSelector("input[name='purchase_price']")).sendKeys("99,99");
        WebElement Euro=chDriver.findElement(By.cssSelector("select[name='purchase_price_currency_code']"));
        new Select(Euro).selectByValue("EUR");
        chDriver.findElement(By.cssSelector("input[name='prices[EUR]']")).sendKeys("199,99");
        chDriver.findElement(By.cssSelector("button[name=save]")).click();
        //chDriver.findElement(By.linkText("Catalog")).click();
        List<WebElement>numOfDucks2=chDriver.findElements(By.cssSelector(".dataTable a"));
        System.out.println(numOfDucks2.size());
        //checking numbers of the ducks after added
        assertTrue(numOfDucks2.size()>numOfDucks1.size());

    }

    @After
    public void after() {
        chDriver.quit();
        chDriver = null;
    }


}

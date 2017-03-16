package ru.stqa.training.selenium;

/**
 * Created by luk on 2017-03-15.
 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import org.junit.Before;
import org.junit.Test;
import org.junit.After;

import java.util.concurrent.TimeUnit;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.support.ui.Select;
//for email address


public class Zadanie11 {

    private WebDriver chDriver;

    @Before
    public void before(){
        chDriver=new ChromeDriver();
        chDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        }

        @Test
        public void test(){
           chDriver.navigate().to("http://localhost/litecart/");
           chDriver.findElement(By.xpath("//div[@class='left']//form[@name='login_form']//a")).click();
           chDriver.findElement(By.cssSelector("form[name=customer_form] input[name=firstname]")).sendKeys("luk");
           chDriver.findElement(By.cssSelector("form[name=customer_form] input[name=lastname]")).sendKeys("kul");
           chDriver.findElement(By.cssSelector("form[name=customer_form] input[name=address1]")).sendKeys("Olesz111");
           chDriver.findElement(By.cssSelector("form[name=customer_form] input[name=postcode]")).sendKeys("37-630");
           chDriver.findElement(By.cssSelector("form[name=customer_form] input[name=city]")).sendKeys("Oleszyce");
           chDriver.findElement(By.cssSelector("form[name=customer_form] input[name=email]")).sendKeys(RandomStringUtils.randomAlphanumeric(5)+"1@localhost");
           chDriver.findElement(By.cssSelector("form[name=customer_form] input[name=phone]")).sendKeys("7777777");
           chDriver.findElement(By.cssSelector("form[name=customer_form] input[name=password]")).sendKeys("password");
           WebElement email=chDriver.findElement(By.cssSelector("form[name=customer_form] input[name=email]"));
           String EMAIL_TO_LOGIN=email.getAttribute("value");
           chDriver.findElement(By.cssSelector("form[name=customer_form] input[name=confirmed_password]")).sendKeys("password");
           WebElement country=chDriver.findElement(By.cssSelector("form[name=customer_form] select[name=country_code]"));
           new Select(country).selectByVisibleText("Poland");
           chDriver.findElement(By.cssSelector("button[name=create_account]")).click();
           chDriver.findElement(By.linkText("Logout")).click();
           chDriver.findElement(By.cssSelector("form[name=login_form] input[name=email]")).sendKeys(EMAIL_TO_LOGIN);
           chDriver.findElement(By.cssSelector("form[name=login_form] input[name=password]")).sendKeys("password");
           chDriver.findElement(By.cssSelector("form[name=login_form] button[name=login]")).click();
           chDriver.findElement(By.linkText("Logout")).click();




        }
    @After
    public void after(){
            chDriver.quit();
            chDriver=null;
     }

}

package ru.stqa.training.selenium;

import com.google.common.io.Files;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by luk on 2017-04-03.
 */
public class Zadanie17 {

    public static class MyListener extends AbstractWebDriverEventListener {
        @Override
        public void beforeFindBy(By by, WebElement element, WebDriver driver) {
            System.out.println(by);
        }

        @Override
        public void afterFindBy(By by, WebElement element, WebDriver driver) {
            System.out.println(by + " found");
        }

        @Override
        public void onException(Throwable throwable, WebDriver driver) {
            System.out.println(throwable);
            File tmp = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE );
            File screen = new File("C:\\Users\\luk\\Desktop\\screen\\screen-"+System.currentTimeMillis()+".png");
            try {
                Files.copy(tmp,screen);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    private EventFiringWebDriver driver;


    @Before
    public void before() {
        driver = new EventFiringWebDriver(new ChromeDriver());
        driver.register(new MyListener());
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    public void test() {
        driver.navigate().to("http://localhost/litecart/admin/");
        driver.findElement(By.cssSelector("div.content input[name=xusername]")).sendKeys("admin");
        driver.findElement(By.cssSelector("div.content input[name=password]")).sendKeys("admin");
        driver.findElement(By.cssSelector("#box-login-wrapper button[name=login]")).click();

        driver.findElement(By.xpath("//ul[@id='box-apps-menu']//span[contains(text(),'Catalog')]")).click();
        driver.findElement(By.xpath("//table[@class='dataTable']//a[contains(text(),'Rubber Ducks')]")).click();

        List<WebElement> listOfProduct = driver.findElements(By.xpath("//table[@class='dataTable']//a[contains(text(),'Duck')]"));
        String[] hrefOfProduct = new String[listOfProduct.size()];
        for (int i = 0; i < listOfProduct.size(); i++) {
            hrefOfProduct[i] = listOfProduct.get(i).getAttribute("href");

        }
        for (int j = 0; j < hrefOfProduct.length; j++) {
            driver.navigate().to(hrefOfProduct[j]);
            driver.manage().logs().get("browser").forEach(l -> System.out.println(l));
        }

    }

    @After
    public void after() {
        driver.quit();
        driver = null;
    }

}

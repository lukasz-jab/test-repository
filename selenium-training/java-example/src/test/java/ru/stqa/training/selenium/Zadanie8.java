package ru.stqa.training.selenium;

/**
 * Created by luk on 2017-03-05.
 */
import org.junit.After;
import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Zadanie8 {

    private WebDriver chDriver;

    @Before
    public void before(){
        chDriver = new ChromeDriver();
        chDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }
    @Test
    public void test() {
        chDriver.navigate().to("http://localhost/litecart");
        List<WebElement> ducks = chDriver.findElements(By.xpath("//li[starts-with(@class,'product column shadow hover-light')]"));
        //list of the image
        List<WebElement> sticker;// = chDriver.findElements(By.xpath("//div[starts-with(@class,'sticker')]"));
        //list of the sticker

        for(WebElement e: ducks){
           sticker=e.findElements(By.xpath(".//div[starts-with(@class,'sticker')]"));
                                             //(.dot)-count stickers for each duck
         assertTrue(sticker.size()==1);

        }


        sticker = chDriver.findElements(By.xpath("//div[starts-with(@class,'sticker')]"));
        System.out.println("the count of all stickers: "+sticker.size());
        System.out.println("the count of all ducks: "+ducks.size());
    }
    @After
    public void stop(){
        chDriver.quit();
        chDriver=null;
    }

}

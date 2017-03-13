package ru.stqa.training.selenium;

/**
 * Created by luk on 2017-03-07.
 */
import org.junit.Before;
import org.junit.Test;
import org.junit.After;
import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;



public class Zadanie10 {

    private WebDriver chDriver;

    @Before
    public void Before() {
        chDriver = new ChromeDriver();
        chDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @Test
    public void test() {
        chDriver.navigate().to("http://127.0.0.1/litecart/");
        String yDuckGrayPrice = chDriver
        .findElement(By.xpath("//div[@id='box-campaigns']//a[@title='Yellow Duck']//s[@class='regular-price']"))
        .getAttribute("textContent");
        //choosing the grey price of yellow duck from campaigne "main site"

        String yDuckRedPrice = chDriver
        .findElement(By.xpath("//div[@id='box-campaigns']//a[@title='Yellow Duck']//strong[@class='campaign-price']"))
        .getAttribute("textContent");
        //choosing the red price of yellow duck from campaigne "main site"

        String cssValue_yDuckGreyPrice=chDriver
                .findElement(By.xpath("//div[@id='box-campaigns']//a[@title='Yellow Duck']//s[@class='regular-price']"))
                .getAttribute("class");
        String cssValue_color_yDuckRedPrice=chDriver
                .findElement(By.xpath("//div[@id='box-campaigns']//a[@title='Yellow Duck']//strong[@class='campaign-price']"))
                .getCssValue("color");




        chDriver.findElement(By.xpath("//div[@id='box-campaigns']//a[@title='Yellow Duck']")).click();

        String yDuckGrayPrice2=chDriver
        .findElement(By.xpath("//div[@class='information']//div[@class='price-wrapper']//s[@class='regular-price']"))
        .getAttribute("textContent");
        //choosing the grey price of yellow duck from "duck site"

        String yDuckRedPrice2=chDriver
        .findElement(By.xpath("//div[@class='information']//div[@class='price-wrapper']//strong[@class='campaign-price']"))
        .getAttribute("textContent");
         //choosing the red price of yellow duck from "duck site"

        String cssValue_yDuckGreyPrice2=chDriver
                .findElement(By.xpath("//div[@class='information']//div[@class='price-wrapper']//s[@class='regular-price']"))
                .getAttribute("class");
        String cssValue_color_yDuckRedPrice2=chDriver
                .findElement(By.xpath("//div[@class='information']//div[@class='price-wrapper']//strong[@class='campaign-price']"))
                .getCssValue("color");

         boolean redPrice = yDuckRedPrice.equals(yDuckRedPrice2);
         assertTrue(redPrice);
         //comparing red price

         boolean greyPrice = yDuckGrayPrice.equals(yDuckGrayPrice2);
         assertTrue(greyPrice);
         //comparing gray price

        boolean cssValue_gray=cssValue_yDuckGreyPrice.equals(cssValue_yDuckGreyPrice2);
        assertTrue(cssValue_gray);
        //comparing gray prices by method "class"

        boolean cssValue_red=cssValue_color_yDuckRedPrice.equals(cssValue_color_yDuckRedPrice2);
        assertTrue(cssValue_red);
        //comparing gray prices by method "cssValue color"




    }
    @After
    public void after(){
        chDriver.quit();
        chDriver=null;
    }

}




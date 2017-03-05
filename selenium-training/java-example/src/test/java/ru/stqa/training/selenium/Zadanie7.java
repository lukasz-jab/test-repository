package ru.stqa.training.selenium;

/**
 * Created by luk on 2017-03-04.
 */
import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import static org.openqa.selenium.By.tagName;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Zadanie7 {

    private boolean isElementPresent(WebDriver driver, By locator) {
        try{
            driver.findElement(locator);
            return true;
        }catch (NoSuchElementException ex){
            return false;
        }
    }


    private WebDriver chDriver;

    @Before
    public void before(){
        chDriver = new ChromeDriver();
        chDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }
    @Test
    public void test(){
          chDriver.navigate().to("http://localhost/litecart/admin");
          chDriver.findElement(By.xpath("//*[contains(@class,'content')]//input[@name='username']")).sendKeys("admin");
          chDriver.findElement(By.xpath("//*[contains(@class,'content')]//input[@name='password']")).sendKeys("admin");
          chDriver.findElement(By.xpath("//*[contains(@class,'content')]//button[@name='login']")).click();
          List<WebElement>listaOfa = chDriver.findElements(By.xpath("//div[@id='box-apps-menu-wrapper']//a"));
          // list of elements of main menu
          List<WebElement> listaOfsuba;
          //will be list of element of sub menu
           System.out.println(listaOfa.size());
           String[]links = new String[listaOfa.size()];
           int i =0;
           for(WebElement e: listaOfa){
               links[i]=e.getAttribute("href");
               i++;
            //read all element to string list of href (to eliminate:StaleElementException)
           }
           for(int j=0;j<links.length;j++){
               //System.out.println("main link: "+links[j]);
           }
           for(int k=0;k<links.length;k++){
               chDriver.navigate().to(links[k]);
               //going to each element in main menu
               assertTrue(isElementPresent(chDriver,tagName("h1")));
                //checking title
               listaOfsuba = chDriver.findElements(By.xpath("//ul[@class='docs']//a"));
                //checking the elements in sub menu:
                    if (listaOfsuba.size()>0){
                        String[]sublinks = new String[listaOfsuba.size()];
                        int l=0;
                     for(WebElement e2: listaOfsuba) {
                         sublinks[l] = e2.getAttribute("href");
                         System.out.println("sublink: " + sublinks[l]);
                         l++;
                     }
                         for(int y=0;y<sublinks.length;y++) {
                             chDriver.navigate().to(sublinks[y]);
                             assertTrue(isElementPresent(chDriver,tagName("h1")));

                         }





               }
           }




    }


}








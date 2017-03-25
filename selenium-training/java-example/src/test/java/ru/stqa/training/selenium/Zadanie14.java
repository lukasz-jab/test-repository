package ru.stqa.training.selenium;

/**
 * Created by luk on 2017-03-25.
 */
import org.junit.Before;
import org.junit.Test;
import org.junit.After;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;


public class Zadanie14 {

    private WebDriver chDriver;
    private WebDriverWait wait;
    private Set<String> existingWindows;


    @Before
    public void before(){
        chDriver=new ChromeDriver();
        chDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        wait = new WebDriverWait(chDriver,5);


    }

    @Test
    public void test(){
        chDriver.navigate().to("http://localhost/litecart/admin/");
        chDriver.findElement(By.cssSelector("div.content input[name=username]")).sendKeys("admin");
        chDriver.findElement(By.cssSelector("div.content input[name=password]")).sendKeys("admin");
        chDriver.findElement(By.cssSelector("#box-login-wrapper button[name=login]")).click();

        chDriver.findElement(By.xpath("//div[@id='box-apps-menu-wrapper']//a//span[contains(text(),'Countries')]")).click();
        List<WebElement> nameCountries = chDriver.findElements(By.xpath("//table[@class='dataTable']//td[5]/a"));
         //links with the names of countries

           String[]linksOfCountries=new String[nameCountries.size()];
           int i=0;
           for(WebElement e:nameCountries) {
               linksOfCountries[i] = e.getAttribute("href");
               i++;
           }
           //getting href's for all countries to click in all automatically

        for(int y=0;y<linksOfCountries.length;y++){
               chDriver.navigate().to(linksOfCountries[y]);
               List<WebElement>extLinks=chDriver.findElements(By.xpath("//i[@class='fa fa-external-link']"));
               //list with all black arrows in each country site
               System.out.println(linksOfCountries[y]);
               String mainWindow=chDriver.getWindowHandle();
               //each country main site handle
               int el=0;
               for(WebElement ext:extLinks){
                   extLinks.get(el).click();
                   wait.withTimeout(5,TimeUnit.SECONDS);
                   el++;
               }
               existingWindows=chDriver.getWindowHandles();
               for(String w:existingWindows){
                   chDriver.switchTo().window(w);
                   if(!(w.equals(mainWindow))) {
                       //to don't quit driver
                       chDriver.close();
                   }
                   chDriver.switchTo().window(mainWindow);

               }


        }






    }
    @After
    public void after(){
        chDriver.quit();
        chDriver=null;
    }




}

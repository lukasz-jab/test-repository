package ru.stqa.training.selenium;

/**
 * Created by luk on 2017-03-07.
 */
import com.google.common.collect.Ordering;
//to checking is list is in alphabetical order

import org.junit.After;
import org.junit.Test;
import org.junit.Before;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;



public class Zadanie9 {

    private WebDriver chDriver;

    @Before
    public void before() {
        chDriver = new ChromeDriver();
        chDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @Test
    public void test() {
        chDriver.navigate().to("http://localhost/litecart/admin");
        chDriver.findElement(By.xpath("//div[@class='content']//input[@name='username']")).sendKeys("admin");
        chDriver.findElement(By.xpath("//div[@class='content']//input[@name='password']")).sendKeys("admin");
        chDriver.findElement(By.xpath("//*[contains(@class,'content')]//button[@name='login']")).click();

        //zadanie 9 pkt 1a:
        chDriver.navigate().to("http://localhost/litecart/admin/?app=countries&doc=countries");
        List<WebElement> listOfLinkCountries = chDriver.findElements(By.xpath("//form[@name='countries_form']//td[5]//a"));
        ArrayList<String> listNameCountries = new ArrayList<String>();
       ArrayList<String> listOfLinksZones = new ArrayList<String>();
        //will be used to click if zones !=0


        List<WebElement> zones = chDriver.findElements(By.xpath("//tr[@class='row']//td[6]"));
        //list of zones
        int[] zonesNr = new int[listOfLinkCountries.size()];
        int z = 0;
        for (WebElement e1 : zones) {
            zonesNr[z] = Integer.parseInt(e1.getAttribute("textContent"));
            //string number of zone to integer to eliminate country with 0 zone
            z++;
        }


        int i = 0;
        for (WebElement e : listOfLinkCountries) {
              listNameCountries.add(i, e.getAttribute("textContent"));
              //list of names countries
            //System.out.println(listNameCountries.get(i));
            //to check is function isOrdered checking right things
             if(zonesNr[i]!=0){
                 listOfLinksZones.add(e.getAttribute("href"));
                 //list of countries with zones

               }


            i++;
        }


            boolean isSorted = Ordering.natural().isOrdered(listNameCountries);
            //function from google guava com.google.common.collect.Ordering;
            assertTrue("Main Countries are sorted",isSorted);
            //zadanie 9a

         //zadanie 9 pkt 1b:
        for(int k=0;k<listOfLinksZones.size();k++){
            chDriver.navigate().to(listOfLinksZones.get(k));
            ArrayList<String>subZonesName=new ArrayList<String>();
            //list of names zones after opening country site
            List<WebElement>subZones=chDriver.findElements(By.xpath("//table[@id='table-zones']//input[contains(@name,'name')]"));
            int y=0;
            for(WebElement s:subZones){
                subZonesName.add(y,s.getAttribute("textContent"));
                //System.out.println(subZonesName.get(y));
                //to check is function isOrdered checking right things
                y++;
                boolean isSortedZone = Ordering.natural().isOrdered(listNameCountries);
                //function from google guava com.google.common.collect.Ordering;
                assertTrue(isSortedZone);
                //zadanie 9b
            }
        }


        //zadanie 9 pkt 2:
        chDriver.navigate().to(" http://localhost/litecart/admin/?app=geo_zones&doc=geo_zones");
        List<WebElement>geoZonesCountry=chDriver.findElements(By.xpath("//form[@name='geo_zones_form']//td[3]/a"));
        //links to countries in geo zones
        String[]geoCountryName=new String[geoZonesCountry.size()];
        int gg=0;
        for(WebElement g:geoZonesCountry){
            geoCountryName[gg]=g.getAttribute("href");
            gg++;
        }
        for(int q=0;q<geoCountryName.length;q++){
            chDriver.navigate().to(geoCountryName[q]);
            List<WebElement>geoSubZones=chDriver.findElements(By.xpath("//td[3]/select[contains(@name,'zones')]"));
            ArrayList<String>geoSubZonesName=new ArrayList<String>();
            //names of geo zones
            int r=0;
            for(WebElement w:geoSubZones){
                geoSubZonesName.add(r,w.getAttribute("textContent"));
                //System.out.println(geoSubZonesName.get(r));
                //to check is function isOrdered checking right things
                r++;
            }
            boolean isSortedGeoZones=Ordering.natural().isOrdered(geoSubZonesName);
            assertTrue(isSortedGeoZones);

        }

    }


    @After
    public void after(){
        chDriver.quit();
        chDriver=null;

    }
}

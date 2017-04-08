package ru.stqa.training.selenium;

import net.lightbody.bmp.BrowserMobProxy;
import net.lightbody.bmp.BrowserMobProxyServer;
import net.lightbody.bmp.client.ClientUtil;
import net.lightbody.bmp.core.har.Har;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * Created by luk on 2017-04-08.
 */
public class Proxy {

    public BrowserMobProxy proxy;
    private  WebDriver driver;

    @Before
    public void before() {
        // start the proxy
        proxy = new BrowserMobProxyServer();
        proxy.start(0);

        // get the Selenium proxy object
        org.openqa.selenium.Proxy seleniumProxy = ClientUtil.createSeleniumProxy(proxy);

        // configure it as a desired capability
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(CapabilityType.PROXY, seleniumProxy);

        // start the browser up
        driver = new ChromeDriver(capabilities);
    }

    @Test
    public void test() {
        proxy.newHar();
        driver.navigate().to("http://selenium2.ru");
        Har har = proxy.endHar();
        har.getLog().getEntries().forEach(l-> System.out.println(l.getResponse().getStatus()+" : "+l.getRequest().getUrl()));
    }
    @After
    public void after(){
        driver.quit();
        driver=null;
    }

}

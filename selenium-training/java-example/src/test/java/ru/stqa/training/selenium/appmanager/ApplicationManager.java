package ru.stqa.training.selenium.appmanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * Created by luk on 2017-04-10.
 */
public class ApplicationManager {
    private NavigationHelper navigationHelper;
    private CartPageHelper cartPageHelper;
    private ProductPageHelper productPageHelper;
    private MainPageHelper mainPageHelper;
    private SessionHelper sessionHelper;
    protected WebDriverWait wait;
    protected WebDriver chDriver;

    public void init() {
        chDriver = new ChromeDriver();
        chDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        wait = new WebDriverWait(chDriver, 5);
        mainPageHelper = new MainPageHelper(chDriver);
        productPageHelper = new ProductPageHelper(chDriver);
        productPageHelper.wait = new WebDriverWait(chDriver, 5);
        cartPageHelper = new CartPageHelper(chDriver);
        cartPageHelper.wait = new WebDriverWait(chDriver, 5);
        navigationHelper = new NavigationHelper(chDriver);
        sessionHelper = new SessionHelper(chDriver);

    }

    public void quitAndNull() {
        chDriver.quit();
        chDriver = null;
    }

    public MainPageHelper getMainPageHelper() {
        return mainPageHelper;
    }

    public ProductPageHelper getProductPageHelper() {
        return productPageHelper;
    }

    public CartPageHelper getCartPageHelper() {
        return cartPageHelper;
    }

    public NavigationHelper getNavigationHelper() {
        return navigationHelper;
    }
}

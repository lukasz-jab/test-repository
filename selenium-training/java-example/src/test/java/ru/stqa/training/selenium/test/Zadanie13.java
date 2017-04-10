package ru.stqa.training.selenium.test;

/**
 * Created by luk on 2017-03-19.
 */

import org.junit.Test;


public class Zadanie13 extends TestBase {

    @Test
    public void test() {

        app.getMainPageHelper().chooseFirstProduct();
        app.getProductPageHelper().getCurrentCartStatus();
        app.getProductPageHelper().addToCart();
        app.getProductPageHelper().waitForChangeCartStatus();
        app.getNavigationHelper().gotoMainPage();

        app.getMainPageHelper().chooseSecondProduct();
        app.getProductPageHelper().getCurrentCartStatus();
        app.getProductPageHelper().addToCart();
        app.getProductPageHelper().waitForChangeCartStatus();
        app.getNavigationHelper().gotoMainPage();

        app.getMainPageHelper().chooseThirdProduct();
        app.getProductPageHelper().getCurrentCartStatus();
        app.getProductPageHelper().addToCart();
        app.getProductPageHelper().waitForChangeCartStatus();
        app.getNavigationHelper().gotoMainPage();

        app.getCartPageHelper().checkToRemoveProduct();
        app.getCartPageHelper().getTableOfProduct();
        app.getCartPageHelper().deleteFromCart();
        app.getCartPageHelper().waitForChangeOfTableProduct();

        app.getCartPageHelper().getTableOfProduct();
        app.getCartPageHelper().deleteFromCart();
        app.getCartPageHelper().waitForChangeOfTableProduct();

        app.getCartPageHelper().getTableOfProduct();
        app.getCartPageHelper().deleteFromCart();
        app.getCartPageHelper().waitForChangeOfTableProduct();


    }

}
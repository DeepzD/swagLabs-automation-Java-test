package com.dd.tests.inventory;


import com.dd.pages.InventoryPage;
import com.dd.pages.LoginPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class TC_13_clickingRemoveAndRevertItemStates {

    private final Logger logger = LogManager.getLogger(TC_13_clickingRemoveAndRevertItemStates.class);
    WebDriver driver;

    @BeforeMethod
    public void beforeMethod()
    {
        logger.info("Initialization");
        driver= new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void afterMethod()
    {
        driver.quit();
    }

    @Test
    public void AddItemToShoppingCart()
    {
        LoginPage loginPage=new LoginPage(driver);
        loginPage.typeUsername("standard_user").typePassword("secret_sauce").
                clickLoginButton();
        InventoryPage inventoryPage = new  InventoryPage(driver);
        List<String> addToCartItems = Arrays.asList("Sauce Labs Backpack","Sauce Labs Bike Light","Sauce Labs Bolt T-Shirt");
        inventoryPage.addItemsToCart(addToCartItems);
        Assert.assertEquals(inventoryPage.ShoppingCart_itemCount(),3,"Item count should be more than one");
    }

    @Test
    public void RemoveItemsFromShoppingCart()
    {
        LoginPage loginPage=new LoginPage(driver);
        loginPage.typeUsername("standard_user").typePassword("secret_sauce").
                clickLoginButton();
        InventoryPage inventoryPage = new  InventoryPage(driver);
        List<String> addToCartItems = Arrays.asList("Sauce Labs Backpack","Sauce Labs Bike Light","Sauce Labs Bolt T-Shirt");
         inventoryPage.addItemsToCart(addToCartItems);
        inventoryPage.removeItems(20.00);
        //Assert.assertEquals(inventoryPage.ShoppingCart_itemCount(),3,"Item count should be more than one");
    }
}

package com.dd.tests.inventory;

import com.dd.pages.InventoryPage;
import com.dd.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC_09_AllProductDetailsAreDisplay {

    WebDriver driver;
    @BeforeMethod
    public void beforeMethod()
    {
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
    }
    @AfterMethod
    public void afterMethod(){

        driver.quit();
    }

    /**
     * Verify all products are displayed with name, price, image, and description.
     */
    @Test
    public void testAllProductsDisplayedInInventoryPage()
    {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user","secret_sauce");
        InventoryPage inventoryPage =new InventoryPage(driver);
        inventoryPage.verifyAllProductsHaveNamePriceImageDescription();

    }
}

package com.dd.tests.inventory;

import com.dd.pages.InventoryPage;
import com.dd.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC_11_NavigateToProductDetailsByClickingOnName {
    WebDriver driver;

    @BeforeMethod
    public void beforeMethod()
    {
        driver =new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void afterMethod()
    {
        //driver.quit();
    }

    /**
     * Clicking on product name navigates to the product details page.
     */
    @Test
    public void ClickOnNameToNavigateProductDetails()
    {
        LoginPage loginPage=new LoginPage(driver);
        loginPage.login("standard_user","secret_sauce");
        InventoryPage inventoryPage= new InventoryPage(driver);
        inventoryPage.ClickOnNameLink();
    }
}

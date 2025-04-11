package com.dd.tests.inventory;


import com.dd.pages.InventoryPage;
import com.dd.pages.LoginPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC_17_sortingProductsFromPrice_High_To_Low {

    private final Logger logger = LogManager.getLogger(TC_17_sortingProductsFromPrice_High_To_Low.class);
    WebDriver driver;

    @BeforeMethod
    public void beforeMethod() {
        logger.info("Initialization");
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void afterMethod() {
        // driver.quit();
    }

    @Test
    public void sortItemsFromPrice_High_to_Low() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.typeUsername("standard_user").typePassword("secret_sauce").
                clickLoginButton();
        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.sortProductList("hilo");
        // Assert
    }

}

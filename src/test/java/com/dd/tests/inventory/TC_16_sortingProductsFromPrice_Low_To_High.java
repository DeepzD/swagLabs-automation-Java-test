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

public class TC_16_sortingProductsFromPrice_Low_To_High {

    private final Logger logger = LogManager.getLogger(TC_16_sortingProductsFromPrice_Low_To_High.class);
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
    public void sortItemsFromPrice_Low_to_High() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.typeUsername("standard_user").typePassword("secret_sauce").
                clickLoginButton();
        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.sortProductList("lohi");
        // Assert
    }


}

 package com.dd.tests.inventory;

 import com.dd.pages.CartPage;
 import com.dd.pages.InventoryPage;
 import com.dd.pages.LoginPage;
 import org.openqa.selenium.WebDriver;
 import org.openqa.selenium.chrome.ChromeDriver;
 import org.testng.annotations.AfterMethod;
 import org.testng.annotations.BeforeMethod;
 import org.testng.annotations.Test;

 import java.util.Arrays;
 import java.util.List;

 import static org.testng.Assert.assertEquals;

 public class TC_18_NavigateToCartPage {

    WebDriver driver;

    @BeforeMethod
     public void beforeMethod()
    {
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
    }

    @AfterMethod
     public void afterMethod()
    {
        driver.quit();
    }

    @Test
    public void ClickOnShoppingCartIcon()
    {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user","secret_sauce");
        InventoryPage inventoryPage = new InventoryPage(driver);
        List<String> addToCartItems = Arrays.asList("Sauce Labs Backpack","Sauce Labs Bike Light","Sauce Labs Bolt T-Shirt");
        inventoryPage.addItemsToCart(addToCartItems);
        inventoryPage.clickOnShoppingCartIcon();
        CartPage cartPage = new CartPage(driver);
        assertEquals(inventoryPage.getPageTitle(),"Your Cart","After successful login page title is displed");

    }
}

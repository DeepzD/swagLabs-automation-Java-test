package com.dd.tests;

import com.dd.pages.InventoryPage;
import com.dd.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ValidLoginTest {

    WebDriver driver;

    @BeforeMethod
    public void beforeMethod()
    {
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
    public void testLoginWithValidCredentials()
    {
        LoginPage loginPage=new LoginPage(driver);
        loginPage.typeUsername("standard_user").typePassword("secret_sauce").
                clickLoginButton();
        InventoryPage inventoryPage = new  InventoryPage(driver);
        assertEquals(inventoryPage.getPageTitle(),"Products","After successful login page title is Products");
    }


}

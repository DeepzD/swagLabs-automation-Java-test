package com.dd.tests.LoginTests;

import com.dd.pages.InventoryPage;
import com.dd.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TC_05_loginTestWithBlankCredentials {

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
    public void testLoginWithBlankCredentials()
    {
        LoginPage loginPage=new LoginPage(driver);
        loginPage.typeUsername(" ").typePassword(" ").
                clickLoginButton();
        InventoryPage inventoryPage = new  InventoryPage(driver);
      //  assertEquals(inventoryPage.getErrorMessage(),"Epic sadface: Username and password do not match any user in this service","Expected Error message shown  after invalid login");
    }


}

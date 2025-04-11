package com.dd.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {

    private final WebDriver driver;

    By title = By.cssSelector(".title");
    By checkOutButton = By.id("checkout");

    public CartPage(WebDriver driver)
    {
        this.driver= driver;
    }

    public String getPageTitle()
    {
        return driver.findElement(title).getText();
    }

    public void clickCheckOutButton()
    {
        driver.findElement(checkOutButton).click();
    }

}

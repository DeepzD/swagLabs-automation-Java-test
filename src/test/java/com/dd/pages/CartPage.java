package com.dd.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {

    private final WebDriver driver;

    By checkOutButton = By.id("checkout");

    public CartPage(WebDriver driver)
    {
        this.driver= driver;
    }

    public void clickCheckOutButton()
    {
        driver.findElement(checkOutButton).click();
    }

}

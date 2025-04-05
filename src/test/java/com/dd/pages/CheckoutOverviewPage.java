package com.dd.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutOverviewPage {

    private final WebDriver driver;

    @FindBy(id="finish")
    WebElement finishButton;


    public CheckoutOverviewPage(WebDriver driver)
    {
        this.driver=driver;
    }

    public void clickOnFinishButton()
    {
        finishButton.click();
    }

}

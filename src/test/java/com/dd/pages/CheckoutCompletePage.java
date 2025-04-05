package com.dd.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutCompletePage {

    private final WebDriver driver;

    @FindBy(css=".complete-header")
    WebElement completeMessage;

    @FindBy(id="back-to-products")
    WebElement backToHomeButton;

    public CheckoutCompletePage(WebDriver driver)
    {
        this.driver= driver;
    }

    public String orderCompleteMessage()
    {
        return completeMessage.getText();
    }

    public void clickBackToHomeButton()
    {
        backToHomeButton.click();
    }

}

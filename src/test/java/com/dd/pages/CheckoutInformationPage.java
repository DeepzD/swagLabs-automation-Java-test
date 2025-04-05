package com.dd.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutInformationPage {

    private final WebDriver driver;

    @FindBy(id="first-name")
    WebElement txtFirstName;

    @FindBy(id="last-name")
    WebElement  txtLastNane;

    @FindBy(id="postal-code")
    WebElement txtPostlCode;

    @FindBy(id="continue")
    WebElement continuButton;

    public CheckoutInformationPage(WebDriver driver)
    {
        this.driver =driver;
    }

//    public String enterFirstname(String firstName)
//    {
//        txtFirstName.sendKeys(firstName);
//        return this;
//    }
//
//    public String enterLastname(String lastName)
//    {
//        txtLastNane.sendKeys(lastName);
//        return this;
//    }
//
//    public String enterPostalCode(String pcode)
//    {
//        txtPostlCode.sendKeys(pcode);
//        return this;
//    }

    public void clickContinueButton()
    {
        continuButton.click();
    }
}

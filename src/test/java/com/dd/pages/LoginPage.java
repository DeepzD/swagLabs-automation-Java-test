package com.dd.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

        private final WebDriver driver;

        @FindBy(id="user-name")
        WebElement eleusername;

        @FindBy(id="password")
        WebElement elePssword;

        @FindBy(id="login-button")
        WebElement eleLoginButton;

        @FindBy(xpath="//h3[@data-test='error']")
        WebElement errorMessage;

        public LoginPage(WebDriver driver) {
            this.driver= driver;
            PageFactory.initElements(driver,this);
        }

        public LoginPage typeUsername(String usesname)
        {
            eleusername.sendKeys(usesname);
            return this;
        }

        public LoginPage typePassword(String password)
        {
            elePssword.sendKeys(password);
            return this;
        }

        public void clickLoginButton()
        {
            eleLoginButton.click();
        }

        public String getError()
        {
            return errorMessage.getText();
        }


}

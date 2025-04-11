package com.dd.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class InventoryPage {

    private final WebDriver driver;

    By title = By.cssSelector(".title");
    By productsCard = By.xpath("//div[@class='inventory_item']");
    By productsName = By.xpath(".//div[@data-test='inventory-item-name']");
    By addToCartButton = By.xpath("//button[text()='Add to cart']");
    By itemPrice = By.xpath("//div[@data-test='inventory-item-price']");
    By productImage = By.xpath("//div[@class='inventory_item_img']");
    By productDesc = By.xpath("//div[@data-test='inventory-item-description']");
    By removeButton = By.xpath("//button[text()='Remove']");
    By shoppingCartIcon = By.xpath("//span[@class='shopping_cart_badge']");
    By shoppingCartBadge = By.cssSelector(".shopping_cart_badge");
    By errorMessage = By.xpath("//h3[@data-test='error']");
    By sortDropdown = By.xpath("//select[@data-test='product-sort-container']");

    public InventoryPage(WebDriver driver) {
        this.driver = driver;
    }

    public void verifyAllProductsHaveNamePriceImageDescription() {
        List<WebElement> availableProducts = driver.findElements(productsCard);
        Assert.assertFalse(availableProducts.isEmpty(), "No Products found on inventory page");

        for (WebElement productCard : availableProducts) {
            WebElement name = productCard.findElement(productsName);
            Assert.assertTrue(name.isDisplayed(), "Product Name is not displayed");

            WebElement price = productCard.findElement(itemPrice);
            Assert.assertTrue(price.isDisplayed(), "Product price is not displayed");

            WebElement image = productCard.findElement(productImage);
            Assert.assertTrue(image.isDisplayed(), "Product image is not displayed");

            WebElement description = productCard.findElement(productDesc);
            Assert.assertTrue(description.isDisplayed(), "Product description is not displayed");

            System.out.println(name.getText()+","+price.getText() + description.getText());

        }

    }

    public String getPageTitle() {
        return driver.findElement(title).getText();
    }

    public void ClickOnImageLink() {
        List<WebElement> imageLinks = driver.findElements(productImage);
        Assert.assertEquals(imageLinks.size(), 6, "Displayed image count");

        //  System.out.println(imageLink.getText());
        //            String expectedUrl = "/inventory-item.html";
        //            imageLink.click();
        //            System.out.println(driver.getCurrentUrl());
        //            Assert.assertTrue(driver.getCurrentUrl().contains(expectedUrl),"Not navigated to product details page");
        //            driver.navigate().back();
        //            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //
    }
        public void ClickOnNameLink()
        {
            List<WebElement> productNameLinks =driver.findElements(productsName);
            Assert.assertEquals(productNameLinks.size(), 6, "Displayed product Names count");
            {
                for(WebElement productNameLink : productNameLinks )
                {
                    String NameLink = productNameLink.findElement(productsName).getText();
                    System.out.println(NameLink);
                }
            }
        }



    public void addItemsToCart(List<String> itemsNeeded) {
        //String[] itemsNeeded ={"Sauce Labs Backpack","Sauce Labs Bike Light","Sauce Labs Bolt T-Shirt"};
        List<WebElement> eleProducts = driver.findElements(productsName);
        Assert.assertEquals(eleProducts.size(), 6, "Displayed product count");

        for (WebElement eleProduct : eleProducts) {
           // System.out.println(eleProduct.getText());

            if (itemsNeeded.contains(eleProduct.getText())) {
                driver.findElement(addToCartButton).click();
            }
        }
    }

    public void removeItems(double price) {
        List<WebElement> eleProducts = driver.findElements(productsName);
        for (WebElement eleProduct : eleProducts) {
            List<WebElement> removeButtons = driver.findElements(removeButton);
            {
                if (!removeButtons.isEmpty()) {
                    String PriceText = eleProduct.findElement(itemPrice).getText();
                    double Price = Double.parseDouble(PriceText.replace("$", " "));
                    if (Price > price) {
                        driver.findElement(removeButton).click();
                    }
                }

            }
        }
    }

    public void clickOnShoppingCartIcon() {
        driver.findElement(shoppingCartIcon).click();
    }

    public int ShoppingCart_itemCount() {
        String itemCount = driver.findElement(shoppingCartBadge).getText();
        return Integer.parseInt(itemCount);
    }

    public String getErrorMessage() {
        return driver.findElement(errorMessage).getText();
    }

    public void sortProductList(String optionValue) {
        WebElement sortContainer = driver.findElement(sortDropdown);
        Select select = new Select(sortContainer);
        select.selectByValue(optionValue);

        List<WebElement> sortedListZ_A = driver.findElements(productsName);
        //List<String> sortedListNamesZ_A = new ArrayList<>();
        for (WebElement sortedItemZ_A : sortedListZ_A) {
            System.out.println(sortedItemZ_A.getText());
        }

    }


}

package com.dd.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class InventoryPage {

    private final WebDriver driver;

    By title = By.cssSelector(".title");
    By productsNeeded = By.cssSelector(".inventory_item_name");
    By addToCartButton = By.xpath("//button[text()='Add to cart']");
    By shoppingCartIcon = By.xpath("//span[@class='shopping_cart_badge']");
    By shoppingCartBadge = By.cssSelector(".shopping_cart_badge");

    public InventoryPage(WebDriver driver) {
        this.driver=driver;
    }

    public String getPageTitle()
    {
        return driver.findElement(title).getText();
    }

    public void addItemsToCart()
    {
        String[] itemsNeeded ={"Sauce Labs Backpack","Sauce Labs Bike Light","Sauce Labs Bolt T-Shirt"};
        List<WebElement> Products = driver.findElements(productsNeeded);

        for(int i=0;i<Products.size();i++)
        {
            String[] name=Products.get(i).getText().split(",");
            String formattedName = name[0].replace("Sauce Labs", "").trim();
            for(int j=0;j<itemsNeeded.length;i++)
            {
                if(itemsNeeded[j].contains(formattedName))
                {
                    driver.findElement(addToCartButton).click();
                }
            }
        }

    }

    public void clickOnShoppingCartIcon()
    {
        driver.findElement(shoppingCartIcon).click();
    }

    public int ShoppingCart_itemCount()
    {
         String itemCount= driver.findElement(shoppingCartBadge).getText();
         return Integer.parseInt(itemCount);
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pricecomparison.pagelevelmodule;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 * @author Paul
 */
public class GenericModule {

    static WebDriver driver;
    public AmazonPageModule azPageModule = new AmazonPageModule();
    public FlipkartPageModule fkPageModule = new FlipkartPageModule(driver);

    //Search product and return title of the product
    public String searchProduct(String productName, String websiteName, WebDriver driver) {
        String productTitle = "";
        WebElement searchbox = null, searchIcon = null, productTitleLink = null;
        try {
            if (websiteName.equals("Amazon")) {
                searchbox = azPageModule.amazonHomePage("Searchbox", driver);
                searchIcon = azPageModule.amazonHomePage("SearchIcon", driver);
                productTitleLink = azPageModule.amazonSearchResult("ProductTitle", driver);
            } else if (websiteName.equals("Flipkart")) {
                searchbox = fkPageModule.flipkartHomePage("Searchbox", driver);
                searchIcon = fkPageModule.flipkartHomePage("SearchIcon", driver);
                productTitleLink = fkPageModule.flipkartSearchResult("ProductTitle", driver);
            }
            searchbox.sendKeys(productName);
            searchIcon.click();
            WebDriverWait wait = new WebDriverWait(driver, 60);
            wait.until(ExpectedConditions.visibilityOf(productTitleLink));
            if (productTitleLink == null) {
                System.out.println("Product not found");
            } else {
                productTitle = productTitleLink.getText();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return productTitle;
    }

    //Match title of the product with the expected title
    public boolean matchProduct(String productTitle) {
        if (productTitle.contains("iPhone") && productTitle.contains("XR") && (productTitle.contains("64 GB") || productTitle.contains("64GB")) && productTitle.contains("Yellow")) {
            return true;
        } else {
            return false;
        }
    }

    //Fetch price of the product
    public float getPrice(String websiteName, WebDriver driver) {
        WebElement priceElement = null;
        float productPrice = 0;
        if (websiteName.equals("Amazon")) {
            priceElement = azPageModule.amazonSearchResult("ProductPrice", driver);
        } else if (websiteName.equals("Flipkart")) {
            priceElement = fkPageModule.flipkartSearchResult("ProductPrice", driver);
        } else {
            System.out.println("Invalid website name");
        }
        if (priceElement != null) {
            String priceText = priceElement.getText();
            productPrice = Float.parseFloat(priceText.replaceAll("[^0-9]", ""));
        }
        return productPrice;
    }

}

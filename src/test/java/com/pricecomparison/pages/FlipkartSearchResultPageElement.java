/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pricecomparison.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 *
 * @author Paul
 */
public class FlipkartSearchResultPageElement {
    //This contains only elements of searchresult page of Flipkart

    @FindBy(xpath = "//a[contains(@href,'apple-iphone-xr-yellow-64-gb')]/div[2]/div[1]/div[1]")
    public WebElement fkiphoneproductTitle;

    @FindBy(xpath = "//a[contains(@href,'apple-iphone-xr-yellow-64-gb')]/div[2]/div[2]/div/div/div")
    public WebElement fkiphonePrice;

    public FlipkartSearchResultPageElement(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}

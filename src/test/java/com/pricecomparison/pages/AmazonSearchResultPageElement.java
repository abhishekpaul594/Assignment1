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
public class AmazonSearchResultPageElement {
    //This contains only elements of searchresult page of Amazon
        @FindBy(xpath = "//a[contains(@href,'Apple-iPhone-XR-64GB-Yellow')]/span[text()='Apple iPhone XR (64GB) - Yellow']")
        public WebElement aziphoneProductTitle;

        @FindBy(xpath = "//a[contains(@href,'Apple-iPhone-XR-64GB-Yellow')]/span[@class='a-price']/span[2]/span[2]")
        public WebElement aziphonePrice;

        public AmazonSearchResultPageElement(WebDriver driver) {
            PageFactory.initElements(driver, this);
        }
}

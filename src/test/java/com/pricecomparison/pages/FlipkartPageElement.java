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
public class FlipkartPageElement {

    //This contains only login popup elements which appears after opening Fipkart
    @FindBy(xpath = "//button[text()='✕']")
    public WebElement closeLoginPanel;

    public FlipkartPageElement(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public class FlipkartHomePage {

        //This contains only homepage elements of Flipkart
        @FindBy(xpath = "//input[@title='Search for products, brands and more']")
        public WebElement fksearbox;

        @FindBy(xpath = "//input[@title='Search for products, brands and more']/../../button")
        public WebElement fksearchIcon;

        public FlipkartHomePage(WebDriver driver) {
            PageFactory.initElements(driver, this);
        }
    }

}

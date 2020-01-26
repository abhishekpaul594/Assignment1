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
public class AmazonHomePageElement {

    //This contains only homepage elements of Amazon
    @FindBy(xpath = "//input[@id='twotabsearchtextbox']")
    public WebElement azsearchbox;

    @FindBy(xpath = "//input[@value='Go']")
    public WebElement azsearchIcon;

    public AmazonHomePageElement(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public class AmazonSearchResult {

        
    }

}

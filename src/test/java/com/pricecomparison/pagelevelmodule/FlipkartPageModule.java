/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pricecomparison.pagelevelmodule;

import com.pricecomparison.pages.FlipkartPageElement;
import com.pricecomparison.pages.FlipkartSearchResultPageElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 *
 * @author Paul
 */
public class FlipkartPageModule {

    FlipkartPageElement fkPageElement;
    FlipkartPageElement.FlipkartHomePage fkHomePage;
    FlipkartSearchResultPageElement fkSearchResult;
    public FlipkartPageModule(WebDriver driver) {
        fkPageElement = new FlipkartPageElement(driver);
    }

    //Fetch login popup element of Flipkart home page
    public WebElement flipkartLoginPopup(String loginPopupElementName, WebDriver driver) {
        WebElement loginPopupElement = null;
        try {
            if (loginPopupElementName.equals("LoginPopupClose")) {
                loginPopupElement = fkPageElement.closeLoginPanel;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return loginPopupElement;
    }

    //Fetch elements of homepage of Flipkart
    public WebElement flipkartHomePage(String homePageElementName, WebDriver driver) {
        WebElement homepageElement = null;
        fkHomePage = fkPageElement.new FlipkartHomePage(driver);
        try {
            if (homePageElementName.equals("Searchbox")) {
                homepageElement = fkHomePage.fksearbox;
            } else if (homePageElementName.equals("SearchIcon")) {
                homepageElement = fkHomePage.fksearchIcon;
            } else {
                System.out.println("Invalid element name");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return homepageElement;
    }

    //Fetch elements in searchresult page of Flipkart
    public WebElement flipkartSearchResult(String searchResultElementName, WebDriver driver) {
        WebElement searchResultElement = null;
        fkSearchResult = new FlipkartSearchResultPageElement(driver);
        try {
            if (searchResultElementName.equals("ProductTitle")) {
                searchResultElement = fkSearchResult.fkiphoneproductTitle;
            } else if (searchResultElementName.equals("ProductPrice")) {
                searchResultElement = fkSearchResult.fkiphonePrice;
            } else {
                System.out.println("Invalid element name");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return searchResultElement;
    }
}

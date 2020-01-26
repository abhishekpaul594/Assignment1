/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pricecomparison.pagelevelmodule;

import com.pricecomparison.pages.AmazonHomePageElement;
import com.pricecomparison.pages.AmazonSearchResultPageElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 *
 * @author Paul
 */
public class AmazonPageModule {
    AmazonHomePageElement azPageElement;
    AmazonHomePageElement.AmazonSearchResult azSearchResult;
    AmazonSearchResultPageElement azSearchElement;
    //Fetch homepage elements of Amazon
    public WebElement amazonHomePage(String homepageElementName,WebDriver driver)
    {
        WebElement homepageElement=null;
        azPageElement = new AmazonHomePageElement(driver);
        try
        {
            if(homepageElementName.equals("Searchbox"))
                homepageElement=azPageElement.azsearchbox;
            else if(homepageElementName.equals("SearchIcon"))
                homepageElement=azPageElement.azsearchIcon;
            else
                System.out.println("Invalid element name");
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        return  homepageElement;
    }
    
    //Fetch elements of search result page of Amazon
    public WebElement amazonSearchResult(String searchElementName,WebDriver driver)
    {
        WebElement searchResultElement=null;
        azSearchElement=new AmazonSearchResultPageElement(driver);
        try
        {
            if(searchElementName.equals("ProductTitle"))
                searchResultElement=azSearchElement.aziphoneProductTitle;
            else if(searchElementName.equals("ProductPrice"))
                searchResultElement=azSearchElement.aziphonePrice;
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        return  searchResultElement;
    }
}

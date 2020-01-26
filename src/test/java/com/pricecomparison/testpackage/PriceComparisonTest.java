/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pricecomparison.testpackage;

import com.pricecomparison.beforetestmethods.BeforeTestMethods;
import com.pricecomparison.pagelevelmodule.AmazonPageModule;
import com.pricecomparison.pagelevelmodule.FlipkartPageModule;
import com.pricecomparison.pagelevelmodule.GenericModule;
import java.io.File;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 *
 * @author Paul
 */
public class PriceComparisonTest {

    public FlipkartPageModule fkPageModule = null;
    static public WebDriver driver = null;
    public String amazonURL = null;
    public String flipkartURL = null;
    public File websiteInfoXML = new File(System.getProperty("user.dir") + "//src/test/java/com/pricecomparison/websiteinfo/WebsiteInfo.xml");
    GenericModule productComparisonGM = null;
    String productTitle = null;
    float amazonprice = 0, flipkartprice = 0;
    boolean productFound = false;

    //This fetch the target URLs and open browser
    @BeforeTest
    public void launchMethod() {
        try {
            List<String> siteInfo = BeforeTestMethods.WebsiteInfoXMLParse(websiteInfoXML);
            for (int i = 0; i < siteInfo.size(); i++) {
                if (siteInfo.get(i).equals("AmazonIndia")) {
                    amazonURL = siteInfo.get(i + 1);

                } else if (siteInfo.get(i).equals("Flipkart")) {
                    flipkartURL = siteInfo.get(i + 1);

                }
            }
            driver = BeforeTestMethods.launchBrowser();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

    }

    @AfterTest
    public void afterTest() {
        driver.close();
        driver.quit();
    }

    //This fetch the price of the product in Amazon
    @Test
    public void getAmazonPrice() {

        try {
            driver.get(amazonURL);
            productComparisonGM = new GenericModule();
            productTitle = productComparisonGM.searchProduct("iPhone XR (64GB) - Yellow", "Amazon", driver);
            productFound = productComparisonGM.matchProduct(productTitle);
            if (productFound) {
                amazonprice = productComparisonGM.getPrice("Amazon", driver);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    //This fetch the price of the product in Flipkart
    @Test
    public void getFlipkartPrice() {
        try {
            WebElement loginModalClose = null;
            driver.navigate().to(flipkartURL);
            fkPageModule = new FlipkartPageModule(driver);
            loginModalClose = fkPageModule.flipkartLoginPopup("LoginPopupClose", driver);
            loginModalClose.click();
            productTitle = productComparisonGM.searchProduct("iPhone XR (64GB) - Yellow", "Flipkart", driver);
            productFound = productComparisonGM.matchProduct(productTitle);
            if (productFound) {
                flipkartprice = productComparisonGM.getPrice("Flipkart", driver);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    //This compare prices of Amazon and Flipkart and print which site has lesser price in console
    @Test
    public void priceComparison() {
        if (amazonprice > flipkartprice) {
            System.out.println("Flipkart has the lesser value of iPhone XR (64GB) - Yellow than Amazon");
        } else if (amazonprice < flipkartprice) {
            System.out.println("Amazon has the lesser value of iPhone XR (64GB) - Yellow than Flipkart");
        } else {
            System.out.println("Price is same in both Amazon and Flipkart");
        }
    }
}

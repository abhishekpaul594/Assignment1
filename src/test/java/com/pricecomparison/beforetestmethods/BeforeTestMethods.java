/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pricecomparison.beforetestmethods;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author Paul
 */
public class BeforeTestMethods {

    public static WebDriver driver = null;
    static String ChromedriverPath = System.getProperty("user.dir") + "//src/test/java/com/pricecomparison/Chromedriver/chromedriver.exe";

    //Parse WebsiteInfo.xml using DOM parser
    public static List<String> WebsiteInfoXMLParse(File filepath) {
        List<String> siteData = null;
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dbBuilder = dbFactory.newDocumentBuilder();
            Document doc = dbBuilder.parse(filepath);
            NodeList nList = doc.getElementsByTagName("site");
            siteData = new ArrayList<>();
            for (int i = 0; i < nList.getLength(); i++) {
                Node nNode = nList.item(i);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) nNode;
                    siteData.add(element.getElementsByTagName("siteName").item(0).getTextContent());
                    siteData.add(element.getElementsByTagName("siteURL").item(0).getTextContent());
                }
            }

        } catch (IOException | ParserConfigurationException | DOMException | SAXException e) {
            System.out.println(e.getMessage());
        }
        return siteData;
    }

    //Launch browser and maximize
    public static WebDriver launchBrowser() throws Exception {
        try {
            System.setProperty("webdriver.chrome.driver", ChromedriverPath);
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
            return driver;
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return driver;
    }
}

package com.digitalbooking.basePage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasePage {

    public static WebDriver driver;

    protected static final String URL = "http://fe.deitech.online/";

    public void basePage() {

        if(driver == null){
            System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
            driver= new ChromeDriver();
            driver.manage().window().maximize();
        }
    }

    public static void openApp(){
        driver.get(URL);
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public WebElement getWebElement(By locator){
        WebElement elem = null;
        try{
            elem = driver.findElement(locator);
        }
        catch (Exception e){
            System.out.println("There is no element " + locator);
            System.out.println("Exeption message " + e);
        }
        return elem;
    }

}

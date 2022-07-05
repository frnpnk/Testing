package com.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NewAccountPage extends AccountOverviewPage {
    public NewAccountPage(WebDriver driver) {
        super(driver);
    }


    By AccountSelector = By.xpath("//*[@id=\"type\"]");
    By OpenNABtn = By.xpath("//*[@id=\"rightPanel\"]/div/div/form/div/input");
    By AccountOpenChecker = By.xpath("//*[@id=\"rightPanel\"]/div/div/p[1]");

    public void NewAccount () throws InterruptedException {
        NewAccountClick();
        Thread.sleep(500);
        if (isDisplayed(AccountSelector)){
            Thread.sleep(500);
            Selector("SAVINGS", AccountSelector);
            Thread.sleep(500);
            click(OpenNABtn);
        }else {
            System.out.println("Not locator founds");
        }
    }

    public String newAccountMessage(){
        return getText(AccountOpenChecker);
    }

}

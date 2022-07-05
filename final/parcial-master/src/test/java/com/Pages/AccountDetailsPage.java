package com.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountDetailsPage extends AccountOverviewPage{


    public AccountDetailsPage(WebDriver driver) {
        super(driver);
    }

    By AccountsDetails  = By.xpath("//*[@id=\"rightPanel\"]/div/div[1]/h1");
    By ActivityPeriod = By.xpath("//*[@id=\"month\"]");
    By ActivityType = By.xpath("//*[@id=\"transactionType\"]");
    By Go = By.xpath("//*[@id=\"rightPanel\"]/div/div[2]/form/table/tbody/tr[3]/td[2]/input");




    public String AccountDetailsTitle(){
        return getText(AccountsDetails);
    }


    public void AllAcountDetails () throws InterruptedException {
        Thread.sleep(500);
        if (isDisplayed(AccountsDetails)){
            Thread.sleep(500);
            Selector("All", ActivityPeriod);
            Thread.sleep(500);
            Selector("All", ActivityType);
            Thread.sleep(500);
        }else {
            System.out.println("Not locator founds");
        }
    }

    public void GoClick(){click(Go);};
}

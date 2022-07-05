package com.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class AccountOverviewPage extends HomePage {

    public AccountOverviewPage(WebDriver driver) {
        super(driver);
    }
    By NewAccountBtn = By.xpath("//*[@id=\"leftPanel\"]/ul/li[1]/a");
    By AccountsOverviewBtn = By.xpath("//*[@id=\"leftPanel\"]/ul/li[2]/a");
    By TransferBtn = By.xpath("//*[@id=\"leftPanel\"]/ul/li[3]/a");
    By LogOutBtn = By.xpath("//*[@id=\"leftPanel\"]/ul/li[8]/a");
    By Retentions = By.xpath("//*[@id=\"accountTable\"]/tfoot/tr/td");
    By FirstAccount = By.xpath("//*[@id=\"accountTable\"]/tbody/tr[1]/td[1]/a");



    public boolean isLogged(){
        if(isDisplayed(LogOutBtn)){
            return true;
        }
        return false;
    };
    public String RetentionsAplied(){
        if (isDisplayed(Retentions)){
            return getText(Retentions);
        }else{
            System.out.println("Locator not found");
            return null;
        }
    }
    public void NewAccountClick () throws InterruptedException {
        Thread.sleep(500);
        if (isLogged()){
            click(NewAccountBtn);
        }
        else{
            System.out.println("Not in logged account page");
        }
    }
    public void AccountSummaryBtnClick () throws InterruptedException {
        Thread.sleep(500);
        if(isLogged()){
            click(AccountsOverviewBtn);
        }else{
            System.out.println("Not in logged account page");
        }
    }
    public void TransferBtnClick () throws InterruptedException {
        Thread.sleep(500);
        if(isLogged()){
            click(TransferBtn);
        }else{
            System.out.println("Not in logged account page");
        }
    }

    public void FirstAccountClick () throws InterruptedException {
        Thread.sleep(500);
        if(isLogged()&&isDisplayed(FirstAccount)){
            click(FirstAccount);
        }else{
            System.out.println("Not in logged account page or not account created yet");
        }
    }





}

package com.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TransferFoundsPage extends NewAccountPage{


    public TransferFoundsPage(WebDriver driver) {
        super(driver);
    }

    By TranferFoundsTitle = By.xpath("//*[@id=\"rightPanel\"]/div/div/h1");
    By Amount = By.xpath("//*[@id=\"amount\"]");
    By FromAccount = By.xpath("//*[@id=\"fromAccountId\"]");
    By ToAccount = By.xpath("//*[@id=\"toAccountId\"]");
    By TransferBtn = By.xpath("//*[@id=\"rightPanel\"]/div/div/form/div[2]/input");
    By TransferComplete = By.xpath("//*[@id=\"rightPanel\"]/div/div/h1");


    public String TransferTitle(){return getText(TranferFoundsTitle);}
    public String TransferComplete(){return getText(TransferComplete);}

    public void Transfer(){
        type("100", Amount);
        SelectorByIndex(0,FromAccount);
        SelectorByIndex(1,ToAccount);
        click(TransferBtn);
    }
}

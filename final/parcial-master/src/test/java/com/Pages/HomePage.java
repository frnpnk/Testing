package com.Pages;

import com.Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage{

    public HomePage(WebDriver driver) {
        super(driver);
    }

    By RegisterBtn = By.xpath("//*[@id=\"loginPanel\"]/p[2]/a");
    By Username = By.xpath("//*[@id=\"loginPanel\"]/form/div[1]/input");
    By Password = By.xpath("//*[@id=\"loginPanel\"]/form/div[2]/input");
    By LoginBtn =  By.xpath("//*[@id=\"loginPanel\"]/form/div[3]/input");


    public void register() throws InterruptedException {
        Thread.sleep(500);
        click(RegisterBtn);
    }

    public void login(){
        type("franciscoSmith9571",Username);
        type("Fracisco1234",Password);
        click(LoginBtn);
    }




}

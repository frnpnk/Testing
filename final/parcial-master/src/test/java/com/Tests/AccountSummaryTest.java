package com.Tests;

import com.Pages.TransferFoundsPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Tag;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AccountSummaryTest {


    private WebDriver driver;
    TransferFoundsPage Page;

    @Before
    public void SetUp() throws Exception {
        Page = new TransferFoundsPage(driver);
        driver = Page.openBrowser();
        Page.visit("https://parabank.parasoft.com/parabank/index.htm");
        Thread.sleep(500);
    }
    @Before
    public void logInCheck() throws InterruptedException {
        Thread.sleep(500);
        if (Page.isLogged()){
            System.out.println("user logged");
        } else {
            Page.login();
            System.out.println("login user franciscosmith");
        }
    }



    @After
    public void TearDown() throws InterruptedException {
        driver.quit();
    }

    @Test
    @Order(3)
    @Tag("Regression")
    @Tag("smoke")
    public void AccountSummaryTest() throws InterruptedException{
        Page.AccountSummaryBtnClick();
        Thread.sleep(500);
        assertTrue(Page.RetentionsAplied().contains("*Balance includes deposits that may be subject to holds"));
    }


}

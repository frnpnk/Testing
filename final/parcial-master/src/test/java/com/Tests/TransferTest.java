package com.Tests;

import com.Pages.AccountDetailsPage;
import com.Pages.TransferFoundsPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TransferTest {

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


    @AfterAll
    public void TearDown() throws InterruptedException {
        driver.quit();
    }

    @Tag("regession")
    @Tag("smoke")
    @Test
    public void Test() throws InterruptedException{
        Page.TransferBtnClick();
        Thread.sleep(500);
        assertTrue(Page.TransferTitle().contains("Transfer Funds"));
        Page.Transfer();
        Thread.sleep(500);
        assertTrue(Page.TransferComplete().contains("Transfer Complete!"));

    }
}

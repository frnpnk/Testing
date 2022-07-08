package com.Tests;

import com.Pages.TransferFoundsPage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class NewAcountTest {


    private WebDriver driver;
    TransferFoundsPage Page;

    @BeforeAll
    public void SetUp() throws Exception {
        Page = new TransferFoundsPage(driver);
        driver = Page.openBrowser();
        Page.visit("https://parabank.parasoft.com/parabank/index.htm");
        Thread.sleep(500);
    }
    @BeforeEach
    public void logInCheck() throws InterruptedException {
        Thread.sleep(500);
        if (Page.isLogged()){
            System.out.println("user logged");
        } else {
            Thread.sleep(500);
            Page.login();
            Thread.sleep(500);
            System.out.println("login user franciscosmith");
        }
    }



    @AfterAll
    public void TearDown() throws InterruptedException {
        driver.quit();
    }
    @Test
    @Order(2)
    @Tag("Regression")
    @Tag("smoke")


    public void NewAccountTest() throws InterruptedException{
        Page.NewAccountClick();
        Page.NewAccount();
        Thread.sleep(500);
        assertTrue(Page.newAccountMessage().contains("Congratulations, your account is now open."));

    }


}

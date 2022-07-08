package com.Tests;

import com.Pages.RegisterPage;
import com.Pages.TransferFoundsPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterAll;
import org.junit.Test;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;
public class RegisterTest {

    private WebDriver driver;
    RegisterPage Page;

    @Before
    public void SetUp() throws Exception {
        Page = new TransferFoundsPage(driver);
        driver = Page.openBrowser();
        Page.visit("https://parabank.parasoft.com/parabank/index.htm");
        Thread.sleep(2000);
    }



    @After
    public void TearDown() throws InterruptedException {
        driver.quit();
    }

    @Order(1)
    @Tag("Regression")
    @Tag("smoke")
    @Test
    public void RegisterTest() throws InterruptedException{
        Page.register();
        Page.RegisterUser();
        Thread.sleep(2000);
        assertTrue(Page.registerMessage().contains("You are now logged in"));

    }
}

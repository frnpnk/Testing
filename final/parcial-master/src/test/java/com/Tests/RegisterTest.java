package com.Tests;

import com.Pages.RegisterPage;
import com.Pages.TransferFoundsPage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class RegisterTest {

    private WebDriver driver;
    RegisterPage Page;

    @BeforeAll
    public void SetUp() throws Exception {
        Page = new TransferFoundsPage(driver);
        driver = Page.openBrowser();
        Page.visit("https://parabank.parasoft.com/parabank/index.htm");
        Thread.sleep(2000);
    }



    @AfterAll
    public void TearDown() throws InterruptedException {
        driver.quit();
    }
    @Test
    @Order(1)
    @Tag("Regression")
    @Tag("smoke")

    public void RegisterTest() throws InterruptedException{
        Page.register();
        Page.RegisterUser();
        Thread.sleep(2000);
        assertTrue(Page.registerMessage().contains("You are now logged in"));

    }
}

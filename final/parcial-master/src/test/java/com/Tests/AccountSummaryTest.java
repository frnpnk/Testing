package com.Tests;

import com.Pages.AccountOverviewPage;
import com.Pages.NewAccountPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Tag;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AccountSummaryTest {
    /*

● Resumen de las cuentas
○ Haga clic en <Resumen de cuentas>
○ Compruebe si el texto "*El saldo incluye depósitos que pueden estar sujetos a
retenciones" está visible en la pantalla
     */




    private WebDriver driver;
    AccountOverviewPage accountOverviewPage;

    @Before
    public void SetUp() throws Exception {
        accountOverviewPage = new AccountOverviewPage(driver);
        driver = accountOverviewPage.openBrowser();
        accountOverviewPage.visit("https://parabank.parasoft.com/parabank/index.htm");
        Thread.sleep(2000);

        if (accountOverviewPage.isLogged()){
            System.out.println("user logged");
        } else {
            accountOverviewPage.login();
            System.out.println("login user franciscosmith");
        }

    }


    @After
    public void TearDown() throws InterruptedException {
        driver.quit();
    }

    @Test
    @Tag("regession")
    @Tag("smoke")
    public void AccountSummaryTest() throws InterruptedException{
        accountOverviewPage.AccountSummaryBtnClick();
        Thread.sleep(500);
        assertTrue(accountOverviewPage.RetentionsAplied().contains("*Balance includes deposits that may be subject to holds"));
    }


}

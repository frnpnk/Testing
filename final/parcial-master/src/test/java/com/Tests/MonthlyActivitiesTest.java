package com.Tests;

import com.Pages.AccountDetailsPage;
import com.Pages.AccountOverviewPage;
import com.Pages.NewAccountPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MonthlyActivitiesTest extends AccountSummaryTest {


    /*
    ● Actividad de la cuenta (cada mes)
○ Haga clic en <Resumen de cuentas>
○ Compruebe que el texto "*El saldo incluye depósitos que pueden estar sujetosa retenciones" es visible en la pantalla
○ Haga clic en una cuenta en la columna <Cuenta>.
○ Compruebe que el texto "Detalles de la cuenta" es visible en la pantalla
○ En "Actividad de la cuenta" haga clic en <Periodo de actividad:> y seleccione"Todo"
○ En "Actividad de la cuenta" haga clic en <Tipo:> y seleccione "Todo"
○ Haga clic en <Ir>
     */





    private WebDriver driver;
    AccountDetailsPage accountDetailsPage;

    @Before
    public void SetUp() throws Exception {
        accountDetailsPage = new AccountDetailsPage(driver);
        driver = accountDetailsPage.openBrowser();
        accountDetailsPage.visit("https://parabank.parasoft.com/parabank/index.htm");
        Thread.sleep(2000);

        if (accountDetailsPage.isLogged()){
            System.out.println("user logged");
        } else {
            accountDetailsPage.login();
            System.out.println("login user franciscosmith");
        }


    }


    @After
    public void TearDown() throws InterruptedException {
        driver.quit();
    }

    @Test
    public void Test() throws InterruptedException{
        accountDetailsPage.AccountSummaryBtnClick();
        Thread.sleep(500);
        assertTrue(accountDetailsPage.RetentionsAplied().contains("*Balance includes deposits that may be subject to holds"));
        accountDetailsPage.FirstAccountClick();
        assertTrue(accountDetailsPage.AccountDetailsTitle().contains("Account Details"));
        accountDetailsPage.AllAcountDetails();
        accountDetailsPage.GoClick();
    }

}

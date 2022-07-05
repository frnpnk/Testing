package com.Tests;

import com.Pages.AccountOverviewPage;
import com.Pages.NewAccountPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MonthlyActivitiesTest {


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
    AccountOverviewPage accountOverviewPage;

    @Before
    public void SetUp() throws Exception {
        accountOverviewPage = new NewAccountPage(driver);
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
    public void Test() throws InterruptedException{
        accountOverviewPage.AccountSummaryBtnClick();
        Thread.sleep(500);
        assertTrue(accountOverviewPage.RetentionsAplied().contains("*Balance includes deposits that may be subject to holds"));

    }

}

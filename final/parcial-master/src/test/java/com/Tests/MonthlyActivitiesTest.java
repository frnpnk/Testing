package com.Tests;

import com.Pages.AccountDetailsPage;
import com.Pages.AccountOverviewPage;
import com.Pages.NewAccountPage;
import com.Pages.TransferFoundsPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
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
    TransferFoundsPage Page;

    @BeforeAll
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
        Page.AccountSummaryBtnClick();
        Thread.sleep(500);
        assertTrue(Page.RetentionsAplied().contains("*Balance includes deposits that may be subject to holds"));
        Page.FirstAccountClick();
        assertTrue(Page.AccountDetailsTitle().contains("Account Details"));
        Page.AllAcountDetails();
        Page.GoClick();
    }

}

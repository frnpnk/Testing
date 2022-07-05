package com.Tests;

import com.Pages.NewAccountPage;
import com.Pages.TransferFoundsPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class NewAcountTest {

    /*

● Abrir una nueva cuenta
○ Haga clic en <Abrir nueva cuenta>.
○ En el apartado "¿Qué tipo de cuenta desea abrir?" seleccione la opción
<SAVINGS>.
○ Haga clic en <Abrir nueva cuenta>
1
○ Compruebe si el texto "Congratulations, your account is now open." está visible
en la pantalla


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
    public void NewAccountTest() throws InterruptedException{
        Page.NewAccountClick();
        Page.NewAccount();
        Thread.sleep(500);
        assertTrue(Page.newAccountMessage().contains("Congratulations, your account is now open."));

    }


}

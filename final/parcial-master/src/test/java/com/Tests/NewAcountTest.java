package com.Tests;

import com.Pages.NewAccountPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
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
    NewAccountPage accountPage;

    @Before
    public void SetUp() throws Exception {
        accountPage = new NewAccountPage(driver);
        driver = accountPage.openBrowser();
        accountPage.visit("https://parabank.parasoft.com/parabank/index.htm");
        Thread.sleep(2000);

        if (accountPage.isLogged()){
            System.out.println("user logged");
        } else {
            accountPage.login();
        }

    }


    @After
    public void TearDown() throws InterruptedException {
        driver.quit();
    }

    @Test
    @Tag("regession")
    public void NewAccountTest() throws InterruptedException{
        accountPage.NewAccountClick();
        accountPage.NewAccount();
        Thread.sleep(500);
        assertTrue(accountPage.newAccountMessage().contains("Congratulations, your account is now open."));

    }


}

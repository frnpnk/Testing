package com.Tests;

import com.Pages.AccountDetailsPage;
import com.Pages.TransferFoundsPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.AfterAll;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TransferTest {
    /*
    ● Transferir Fondos
○ Haga clic en <Transferencia de fondos>
○ Compruebe que el texto "Transferir fondos" es visible en la pantalla
○ En el campo <Importe: $> introduzca el importe a transferir
○ En el campo <De la cuenta #> seleccione una cuenta
○ En el campo <a la cuenta #> seleccione una cuenta distinta a la anterior
○ Haga clic en <Transferencia>
○ Compruebe que el texto "¡Transferencia completa!" es visible en la pantalla


     */


    private WebDriver driver;
    TransferFoundsPage transferPage;

    @Before
    public void SetUp() throws Exception {
        transferPage = new TransferFoundsPage(driver);
        driver = transferPage.openBrowser();
        transferPage.visit("https://parabank.parasoft.com/parabank/index.htm");
        Thread.sleep(2000);

        if (transferPage.isLogged()){
            System.out.println("user logged");
        } else {
            transferPage.login();
            System.out.println("login user franciscosmith");
        }


    }


    @AfterAll
    public void TearDown() throws InterruptedException {
        driver.quit();
    }

    @Test
    public void Test() throws InterruptedException{
        transferPage.TransferBtnClick();
        Thread.sleep(500);
        assertTrue(transferPage.TransferTitle().contains("Transfer Funds"));
        transferPage.Transfer();
        Thread.sleep(500);
        assertTrue(transferPage.TransferComplete().contains("Transfer Complete!"));

    }
}

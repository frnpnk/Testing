package com.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TransferFoundsPage extends AccountOverviewPage{


    public TransferFoundsPage(WebDriver driver) {
        super(driver);
    }

    By TranferFoundsTitle = By.xpath("//*[@id=\"rightPanel\"]/div/div/h1");
    By Amount = By.xpath("//*[@id=\"amount\"]");
    By FromAccount = By.xpath("//*[@id=\"fromAccountId\"]");
    By ToAccount = By.xpath("//*[@id=\"toAccountId\"]");
    By TransferBtn = By.xpath("//*[@id=\"rightPanel\"]/div/div/form/div[2]/input");
    By TransferComplete = By.xpath("//*[@id=\"rightPanel\"]/div/div/h1");


    public String TransferTitle(){return getText(TranferFoundsTitle);}
    public String TransferComplete(){return getText(TransferComplete);}

    public void Transfer(){
        type("100", Amount);
        SelectorByIndex(0,FromAccount);
        SelectorByIndex(1,ToAccount);
        click(TransferBtn);
    }

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

}

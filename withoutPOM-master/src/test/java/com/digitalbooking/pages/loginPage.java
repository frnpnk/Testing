package com.digitalbooking.pages;

import com.digitalbooking.basePage.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class loginPage extends BasePage {
    protected static final String txtIniciarSesion = "Iniciar sesion";
    protected static final String correo = "email";
    protected static final String usuario = "user";
    protected static final String password = "pass";
    protected static final String botonIngresar ="btn btn-primario btn-sm";
    protected static final String botonSalir = "salir";
    protected static final String errorMessage = "form-feedback";

    public void iniciarSesion () throws InterruptedException{
        WebElement botonIniciarSesion = getWebElement(By.partialLinkText(txtIniciarSesion));
        botonIniciarSesion.click();
        Thread.sleep(1000);
    }

    public void login (String email, String pass){
        WebElement mail = getWebElement(By.id(correo));
        mail.clear();
        mail.sendKeys(email);
        WebElement psw = getWebElement(By.id(password));
        psw.clear();
        psw.sendKeys(pass);
    }

    public void ingresar(){
        WebElement signInbutton = getWebElement(By.className(botonIngresar));
        signInbutton.click();
    }

    public String getUsuario(){
        WebElement user = getWebElement(By.xpath("//*[@id=\"root\"]/header/nav/div/div/div/p[2]"));
        String res = user.getText();
        return res;
    }

}

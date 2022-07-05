package com.Tests;

import com.Pages.HomePage;
import com.Pages.RegisterPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;
public class RegisterTest {

    /*
    ● Registro
○ Haga clic en <Registro>
○ Rellene el formulario de registro con los datos requeridos
○ Pulse de nuevo en <Registro>.
○ Compruebe que el texto "Su cuenta se ha creado correctamente. En la pantalla
se puede ver "You are now logged in".
     */
    private WebDriver driver;

    RegisterPage registerPage;


    @Before
    public void SetUp() throws Exception {
        registerPage = new RegisterPage(driver);
        driver = registerPage.openBrowser();
        registerPage.visit("https://parabank.parasoft.com/parabank/index.htm");
        Thread.sleep(2000);
        registerPage.register();
    }


    @After
    public void TearDown() throws InterruptedException {
        // driver.quit();
    }

    @Test
    public void RegisterTest() throws InterruptedException{
        registerPage.RegisterUser();
        assertTrue(registerPage.registerMessage().contains("You are now logged in"));

    }
}

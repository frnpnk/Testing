package com.digitalbooking.test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.digitalbooking.basePage.BasePage;
import com.digitalbooking.pages.loginPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginTest extends loginPage {

    public ExtentReports extent;
    public ExtentSparkReporter htmlReporter;
    public ExtentTest extentTest;
    private WebDriver driver;
    public BasePage basePageok;


    @BeforeTest
    public void InitialTest(){
        basePageok.openApp();
    }
    @Test
    public void testLogin() throws InterruptedException{
        try{
            Thread.sleep(2000);
            extentTest = extent.createTest("test login");
            extentTest.log(Status.INFO, "Login test started");
            loginPage page = new loginPage();
            page.iniciarSesion();
            extentTest.log(Status.PASS, "session name passed");
            page.login("danytejerina@gmail.com", "daniel123");
            extentTest.log(Status.PASS, "session pass passed");
            page.ingresar();
            Thread.sleep(2000);

            String res = page.getUsuario();
            assertTrue(res.contains("Daniel"));



        }catch (Exception e ){

        }
    }
}

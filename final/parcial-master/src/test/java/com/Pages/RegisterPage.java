package com.Pages;

import com.Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Random;

public class RegisterPage extends HomePage {
    public RegisterPage(WebDriver driver) {

        super(driver);
    }

    By SignUpTitle = By.xpath("//*[@id=\"rightPanel\"]/h1");
    By  Name =By.xpath("//*[@id=\"customer.firstName\"]");
    By  Lastname =By.xpath("//*[@id=\"customer.lastName\"]");
    By  Address = By.xpath("//*[@id=\"customer.address.street\"]");
    By  City = By.xpath("//*[@id=\"customer.address.city\"]");
    By  State= By.xpath("//*[@id=\"customer.address.state\"]");
    By  ZipCode = By.xpath("//*[@id=\"customer.address.zipCode\"]");
    By  Phone = By.xpath("//*[@id=\"customer.phoneNumber\"]");
    By  SSN = By.xpath("//*[@id=\"customer.ssn\"]");
    By  UserName = By.xpath("//*[@id=\"customer.username\"]");
    By  Pass = By.xpath("//*[@id=\"customer.password\"]");
    By  RePass = By.xpath("//*[@id=\"repeatedPassword\"]");
    By  ConfirmBtn = By.xpath("//*[@id=\"customerForm\"]/table/tbody/tr[13]/td[2]/input");
    By Created = By.xpath("//*[@id=\"rightPanel\"]/p");
    public void RegisterUser() throws InterruptedException{
        Random random = new Random();
        int N = random.nextInt(10000);
        Thread.sleep(500);
        if( isDisplayed(SignUpTitle)){
            type("Fracisco", Name);
            type("Smith", Lastname);
            type("Calle Siempreviva 742", Address);
            type("Springfield", City);
            type("Massachusetts", State);
            type("48007", ZipCode);
            type("FraciscoSmith"+N, UserName);
            type("5492235678799", Phone);
            type("679-43-4277", SSN);
            type("Fracisco1234", Pass);
            type("Fracisco1234", RePass);
            click(ConfirmBtn);
            Thread.sleep(500);
        }else {
            System.out.println("Register page was not found");
        }

    }
    public String registerMessage(){
        return getText(Created);
    }
}

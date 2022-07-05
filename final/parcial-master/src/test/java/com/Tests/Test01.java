package com.Tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

class Test01 {

	private WebDriver driver;

	@BeforeTest
	public void SetUp() throws InterruptedException{
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chomedriver/chromedriver.exe");
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://opencart.abstracta.us/index.php?route=common/home");
	}

	@Test
	public void test() throws InterruptedException {



		WebElement MyAccount = driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a/span[1]"));
		MyAccount.click();
		WebElement Register = driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/ul/li[1]/a"));
		Register.click();

		WebElement Name =driver.findElement(By.xpath("//*[@id=\"input-firstname\"]"));
		Name.sendKeys("Francisco");
		Thread.sleep(500);
		WebElement Lastname =driver.findElement(By.xpath("//*[@id=\"input-lastname\"]"));
		Lastname.sendKeys("Smith");
		Thread.sleep(500);
		WebElement Email =driver.findElement(By.xpath("//*[@id=\"input-email\"]"));
		Email.sendKeys("franciscosmith2@gmail.com");
		Thread.sleep(500);
		WebElement Phone =driver.findElement(By.xpath("//*[@id=\"input-telephone\"]"));
		Phone.sendKeys("542226344552");
		Thread.sleep(500);
		WebElement Pass =driver.findElement(By.xpath("//*[@id=\"input-password\"]"));
		Pass.sendKeys("francisco1234");
		Thread.sleep(500);
		WebElement RePass =driver.findElement(By.xpath("//*[@id=\"input-confirm\"]"));
		RePass.sendKeys("francisco1234");
		Thread.sleep(500);
		WebElement Newsletter =driver.findElement(By.xpath("//*[@id=\"content\"]/form/fieldset[3]/div/div/label[2]/input"));
		Newsletter.click();
		Thread.sleep(500);
		WebElement agreements =driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[1]"));
		agreements.click();
		Thread.sleep(500);
		WebElement Regis =driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[2]"));
		Regis.click();
		Thread.sleep(500);


		WebElement Created = driver.findElement(By.xpath("//*[@id=\"content\"]/p[1]"));
		String created = Created.getText();
		System.out.println(created);
		assertTrue(created.contains("Congratulations!"));


		WebElement Search = driver.findElement(By.xpath("//*[@id=\"search\"]/input"));
		Search.sendKeys("Iphone");
		Thread.sleep(500);
		WebElement SearchBtn = driver.findElement(By.xpath("//*[@id=\"search\"]/span/button"));
		SearchBtn.click();
		Thread.sleep(2000);
		WebElement CartBtn = driver.findElement(By.xpath("//*[@id=\"content\"]/div[3]/div/div/div[2]/div[2]/button[1]"));
		CartBtn.click();
		Thread.sleep(1000);

		WebElement Carted = driver.findElement(By.xpath("//*[@id=\"product-search\"]/div[1]"));
		String carted = Carted.getText();
		System.out.println(carted);
		assertTrue(carted.contains("You have added iPhone to your shopping cart"));






	}

	@AfterTest
	public void TearDown() throws InterruptedException{
		driver.quit();
	}

}

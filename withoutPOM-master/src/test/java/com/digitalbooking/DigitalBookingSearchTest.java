package com.digitalbooking;


import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.digitalbooking.extentReport.ExtentFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import com.aventstack.extentreports.ExtentReports;


public class DigitalBookingSearchTest {
	
	public ExtentReports extent;
	public ExtentSparkReporter htmlReporter;
	public ExtentTest extentTest;
	private WebDriver driver;
/*
	@BeforeTest
	public void setup()  throws Exception {
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://fe.deitech.online/");
	}

*/
	@Test
	@DisplayName("test prueba")
	public void testSearch() throws InterruptedException {

		htmlReporter = new ExtentSparkReporter("../src//spark.html");
		htmlReporter.config().setEncoding("utf-8");
		htmlReporter.config().setDocumentTitle("test1");
		htmlReporter.config().setReportName("ni se que estoy poniendo");
		htmlReporter.config().setTheme(Theme.DARK);

		extent =new ExtentReports();
		extent.setSystemInfo("Browser", "Chrome");
		extent.attachReporter(htmlReporter);


		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://fe.deitech.online/");


		extentTest = extent.createTest("nombre dentro del test");
		extentTest.log(Status.PASS,"test metod succefull");

		WebElement searchBox = driver.findElement(By.id("ciudad"));
		WebElement searchButton = driver.findElement(By.id("btn-buscador"));


		searchBox.clear();
		searchBox.sendKeys("Tigre");
		Thread.sleep(1000);
		searchBox.sendKeys(Keys.ENTER);
		Thread.sleep(5000);

		searchButton.click();
		Thread.sleep(5000);
		WebElement detailsButton = driver.findElement(By.xpath("//*[@id=\"76\"]/div[2]/a"));
		detailsButton.click();
		Thread.sleep(5000);


		WebElement resultado = driver.findElement(By.xpath("//*[@id=\"root\"]/main/div[1]/div/h2"));
		String res = resultado.getText();
		System.out.println("Resultado Card value: " + res);

		assertTrue(res.contains("La Carmelita"));

/*
		Thread.sleep(5000);
		WebElement initBookingButton = driver.findElement(By.xpath("//*[@id=\"root\"]/main/div[7]/div/div[2]/div/a"));
		initBookingButton.click();
		Thread.sleep(5000);
*/		driver.quit();
		extent.flush();

	}
		@AfterTest
		public void closeDriver() {
			driver.quit();
		}

}

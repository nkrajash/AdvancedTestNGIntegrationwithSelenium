package task7;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class MultipleBrowserTest {

	WebDriver driver;

	@Parameters("browserType")
	@BeforeClass
	public void invokeBrowser(String browserType) {

		if (browserType.equalsIgnoreCase("chrome")) {

			System.setProperty("webdriver.chrome.driver",
					"C:\\Data\\Selenium\\Softwares\\chromedriver_win32\\chromedriver.exe");

			driver = new ChromeDriver();

		} else if (browserType.equalsIgnoreCase("edge")) {

			System.setProperty("webdriver.edge.driver",
					"C:\\Data\\Selenium\\Softwares\\edgedriver_win64\\msedgedriver.exe");

			driver = new EdgeDriver();
		}

		driver.manage().deleteAllCookies();

		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("http://demo.guru99.com/v4");

	}

	@AfterClass
	public void closeBrowser() {
		driver.quit();
	}

	@Parameters({"userId", "userPassword"})
	@Test
	public void loginToApplication(String username, String password) {
		driver.findElement(By.name("uid")).sendKeys(username);

		driver.findElement(By.name("password")).sendKeys(password);

		driver.findElement(By.name("btnLogin")).click();
	}
	
}

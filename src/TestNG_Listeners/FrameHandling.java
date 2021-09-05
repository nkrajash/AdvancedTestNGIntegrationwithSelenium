package TestNG_Listeners;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

//Add @Listeners annotation with PackageName.ClassName.class
@Listeners(TestNG_Listeners.ListenersBlog.class)
public class FrameHandling {
	WebDriver driver;
	
	@BeforeTest
	public void user_already_on_login_page(){
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver",
				"C:\\Data\\Selenium\\Softwares\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();// launch chrome browser

		driver.manage().window().maximize(); // maximize the windows
		driver.manage().deleteAllCookies(); // delete all the cookies
		// dynamic wait

		driver.get("https://classic.freecrm.com/index.html");
		String loginTitle = driver.getTitle();
		System.out.println(loginTitle);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	}
	
	@Test(priority=-1)
	public void verify_theloginPageTitle() {
		driver.findElement(By.name("username")).sendKeys("groupautomation");
		driver.findElement(By.name("password")).sendKeys("Test@12345");
		driver.findElement(By.cssSelector("input.btn.btn-small")).click();

		String Title = driver.getTitle();
		System.out.println(Title);
		
	}
	
	@Test(priority=0)
	public void user_mouseover_contactsLink_clickNewContact() {
		driver.switchTo().frame("mainpanel");
		WebElement newContactLink = driver.findElement(By.xpath("//a[@title='New Contact']"));
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//a[contains(text(),'Contacts')]"))).build().perform();
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(newContactLink));
		newContactLink.click();

		WebElement first_name = driver.findElement(By.id("first_name"));
		WebElement last_name = driver.findElement(By.id("surname"));
		WebElement company_name = driver.findElement(By.name("client_lookup"));
		WebElement company_position = driver.findElement(By.id("company_position"));
		first_name.sendKeys("Rajashekar");
		last_name.sendKeys("Palanetrappa");
		company_name.sendKeys("Mahindra Financiers Limited");
		company_position.sendKeys("Daily Pygmy Collection Agent");
	}
	
	@Test(priority=1)
	public void user_clicks_save_button() {
		WebElement savebtn = driver
				.findElement(By.xpath("//input[@value='Load From Company']/following-sibling::input[@value='Save']"));
		savebtn.click();
		driver.findElement(By.xpath("//a[contains(text(),'Contacts')]")).click();
	}
	
	@Test(priority=2)
	public void user_clicksOnLogout() {
		driver.findElement(By.xpath("//a[contains(text(),'Logout')]")).click();
		
	}

	@AfterTest
	public void close_browser() {
		driver.quit();
	}
}

/*
[RemoteTestNG] detected TestNG version 7.4.0
This is onStart method: E:\Data\Selenium-workspace\LearningAdvTestNGIntegrationwithSelenium\test-output\TestNG Listeners Suite
Starting ChromeDriver 90.0.4430.24 (4c6d850f087da467d926e8eddb76550aed655991-refs/branch-heads/4430@{#429}) on port 34301
Only local connections are allowed.
Please see https://chromedriver.chromium.org/security-considerations for suggestions on keeping ChromeDriver safe.
ChromeDriver was started successfully.
[1626635169.250][WARNING]: This version of ChromeDriver has not been tested with Chrome version 91.
Jul 19, 2021 12:36:13 AM org.openqa.selenium.remote.ProtocolHandshake createSession
INFO: Detected dialect: W3C
Free CRM - CRM software for customer relationship management, sales, and support.
New Test Started: verify_theloginPageTitle
CRMPRO
Test Successfully Finished: verify_theloginPageTitle
New Test Started: user_mouseover_contactsLink_clickNewContact
Test Successfully Finished: user_mouseover_contactsLink_clickNewContact
New Test Started: user_clicks_save_button
Test Successfully Finished: user_clicks_save_button
New Test Started: user_clicksOnLogout
Test Successfully Finished: user_clicksOnLogout
This is onFinish method: [ResultMap map=[[TestResult name=user_clicks_save_button status=SUCCESS method=FrameHandling.user_clicks_save_button()[pri:1, instance:TestNG_Listeners.FrameHandling@37654521] output={null}], [TestResult name=verify_theloginPageTitle status=SUCCESS method=FrameHandling.verify_theloginPageTitle()[pri:-1, instance:TestNG_Listeners.FrameHandling@37654521] output={null}], [TestResult name=user_mouseover_contactsLink_clickNewContact status=SUCCESS method=FrameHandling.user_mouseover_contactsLink_clickNewContact()[pri:0, instance:TestNG_Listeners.FrameHandling@37654521] output={null}], [TestResult name=user_clicksOnLogout status=SUCCESS method=FrameHandling.user_clicksOnLogout()[pri:2, instance:TestNG_Listeners.FrameHandling@37654521] output={null}]]]
This is onFinish method: [ResultMap map=[]]

===============================================
TestNG Listeners Suite
Total tests run: 4, Passes: 4, Failures: 0, Skips: 0
===============================================
*/

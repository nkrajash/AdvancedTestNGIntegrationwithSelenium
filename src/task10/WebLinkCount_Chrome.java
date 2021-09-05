package task10;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WebLinkCount_Chrome {
	WebDriver driver;
	
	@BeforeTest
	public void setUp(){
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver",
				"C:\\Data\\Selenium\\Softwares\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();// launch chrome browser

		driver.manage().window().maximize(); // maximize the windows
		driver.manage().deleteAllCookies(); // delete all the cookies
		// dynamic wait

		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		String loginTitle = driver.getTitle();
		System.out.println(loginTitle);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	}
		
	 @Test
	 public void findWebLinks() {
		//1.Get the count of all links in the Webpage
		System.out.println(driver.findElements(By.tagName("a")).size());
		
		//2.Get the count of all links in the Webpage - Footer
		WebElement footerdriverelem = driver.findElement(By.id("gf-BIG"));
		System.out.println(footerdriverelem.findElements(By.tagName("a")).size());
		
		//3.Get the count of all links in the Webpage - Footer column 1 
		WebElement columnfooter = footerdriverelem.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
		System.out.println(columnfooter.findElements(By.tagName("a")).size());
		
		//4.click on all of links in the Webpage - Footer column 1 to 2
		for(int j=1; j<5;j++) {
			WebElement colsfooter = footerdriverelem.findElement(By.xpath("//table/tbody/tr/td[" + j + "]/ul"));
			for(int i=1; i<colsfooter.findElements(By.tagName("a")).size();i++) {
				String ctrlClick = Keys.chord(Keys.CONTROL,Keys.ENTER);
				colsfooter.findElements(By.tagName("a")).get(i).sendKeys(ctrlClick);
			}
		}
		
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> iter = windows.iterator();
		String parentId = iter.next();
		System.out.println(driver.getTitle());
		System.out.println(parentId);
		
		while(iter.hasNext()) {
			String childId = iter.next();
			driver.switchTo().window(childId);
			System.out.println(driver.getTitle());
		}
		driver.switchTo().defaultContent();
		
	 }
	
	@AfterTest
	public void tearDown(){
		driver.quit();
	}
}

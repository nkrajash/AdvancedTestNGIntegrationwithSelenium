package task10;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WebLinkCount_Firefox {
	WebDriver driver;
	
	@BeforeTest
	public void setUp(){
		// TODO Auto-generated method stub
		System.setProperty("webdriver.gecko.driver", 
				"C:\\Data\\Selenium\\Softwares\\geckodriver-v0.29.1-win64\\geckodriver.exe"); 
		//DesiredCapabilities help Selenium understand the browser details, like its name, version, and OS.
		//DesiredCapabilities dc = new DesiredCapabilities();
		//dc.setCapability("marionette", true);
		
		driver = new FirefoxDriver();// launch FF browser


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




/*Quiz
1.How to run tests with TestNG framework?
@Test annotation followed by class name
@ annotation followed by method name
@ annotation followed by pakage name
@Test annotation followed by method name
A:d

2.Identify the incorrect statement about TestNG.
TestNG is a testing framework
TestNG allows a single test from a single class file
TestNG allows grouping of test cases
TestNG modularises the test cases based on functionalities
A:b

3.Study the following the block of xml code then identify correct statement.
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE suite SYSTEM "http://testng.org/testng-1.0.dtd">
<suite name="Test Cycle">
	<test name = “Regression”>
		<classes>
			<class name=”test.cycle1”/>
			<methods>
				<include name =”login.*”/>
				<exclude name =”validateDate.*”/>
			</methods>
		</classes>
	</test>
</suite>
Test methods starting with login and validateDate will be executed.
Only login test  method will be executed
Test methods starting with validateDate will not be executed
Only validateDate test  method will be executed
A:c

4.If there are three test cases in a class, method having @BeforeMethod annotation shall be executed 
how many times?
three
one
two
four
A:a

5.Identify the set of test cases that will only be triggered from a suite from the following block of xml code.
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE suite SYSTEM "http://testng.org/testng-1.0.dtd">
<suite name="Test Cycle">
	<test name = “Regression”>
		<groups>
			<run>
				<include name =”Login”/>
			</run>
		</groups>
		<classes>
			<class name=”test.cycle1”/>
			<class name=”test.cycle2”/>
			<methods>
				<include name =”search”/>
			</methods>
		</classes>
	</test>
</suite>
Entire regression suite will be triggered for execution
Test methods with tag 'login' will be triggered for execution
Test method 'search' will be triggered for execution
All of these
A:b

6.Which helper attribute skips a particular test from execution in TestNG?
dependsOnMethods
timeOut
enabled
exclude
A:c

7.How to retrieve a global variable defined in the TestNG xml (xml code snippet given below) to the 
test method?

<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE suite SYSTEM "http://testng.org/testng-1.0.dtd">
<suite name="Test Cycle">
	<parameter name = “Username” value=”test123”/>
		<test name = “Regression”>
			<classes>
				<class name=”test.cycle”/>
			</classes>
		</test>
</suite>
@Test({"Username"})
public void Weblogin(){
	System.out.println("Login successful:" + Username);
}

@Parameter({"Username"})
@Test
public void Weblogin(){
	System.out.println("Login successful:" + Username);
}

@Parameter
@Test({"Url"})
public void Weblogin(){
	System.out.println("Login successful:" + Username);
}

@Parameter({"Username"})
@Test
public void Weblogin(String usrname){
	System.out.println("Login successful:" + usrname);
}
A:d

8.How many ways test methods can be run in parallel mode using TestNG?
tests
classes
both a and b
None of the above
A:c

9.How to achieve parameterization with multiple data sets with multiple combinations in TestNG?
@DataProvider
@Parameter
@BeforeSuite
@Combination
A:a

10.Identify which test method will be executed first from the below block of code.

@Test(dependsOnMethods={"Login"})
public void Search()
{
	System.out.println("Search is successful");
}

@Test
public void Login()
{
	System.out.println("Login is successful");
}
Search()
Login()
A:Login()

*/




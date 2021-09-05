package task5;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import org.openqa.selenium.chrome.ChromeDriver;

public class PrioritizationofTCs {
	WebDriver driver;

	@Test (priority = 1)
	public void CloseBrowser() {
		driver.close();
		System.out.println("Closing Google Chrome browser");
	}

	@Test (priority = -1)
	public void OpenBrowser() {
		System.out.println("Launching Google Chrome browser"); 
		System.setProperty("webdriver.chrome.driver",
				"C:\\Data\\Selenium\\Softwares\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.demoqa.com");
	}
	
	@Test (priority = 1)
	public void AccountTest(){
		System.out.println("Some tests for AccountTest");
	}
	
	@Test
	public void AccountSignInTest(){
		//will be assigned default priority of 0.
		System.out.println("Some tests for AccountSignInTest");
	}
	
	//Unskip tests
	@Test(enabled = true)
	public void HomePageTest(){
		//will be assigned default priority of 0.If there is a clash, run alphabetically
		System.out.println("Some tests for HomePageTest");
	}
	
	//Skip tests using enabled = false
	@Test(enabled = false) 
	public void TutorialPageTest(){
		//will be assigned default priority of 0.
		System.out.println("Some tests for TutorialPageTest");
	}
}

/* Console O/p: Run as TestNG Test
[RemoteTestNG] detected TestNG version 7.4.0

Launching Google Chrome browser
Starting ChromeDriver 90.0.4430.24 (4c6d850f087da467d926e8eddb76550aed655991-refs/branch-heads/4430@{#429}) on port 20513
Only local connections are allowed.
Please see https://chromedriver.chromium.org/security-considerations for suggestions on keeping ChromeDriver safe.
ChromeDriver was started successfully.
[1626605797.533][WARNING]: This version of ChromeDriver has not been tested with Chrome version 91.
Jul 18, 2021 4:26:38 PM org.openqa.selenium.remote.ProtocolHandshake createSession
INFO: Detected dialect: W3C

Some tests for AccountSignInTest
Some tests for HomePageTest
Some tests for AccountTest
Closing Google Chrome browser

PASSED: AccountTest
PASSED: CloseBrowser
PASSED: HomePageTest
PASSED: OpenBrowser
PASSED: AccountSignInTest

===============================================
    Default test
    Tests run: 5, Failures: 0, Skips: 0
===============================================


===============================================
Default suite
Total tests run: 5, Passes: 5, Failures: 0, Skips: 0
===============================================

*/
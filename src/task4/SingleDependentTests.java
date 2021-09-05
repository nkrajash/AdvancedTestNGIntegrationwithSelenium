package task4;

import org.testng.annotations.Test;

public class SingleDependentTests {

	  @Test (dependsOnMethods = { "OpenBrowser" })
	  public void SignIn() {
		  System.out.println("User has signed in successfully");
	  }

	  @Test
	  public void OpenBrowser() {
		  System.out.println("The browser is opened");
	  }

	  @Test (dependsOnMethods = { "SignIn" })
	  public void LogOut() {
		  System.out.println("The user logged out successfully");
	  }
}

/*
[RemoteTestNG] detected TestNG version 7.4.0
The browser is opened
User has signed in successfully
The user logged out successfully
PASSED: LogOut
PASSED: OpenBrowser
PASSED: SignIn

===============================================
    Default test
    Tests run: 3, Failures: 0, Skips: 0
===============================================


===============================================
Default suite
Total tests run: 3, Passes: 3, Failures: 0, Skips: 0
===============================================


*/
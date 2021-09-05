package task4;

import org.testng.annotations.Test;

public class DependsOnMethodsTestNG {
	  @Test (dependsOnMethods = { "OpenBrowser" })
	  public void SignIn() {
		  System.out.println("This will execute second (SignIn)");
	  }

	  @Test
	  public void OpenBrowser() {
		  System.out.println("This will execute first (Open Browser)");
	  }
	
}

/*
 * 
[RemoteTestNG] detected TestNG version 7.4.0
This will execute first (Open Browser)
This will execute second (SignIn)
PASSED: OpenBrowser
PASSED: SignIn

===============================================
    Default test
    Tests run: 2, Failures: 0, Skips: 0
===============================================


===============================================
Default suite
Total tests run: 2, Passes: 2, Failures: 0, Skips: 0
===============================================

*/

package task4;

import org.testng.annotations.Test;

public class MultipleDependentTests {
	
	    @Test
	    public void OpenBrowser() {
	        System.out.println("Opening The Browser");
	    }

	    @Test(dependsOnMethods = { "SignIn", "OpenBrowser" })
	    public void LogOut() {
	        System.out.println("Logging Out");
	    }
	    
	    @Test
	    public void SignIn() {
	        System.out.println("Signing In");
	    }

}

/*
[RemoteTestNG] detected TestNG version 7.4.0
Opening The Browser
Signing In
Logging Out
PASSED: LogOut
PASSED: SignIn
PASSED: OpenBrowser

===============================================
    Default test
    Tests run: 3, Failures: 0, Skips: 0
===============================================


===============================================
Default suite
Total tests run: 3, Passes: 3, Failures: 0, Skips: 0
===============================================
*/
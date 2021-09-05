package task4;

import org.testng.annotations.Test;

class SuperClass
{
    @Test
    public void OpenBrowser() {
        System.out.println("BrowserOpened");
    }
}


public class InheritedDependentClass extends SuperClass{
	
    @Test(dependsOnMethods = { "OpenBrowser" })
    public void LogIn() {
        System.out.println("Logged In");
    }

}

/*
[RemoteTestNG] detected TestNG version 7.4.0
BrowserOpened
BrowserOpened
Logged In
PASSED: OpenBrowser
PASSED: OpenBrowser
PASSED: LogIn

===============================================
    Default test
    Tests run: 3, Failures: 0, Skips: 0
===============================================


===============================================
Default suite
Total tests run: 3, Passes: 3, Failures: 0, Skips: 0
===============================================
*/

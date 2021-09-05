package task4;

import org.testng.annotations.Test;

public class DependsOnGroups {

    @Test(dependsOnGroups = { "SignIn" })
    public void ViewAcc() {
        System.out.println("SignIn Successful");
    }
 
    @Test(groups = { "SignIn" })
    public void LogIn() {
        System.out.println("Logging In Success");
    }
}

/*
[RemoteTestNG] detected TestNG version 7.4.0
Logging In Success
SignIn Successful
PASSED: ViewAcc
PASSED: LogIn

===============================================
    Default test
    Tests run: 2, Failures: 0, Skips: 0
===============================================


===============================================
Default suite
Total tests run: 2, Passes: 2, Failures: 0, Skips: 0
===============================================
*/

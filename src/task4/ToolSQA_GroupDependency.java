package task4;

import org.testng.annotations.Test;

public class ToolSQA_GroupDependency {
    @Test(groups = { "viewacc" })
    public void ViewAcc() {
        System.out.println("View Your Dashboard");
    }
 
    @Test(groups = { "openbrowser" })
    public void OpenBrowser() {
        System.out.println("Browser Opened Successfully");
    }
 
    @Test(groups = { "login" })
    public void LogIn() {
        System.out.println("Login Into The Account");
    }
    
    @Test(groups = {"logout"})
    public void CloseAccount() {
    	System.out.println("Closing The Account");
    }

}

/*
[RemoteTestNG] detected TestNG version 7.4.0
Logging In Success
This will execute first (Open Browser)
Login Into The Account
Browser Opened Successfully
BrowserOpened
Opening The Browser
Signing In
The browser is opened
SignIn Successful
This will execute second (SignIn)
View Your Dashboardd
Logged In
Logging Out
User has signed in successfully
The user logged out successfully
Browser Opened Successfully
Login Into The Account
View Your Dashboard
Closing The Account

===============================================
TestNG XML Dependency Suite
Total tests run: 19, Passes: 19, Failures: 0, Skips: 0
===============================================
*/
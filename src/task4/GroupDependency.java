package task4;

import org.testng.annotations.Test;

public class GroupDependency {

    @Test(dependsOnGroups = { "Signin" })
    public void ViewAcc() {
        System.out.println("View Your Dashboardd");
    }
 
    @Test(groups = { "Signin" })
    public void OpenBrowser() {
        System.out.println("Browser Opened Successfully");
    }
 
    @Test(groups = { "Signin" })
    public void LogIn() {
        System.out.println("Login Into The Account");
    }

	
}

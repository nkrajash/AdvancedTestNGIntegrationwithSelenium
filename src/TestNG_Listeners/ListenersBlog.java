package TestNG_Listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenersBlog implements ITestListener{
	
	//onTestStart: This method is invoked before any tests method is invoked. 
	//This can be used to indicate that the particular test method has been started.
	@Override
	public void onTestStart(ITestResult result) {
		
		System.out.println("New Test Started: " +result.getName());
		
	}
	
	//onTestSuccess: This method is invoked when any test method gets succeeded. 
	//This can be used to indicate that the particular test method has successfully finished its execution.
	@Override
	public void onTestSuccess(ITestResult result) {
		
		System.out.println("Test Successfully Finished: " +result.getName());
		
	}

	//onTestFailure: This method is invoked when any test method gets failed. 
	//This can be used to indicate that the particular test method has been failed. You can create an event of taking a screenshot which would show where the test has been failed.
	@Override
	public void onTestFailure(ITestResult result) {
		
		System.out.println("Test Failed: " +result.getName());
		
	}

	//onTestSkipped: This method is invoked when each test method is skipped. 
	//This can be used to indicate that the particular test method has been skipped.
	@Override
	public void onTestSkipped(ITestResult result) {
		
		System.out.println("Test Skipped: " +result.getName());
		
	}

	//onTestFailedButWithinSuccessPercentage: This method is invoked each time the test method fails but is within the success percentage mentioned. 
	//To implement this method, we use two attributes as a parameter of test annotation in TestNG i.e. successPercentage and invocationCount. The success percentage takes the value of success percentage and invocation count denotes the number of times that a particular test method would execute.
	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
		System.out.println("Test Failed but within success percentage: " +result.getName());
		
	}

	//onStart: This method is invoked before any test method gets executed. 
	//This can be used to get the directory from where the tests are running.
	@Override
	public void onStart(ITestContext context) {
		
		
		System.out.println("This is onStart method: " +context.getOutputDirectory());
		
	}

	//onFinish: This method is invoked after all tests methods gets executed. 
	//This can be used to store information of all the tests that were run.
	@Override
	public void onFinish(ITestContext context) {
			
		System.out.println("This is onFinish method: " +context.getPassedTests());
		System.out.println("This is onFinish method: " +context.getFailedTests());
	}

	
}

package task8;

import org.testng.annotations.DataProvider;

public class TestData {
	
	@DataProvider
	public Object[][] getData(){
		
		Object[][] data = new Object[3][2];
		
		data[0][0] = "mngr326530";
		data[0][1] = "hEmugAh";
		
		data[1][0] = "mngr326530";
		data[1][1] = "hEmugAh";
		
		data[2][0] = "mngr326530";
		data[2][1] = "hEmugAh";
		return data;
	}
}

/*Quiz:

1.What is the correct order of execution for the following methods?

@BeforeClass

public void beforeAClass(){

  System.out.println("Before a class");  

} 
 

@AfterClass
 

public void afterAClass() {
  

System.out.println("After a class");  }

@BeforeSuite
 

public void beforeASuite(){

System.out.println("Before a Suite");  } 

@AfterSuite
 

public void afterASuite() {

  System.out.println("After a Suite");  } 

@BeforeTest

public void beforeATest(){

System.out.println("Before a Test Run");  

} 
 

@AfterTest

public void afterATest() {

System.out.println("After a Test Run"); 

}

@Test
 public void testCase(){

System.out.println("Executing a test case...");
 

}

0 / 1 point

a).
Before a Suite

Before a Test Run

Before a class

Test case

After a class
 
After a Test Run

After a Suite


b).
Before a Suite

Before a class

Before a Test Run

Test case

After a Test Run

After a class

After a Suite

c).
These method executes based on the priority attribute

Correct
Correct!a) is the correct answer.


2.
Question 2
To execute a method always no matter what group is assigned to it, Use following

1 / 1 point

alwaysExecute=true


alwaysRun = true


runAlways = true

Correct
Correct! To execute a test method always without any miss use alwaysRun = true

3.
Question 3
Can we assign multiple groups to a test case?

1 / 1 point

Yes


No

Correct
Correct! Multiple groups can be assigned to a test case and are passed as an array in the groups attribute

4.
Question 4
Which attribute is passed to run tests in parallel?

1 / 1 point

parallel = "Test cases"


parallel = "Test Group"


parallel = "Tests"


parallel = "any"

Correct
Correct! parallel = "Tests" is passed in the suite tag as an attribute to run tests in parallel

5.
Question 5
Which annotation is used to pass parameters to a test method?

1 / 1 point

@TestData


@MethodData


@Test(parameter = "Test parameter 1")


@Parameters({"Test Parameter 1, "Test Parameter 2"})

Correct
Correct! @Parameters is used to pass a parameter to a test method

6.
Question 6
@Parameters can be used with any test method or annotations? True/False

1 / 1 point

True


False

Correct
@Parameters can be used with all the annotations and test methods

7.
Question 7
To pass multiple test data TestNG provides 

1 / 1 point

@DataProvider annotation


@Parameters

Correct
Correct!


 */


package listeners;

import org.testng.ITestContext;




import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class listener extends itime implements ITestListener{
	 
	
	ExtentReports extent = itime_extentreport.CreateTest();
	ExtentTest test;
	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub
		extent.flush();
	}

	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub
		test = extent.createTest("Test_Itime");


        test.assignAuthor("AK");


        test.assignCategory("Functional Testing");
        
        System.out.println("Test Started");

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		System.out.println("100 percentage done");
		
	}

	public void onTestFailure(ITestResult arg0) {
		
		
		// TODO Auto-generated method stub
		test.fail("Login Successfully not Executed");
		test.fail("Successfully unable Navigated to  itime page");
		test.fail("Timesheet data not saved Successfully");
		
		System.out.println("login is failed");
	}

	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub
	//	test.log(Status.PASS, markup);
	}

	public void onTestStart(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestSuccess(ITestResult arg0) {
		// TODO Auto-generated method stub
		test.pass("Login Successfully Executed");
		test.pass("Successfully Navigated to itime page");
		test.pass("Timesheet data saved Successfully");
	}

}

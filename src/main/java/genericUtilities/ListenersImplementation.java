package genericUtilities;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
/**
 * This class provide implementation to ITestListener of TestNG
 * @author mukes
 */

public class ListenersImplementation implements ITestListener{
	
	ExtentReports report;

	@Override
	public void onTestStart(ITestResult result) {
		String methodname = result.getMethod().getMethodName();
		System.out.println(methodname+" - @Test is Execution Started");
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String methodname = result.getMethod().getMethodName();
		System.out.println(methodname+" - @Test is Execution PASS");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String methodname = result.getMethod().getMethodName();
		System.out.println(methodname+" - @Test is Execution FAIL");
		// Capture the Exception
		System.out.println(result.getThrowable());
		// Capture Screenshot
		SeleniumUtility s = new SeleniumUtility();
		JavaUtility j = new JavaUtility();
		// Configure the screenshot name
		String screenShotName = methodname+"-"+j.getSystemDataInformat();
		try {
			s.captureScreenshot(BaseClass.sdriver, screenShotName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String methodname = result.getMethod().getMethodName();
		System.out.println(methodname+" - @Test is Execution SKIP");
		// Capture the Exception
		System.out.println(result.getThrowable());
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("@Suite is Execution Started");
		// Configuration of Extent report
		ExtentSparkReporter esr = new ExtentSparkReporter(".\\ExtentReports\\Report - "+ new JavaUtility().getSystemDataInformat()+".html");
		esr.config().setDocumentTitle("SauceLabs Execution Report");
		esr.config().setReportName("Execution Report");
		esr.config().setTheme(Theme.DARK);
		
		//Load the basic configuration to extent report class
		report = new ExtentReports();
		report.attachReporter(esr);
		report.setSystemInfo("Base Browser", "Microsoft Edge");
		report.setSystemInfo("Base Platform", "Windows");
		report.setSystemInfo("Base URL", "Testing Environment");
		report.setSystemInfo("Reporter Name", "Mukesh Singh");
		
		
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("@Suite is Execution Finished");
		//Flush the report
		report.flush();
	
	}

}

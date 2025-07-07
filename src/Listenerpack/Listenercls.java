package Listenerpack;

import static Constants.Constants.ExtentHtmlReporter_FILEPATH;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import base.BaseClass;
import utils.TakeScreenshotsCls;

public class Listenercls implements ITestListener {

	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extentreport;
	public static ExtentTest test, test1;
	public static String datenameHtml;
	public static String screenshotPath;

	@Override
	public void onFinish(ITestContext result) {

		System.out.println("onFinish Method");
		// test.log(Status.WARNING,result.getName() ); //extentreport.flush();
	}

	@Override
	public void onStart(ITestContext result) {
		System.out.println("onStart Method and Path = " + result.getClass());
		System.out.println("onStart Path" + System.getProperty("user.dir"));
		datenameHtml = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		htmlReporter = new ExtentHtmlReporter(
				System.getProperty("user.dir") + ExtentHtmlReporter_FILEPATH + datenameHtml + ".html");
		// htmlReporter = new ExtentHtmlReporter("ShivaHTMLReport.html");
		System.out.println("HTML Report Path = " + System.getProperty("user.dir") + ExtentHtmlReporter_FILEPATH
				+ datenameHtml + ".html");
		htmlReporter.config().setDocumentTitle("ShivaDocumentTitle");
		htmlReporter.config().setFilePath(ExtentHtmlReporter_FILEPATH);
		htmlReporter.config().setChartVisibilityOnOpen(false);
		htmlReporter.config().setReportName("ShivaReportName");
		htmlReporter.config().setTheme(Theme.DARK);

		extentreport = new ExtentReports();
		extentreport.attachReporter(htmlReporter);
		extentreport.setSystemInfo("Tester Name", "Sivakumar V");
		extentreport.setSystemInfo("OS", System. getProperty("os.name"));
		test = extentreport.createTest("SAMPLE TEST REPORT");
		test.log(Status.PASS, "98989898989");
		extentreport.flush();
		// extentreport.notifyAll();
		System.out.println("onStart Completed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("onTestFailure  Method =" + result.getMethod().getMethodName() + " is " + ITestResult.FAILURE);
		test = extentreport.createTest(result.getMethod().getMethodName());
		test.log(Status.FAIL, result.getName());
		try {
			screenshotPath = TakeScreenshotsCls.getScreenshot(BaseClass.driver, result.getName());
			System.out.println("screenshotPath = "+screenshotPath);
			// To add Screen to Test report
			test.addScreenCaptureFromPath(screenshotPath);
			// System.out.println("screenshotPath = "+screenshotPath);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// System.out.println("screenshotPath = "+screenshotPath);
		System.out.println("onTestFailure Completed");
		extentreport.flush();
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("onTestSkipped =");
		test = extentreport.createTest(result.getMethod().getMethodName());
		test.log(Status.SKIP, result.getName());
	}

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("onTestStart Method");
		test = extentreport.createTest(result.getMethod().getMethodName());
		test.log(Status.INFO, "InformationShiva");
		extentreport.flush();
		//System.out.println("====onTestStart Method-2000 = " + test);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("onTestSuccess  Method =" + result.getMethod().getMethodName() + " is " + ITestResult.SUCCESS);
		test = extentreport.createTest(result.getMethod().getMethodName());
		test1 = extentreport.createTest(result.getMethod().getMethodName());
		// test.log(Status.PASS,result.getName() );
		test.log(Status.PASS, "onTestSuccess");

		// ======= SCREEN SHOT CODE START ========
		try {
			screenshotPath = TakeScreenshotsCls.getScreenshot(BaseClass.driver, result.getName());
			test.addScreenCaptureFromPath(screenshotPath);
			//System.out.println(" SCREEN SHOT PATH = " + screenshotPath);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// test.addScreenCaptureFromPath(screenshotPath);
		// System.out.println("destination Path = "+destination);
		// extentreport.flush();
		// ======= SCREEN SHOT CODE END ========
		test.log(Status.PASS, result.getName());
		test.log(Status.PASS, result.getMethod().getMethodName());
		test1.log(Status.PASS, "onTestSuccess1");
		extentreport.flush();
		System.out.println("onTestSuccess Completed");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		System.out.println("----onTestFailedButWithinSuccessPercentage methos in Listener-----");
	}
}

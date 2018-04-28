package learnTestNG;

import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class learnExtentReports {

	public static void main(String[] args) throws IOException {

		ExtentHtmlReporter objHTML = new ExtentHtmlReporter("./reporter/result.html");
		objHTML.setAppendExisting(true);
		
		ExtentReports objExtent = new ExtentReports();
		objExtent.attachReporter(objHTML);
		
		ExtentTest objTest = objExtent.createTest("TC001_CreateLead", "This Test case is to test Create Lead");
		objTest.assignAuthor("Raghavan");
		objTest.assignCategory("Smoke");
		
		objTest.pass("Obj Clicked successfully",MediaEntityBuilder.createScreenCaptureFromPath("./../snaps/img0.png").build());
		objTest.pass("Obj Entered successfully",MediaEntityBuilder.createScreenCaptureFromPath("./../snaps/img1.png").build());
		
		
		objExtent.flush();
		
	}

}

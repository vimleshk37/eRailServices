package reporters;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ExtentReport{
		public static void main(String[] arg) {
			ExtentReports report;
			ExtentTest test;
			
			// create ExtentReports and attach reporter(s)
			report=new ExtentReports(System.getProperty("user.dir") +"//VimleshExtent.html", true);
			
			test=report.startTest("OrangeHRM Reports start");	 //in @before
	        test.log(LogStatus.INFO, "Test Case Validation is started");	// when Test is started
	        test.log(LogStatus.PASS, "Tiltle of Page"); 	// when Test is Ended
	        test.log(LogStatus.WARNING, "Vimlesh Be Alert");	//waning message
	        test.log(LogStatus.FAIL, "Test Case Fail");	//Test Case Fail

	        test.addScreencast(System.getProperty("user.dir") +"//Vimlesh.png");
	        
	        report.flush();
	    }
}

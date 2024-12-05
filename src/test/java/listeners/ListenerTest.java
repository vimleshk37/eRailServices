package listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerTest implements ITestListener {

	@Override
	public void onStart(ITestContext context) {
		System.out.println("TestCase is srart now and its details are : " + context.getName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("Success of test cases and its details are : " + result.getName());
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("Failure of test cases and its details are : " + result.getName());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("Skip of test cases and its details are : " + result.getName());
	}
}

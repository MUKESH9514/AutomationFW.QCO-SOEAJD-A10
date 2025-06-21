package genericUtilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyserImplementation implements IRetryAnalyzer{
	
	int count = 0;
	int retryCount = 3;//we will provide this value based on manual analysis

	@Override
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		//    0<3 1<3 2<3 3!<3
		while (count<retryCount) {
			count++; //1 2 3
			return true; // retry retry retry
			
		}
		return false; // means retry stops
	}

}

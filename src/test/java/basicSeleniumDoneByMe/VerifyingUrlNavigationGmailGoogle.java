package basicSeleniumDoneByMe;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class VerifyingUrlNavigationGmailGoogle {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.gmail.com/");		
		String currentUrl = driver.getCurrentUrl();
		if(currentUrl.contains("google.com")) {
			System.out.println("Url is successfully navigating and passed");	
		}
		else {
			System.out.println("Url is not navigating and failed");
		}
		
	}

}

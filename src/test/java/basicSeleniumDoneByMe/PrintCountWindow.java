package basicSeleniumDoneByMe;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PrintCountWindow {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.naukri.com/");
		Set<String> allwhs = driver.getWindowHandles();
		int count = allwhs.size();
		System.out.println(count);
		driver.quit();
	}

}

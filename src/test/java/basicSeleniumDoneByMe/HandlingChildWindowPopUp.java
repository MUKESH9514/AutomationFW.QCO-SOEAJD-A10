package basicSeleniumDoneByMe;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingChildWindowPopUp {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		String wh = driver.getWindowHandle();
		System.out.println(wh);
		driver.close();
		

	}

}

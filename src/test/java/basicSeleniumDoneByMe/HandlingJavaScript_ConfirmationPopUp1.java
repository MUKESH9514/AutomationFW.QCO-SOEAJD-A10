package basicSeleniumDoneByMe;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HandlingJavaScript_ConfirmationPopUp1 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.automationtesting.in/Alerts.html");
		driver.findElement(By.xpath("//a[text()='Alert with Textbox ']")).click();
		driver.findElement(By.xpath("//button[@class='btn btn-info']")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.alertIsPresent());
		Alert a = driver.switchTo().alert();
		a.sendKeys("MUKESH SINGH");
		a.accept();
		String text1 = driver.findElement(By.xpath("//p[. ='Hello MUKESH SINGH How are you today']")).getText();
		if (text1.equals("Hello MUKESH SINGH How are you today")) {
        System.out.println("text is displyed and Passed");
		}
		else {
			System.out.println("text is not displyed and failed");
		}
		driver.close();

	}

}

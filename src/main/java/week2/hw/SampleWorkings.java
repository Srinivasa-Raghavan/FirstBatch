package week2.hw;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;

public class SampleWorkings {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.google.co.in/?gws_rd=ssl");
		driver.findElement(By.id("lst-ib")).sendKeys("cricket");
		driver.findElement(By.id("lst-ib")).sendKeys(Keys.TAB);
		driver.findElementByName("btnK").click();
		
		System.out.println(driver.getPageSource().split("cricket").length-1);

		
		//System.out.println(pageSource);
		

	}

}

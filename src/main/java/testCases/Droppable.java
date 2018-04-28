package testCases;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Droppable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		RemoteWebDriver driver;
		
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://jqueryui.com/sortable/");
		
		driver.switchTo().frame(0);
		
		Actions objbuilder = new Actions(driver);
		
		WebElement fromItem = driver.findElementByXPath("//li[text()='Item 1']");
		WebElement toItem = driver.findElementByXPath("//li[text()='Item 3']");
		
		objbuilder.clickAndHold(fromItem).release(toItem).perform();
		
		

	}

}

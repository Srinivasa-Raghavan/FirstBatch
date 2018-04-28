package week1.hw;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Week1ListBoxLearning {

	public static void main(String[] args) {
		
		//Launch the chrome Browser
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driverObj = new ChromeDriver();
		
		driverObj.get("http://leafground.com/");
		driverObj.manage().window().maximize();
		
		//Select the dropdown link
		driverObj.findElementByXPath("//img[@src='images/dropdown.png']").click();
		
		//Select all the dropdowns
		
		//Selecting the last by one option in the dropdown 1
		Select dd1 = new Select(driverObj.findElementById("dropdown1"));
		List<WebElement> dd1Options = dd1.getOptions();
		int dd1Count = dd1Options.size();
		dd1.selectByIndex(dd1Count-2);
		
		//Selecting the last by one option using text
		
		Select dd2 = new Select(driverObj.findElementByName("dropdown2"));
		dd2.selectByVisibleText("UFT/QTP");
		
		//Selecting the third option using value
		
		Select dd3 = new Select(driverObj.findElementById("dropdown3"));
		dd3.selectByValue("2");
		
		//Select the last dropdown using xpath
		
		Select dd4 = new Select(driverObj.findElementByXPath("//option[text()='Select your programs']/.."));
		dd4.selectByIndex(1);
		dd4.selectByIndex(4);
		
		
		//Validation
		System.out.println("Printing all the selected values in the dropdown");
		List<WebElement> dd4SelectedOptions = dd4.getAllSelectedOptions();
		for (WebElement eachSelect : dd4SelectedOptions) {
			System.out.println("Option Selected is " +eachSelect.getText());
		}
		
		driverObj.close();
		driverObj.quit();
	}

}

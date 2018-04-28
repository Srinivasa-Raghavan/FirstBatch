package week1.hw;


import org.openqa.selenium.chrome.ChromeDriver;


import allWeeksBrowserMethods.AllWeeksBrowserMethods;

public class Week1CheckBoxLearning {

	public static ChromeDriver objDriver;

	public static void main(String[] args) throws InterruptedException {

		//Calling the method to launch browser & Select Check Box
		objDriver = AllWeeksBrowserMethods.getBrowser("http://leafground.com/");

		objDriver.findElementByXPath("//img[@src='images/checkbox.png']").click();

		//deselecting the selected one

		if(objDriver.findElementByXPath("//label[text()='DeSelect only checked']/following-sibling::input[1]").isSelected())
		{
			objDriver.findElementByXPath("//label[text()='DeSelect only checked']/following-sibling::input1]").click();
		}

		if(objDriver.findElementByXPath("//label[text()='DeSelect only checked']/following-sibling::input[2]").isSelected())
		{
			objDriver.findElementByXPath("//label[text()='DeSelect only checked']/following-sibling::input[2]").click();
		}

		Thread.sleep(5000);
		objDriver.close();
		objDriver.quit();
		}

	}

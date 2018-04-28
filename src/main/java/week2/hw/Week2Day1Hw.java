package week2.hw;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import allWeeksBrowserMethods.AllWeeksBrowserMethods;

public class Week2Day1Hw {

	public static void main(String[] args) {

		String passWord = "crmsfa";
		String userName = "DemoSalesManager"; 
		String fromLeadID = "10342";
		String toLeadID = "10345";
		String finalVerify = "No records to display";

		//Initializing Chrome browser
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		ChromeDriver driver =new ChromeDriver();
		//Launch url
		driver.get("http://leaftaps.com/opentaps");
		//Maximize the browser window
		driver.manage().window().maximize();
		//Select the user Name element
		driver.findElementById("username").sendKeys(userName);
		//select the password element
		driver.findElementById("password").sendKeys(passWord);
		//select the login button
		driver.findElementByClassName("decorativeSubmit").click();
		//select the CRM/SFA linktext
		driver.findElementByLinkText("CRM/SFA").click();


		//Selecting the leads tab
		driver.findElementByLinkText("Leads").click();

		//Selecting Merge Lead tab
		driver.findElementByLinkText("Merge Leads").click();

		//Selecting the From Leads Icon
		driver.findElementByXPath("(//img[@src='/images/fieldlookup.gif'])[1]").click();

		//Calling the function to get the window list arr

		List<String> objResultList = AllWeeksBrowserMethods.GetWindowListArr(driver);

		//Switching to the second window
		driver.switchTo().window(objResultList.get(1));

		//Enter the search From Lead ID
		driver.findElementByName("id").sendKeys(fromLeadID);

		//Select the Find Leads button
		driver.findElementByXPath("//button[text()='Find Leads']").click();

		//calling Explicit Wait

		WebDriverWait objExpWait = new WebDriverWait(driver, 10);
		objExpWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[@class='x-grid3-col x-grid3-cell x-grid3-td-partyId x-grid3-cell-first ']/div/a")));

		//Selecting the first element
		driver.findElementByXPath("//td[@class='x-grid3-col x-grid3-cell x-grid3-td-partyId x-grid3-cell-first ']/div/a").click();

		//selecting the base window - or giving the control back to base window
		driver.switchTo().window(objResultList.get(0));

		//Selecting the TO Icon
		driver.findElementByXPath("(//img[@src='/images/fieldlookup.gif'])[2]").click();

		//again get the control to the new window

		objResultList = AllWeeksBrowserMethods.GetWindowListArr(driver);

		//Selecting the second window
		driver.switchTo().window(objResultList.get(1));


		//Select the LEad id field
		//Enter the search From Lead ID
		driver.findElementByName("id").sendKeys(toLeadID);

		//Select the Find Leads button
		driver.findElementByXPath("//button[text()='Find Leads']").click();

		//calling Explicit Wait

		objExpWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[@class='x-grid3-col x-grid3-cell x-grid3-td-partyId x-grid3-cell-first ']/div/a")));

		//Selecting the first element
		driver.findElementByXPath("//td[@class='x-grid3-col x-grid3-cell x-grid3-td-partyId x-grid3-cell-first ']/div/a").click();

		//selecting the base window - or giving the control back to base window
		driver.switchTo().window(objResultList.get(0));


		//Click on Merge
		driver.findElementByLinkText("Merge").click();;

		//Select ok for the Alert
		driver.switchTo().alert().accept();

		//call explicitly wait
		objExpWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("viewLead_companyName_sp")));

		//First Level Validation
		String resultID = driver.findElementById("viewLead_companyName_sp").getText();

		if (resultID.contains(toLeadID))
		{
			System.out.println("The test case pass");
		}
		else
			System.out.println("The test case fail");
		
		
		//Second Level Validation
		
		//Finding the From Lead ID from Find leads tab
		driver.findElementByLinkText("Find Leads").click();
		driver.findElementByName("id").sendKeys(fromLeadID);
		driver.findElementByXPath("//button[text()='Find Leads']").click();
		
		objExpWait.until(ExpectedConditions.visibilityOfElementLocated(By.className("x-paging-info")));
		
		if(driver.findElementByClassName("x-paging-info").getText().equals(finalVerify))
		{
			System.out.println("Entry successfully merged");
			
		}
		else
			System.out.println("Entry merge Unsuccessful");
		
		driver.close();
		driver.quit();
	}
}

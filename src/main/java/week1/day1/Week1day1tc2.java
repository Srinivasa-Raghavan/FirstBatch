package week1.day1;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Week1day1tc2 {

	public static void main(String[] args) {

		String compName,firstName,status;
		String mktgFlag;

		//Initializing Chrome browser
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		ChromeDriver driver =new ChromeDriver();
		//Launch url
		driver.get("http://leaftaps.com/opentaps");
		//Maximize the browser window
		driver.manage().window().maximize();
		//Select the user Name element
		driver.findElementById("username").sendKeys("DemoSalesManager");
		//select the password element
		driver.findElementById("password").sendKeys("crmsfa");
		//select the login button
		driver.findElementByClassName("decorativeSubmit").click();
		//select the CRM/SFA linktext
		driver.findElementByLinkText("CRM/SFA").click();
		//select the Create Lead tab using link text
		driver.findElementByLinkText("Create Lead").click();
		//select the company name field and enter the value
		driver.findElementById("createLeadForm_companyName").sendKeys("Cognizant");
		//select the createLeadForm_firstName element
		driver.findElementById("createLeadForm_firstName").sendKeys("Giri");
		//Select the createLeadForm_lastName element
		driver.findElementById("createLeadForm_lastName").sendKeys("Chandru");

		//Select a dropdown by Visible text
		Select sourceDropDown = new Select (driver.findElementById("createLeadForm_dataSourceId"));
		sourceDropDown.selectByVisibleText("Employee");
		
		//Select a dropdown using Index
		Select mktgCampDropDown = new Select (driver.findElementById("createLeadForm_marketingCampaignId"));
		List<WebElement> mktgCampDdOptions = mktgCampDropDown.getOptions();
		int mktgCampDdOptionsSize = mktgCampDdOptions.size();
		System.out.println(mktgCampDdOptionsSize);
		mktgCampDropDown.selectByIndex(mktgCampDdOptionsSize-2);
		
		
		
		
		//select the Create Lead button Using submitButton
		driver.findElementByName("submitButton").click();
		
		
		//validate the created Lead Values
		compName=driver.findElementById("viewLead_companyName_sp").getText();
		firstName = driver.findElementById("viewLead_firstName_sp").getText();
		status = driver.findElementById("viewLead_statusId_sp").getText();
		mktgFlag = driver.findElementById("viewLead_marketingCampaigns_sp").getText();
				
			
		if(compName.contains("Cognizant") && firstName.equalsIgnoreCase("Giri") && status.equalsIgnoreCase("Assigned") && mktgFlag.equalsIgnoreCase("Pay Per Click Advertising"))
		{
			System.out.println("PASS");
		}
		else
			System.out.println("FAIL");
		driver.close();
		driver.quit();
	}

}




package serviceNowTestCases;

import org.junit.Test;
import org.openqa.selenium.Keys;

import wdMethods.SeMethods;

public class CreateIndicent_TC1 extends SeMethods{
	
	@Test
	public void createIncident() throws InterruptedException {
		
		String URL = "https://dev50658.service-now.com/navpage.do";
		String userName = "admin";
		String passWord = "Clarivate@123";
		String incidentNumber;
		
		//Login to the URL
		startApp("chrome", URL);
		
		//Enter user credentials after switching to the correct frame by ID
		switchToFrameByNameID("gsft_main");
		
		type(locateElement("user_name"),userName);
		type(locateElement("user_password"),passWord);
		
		click(locateElement("sysverb_login"));
		
		//Enter the text incident in the filter text box
		Thread.sleep(12000);
		
		type(locateElement("filter"),"incident");
		
		//Select Create New option
		click(locateElement("xpath","//div[text()='Create New']"));
		
		//Switch to frame
		
		//delayUntilFrameVisible("gsft_main");
		Thread.sleep(15000);
		
		switchToFrameByNameID("gsft_main");
		
		incidentNumber = getAttributeValue(locateElement("incident.number"), "value");
		
		//Selecting the caller
		clickWithoutSnap(locateElement("xpath","//a[@id='lookup.incident.caller_id']/span"));
		
		Thread.sleep(3000);
		
		switchToWindow(1);
		
		type(locateElement("xpath","//label[text()='Search']/following-sibling::input"),"System"+Keys.ENTER);
		
		delayUntilClickable("//a[text()='System Administrator']");
		
		clickWithoutSnap(locateElement("link","System Administrator"));
		
		switchToWindow(0);
		
		switchToFrameByNameID("gsft_main");
		
		//Select the sub category
		selectDropDownUsingText(locateElement("incident.subcategory"), "Antivirus");
		
		//Type the Short & Long Description
		
		type(locateElement("incident.short_description"),"Short Description Text");
		
		type(locateElement("incident.description"),"Description Text");
		
		//Select Submit
		
		click(locateElement("sysverb_insert"));
		
		Thread.sleep(4000);
		
		//Validations Starts from here
		type(locateElement("xpath","//label[text()='Search']/following-sibling::input"),incidentNumber+Keys.ENTER);

		//delayUntilClickable("//a[@class='linked formlink']");
		
		Thread.sleep(3000);
		
		verifyExactText(locateElement("xpath","//a[@class='linked formlink']"), incidentNumber);
		
		closeAllBrowsers();
		
	}

}

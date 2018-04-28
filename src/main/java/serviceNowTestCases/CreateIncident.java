package serviceNowTestCases;

import org.junit.Test;
import org.openqa.selenium.Keys;

import wdMethods.SeMethods;

public class CreateIncident extends SeMethods {
	
	@Test
	public void createIncident() throws InterruptedException{
		
		String userName = "admin";
		String passWord = "Clarivate@123";
		String incidentNumber;
		String shortDes ="Short Description Text";
		String briefDes ="Brief Description Text";
		String URL = "https://dev50658.service-now.com/navpage.do";
		
		//Login to the URL
		startApp("chrome", URL);
		
		//Enter the user credentials & select login button
		switchToFrameByNameID("gsft_main");
		type(locateElement("user_name"),userName);
		type(locateElement("user_password"),passWord);
		click(locateElement("sysverb_login"));
		
		Thread.sleep(6000);
		
		//Select Create New incident
		type(locateElement("filter"),"incident");
		
		click(locateElement("xpath","//div[text()='Create New']/../.."));
		
		Thread.sleep(8000);
		
		switchToFrameByNameID("gsft_main");
		
		//Get the incident number
		incidentNumber = getAttributeValue(locateElement("incident.number"),"value");
		
		System.out.println(incidentNumber);
		
		//Enter Short & Brief Description
		type(locateElement("incident.short_description"),shortDes);
		type(locateElement("incident.description"),briefDes);
		
		//Navigate to Related Records
		click(locateElement("xpath","//span[text()='Related Records']"));
		
		clickWithoutSnap(locateElement("xpath","//a[@id='lookup.incident.parent_incident']/span"));
		
		Thread.sleep(5000);
		
		//Switching to window
		switchToWindow(1);
		
		type(locateElement("xpath","(//label[text()='Search'])[2]/following-sibling::input"),getText(locateElement("xpath","(//a[contains(text(),'INC')])[1]"))+Keys.ENTER);

		clickWithoutSnap(locateElement("xpath","(//a[contains(text(),'INC')])[1]"));
		
		switchToWindow(0);
		
		switchToFrameByNameID("gsft_main");
		
		click(locateElement("xpath","//span[text()='Notes']"));
		
		//Unlock the watch window
		click(locateElement("incident.watch_list_unlock"));
		
		type(locateElement("sys_display.incident.watch_list"),"a"+Keys.ARROW_DOWN+Keys.ENTER);
		
		//Select the Caller
		
		clickWithoutSnap(locateElement("lookup.incident.caller_id"));
		
		Thread.sleep(5000);
		
		switchToWindow(1);
		
		type(locateElement("xpath","(//label[text()='Search'])[2]/following-sibling::input"),"System"+Keys.ENTER);
		
		clickWithoutSnap(locateElement("link","System Administrator"));
		
		switchToWindow(0);
		
		switchToFrameByNameID("gsft_main");
		
		click(locateElement("sysverb_insert"));
		
		closeAllBrowsers();
		
		System.out.println(incidentNumber);
		
		
		
		
		
		
	}

}

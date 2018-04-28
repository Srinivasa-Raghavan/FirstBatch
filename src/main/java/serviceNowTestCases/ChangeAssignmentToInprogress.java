package serviceNowTestCases;

import org.junit.Test;
import org.openqa.selenium.Keys;

import wdMethods.SeMethods;

public class ChangeAssignmentToInprogress extends SeMethods {
	
	@Test
	public void changeAssign() throws InterruptedException{
		
		String userName = "admin";
		String passWord = "Clarivate@123";
		String incidentNumber = "INC0010027" ;
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
		
		click(locateElement("xpath","//div[text()='Open - Unassigned']/../.."));
		
		Thread.sleep(8000);
		
		switchToFrameByNameID("gsft_main");
		
		//Get the incident number & try to assign
		type(locateElement("xpath","(//label[text()='Search'])[2]/following-sibling::input"),incidentNumber+Keys.ENTER);

		click(locateElement("link",incidentNumber));
		
		Thread.sleep(4000);
		
		selectDropDownUsingIndex(locateElement("incident.state"), 1);
		
		type(locateElement("sys_display.incident.assigned_to"),"a");
		
		Thread.sleep(2000);
		
		type(locateElement("sys_display.incident.assigned_to"), ""+Keys.ARROW_DOWN+Keys.ENTER);
		
		click(locateElement("sysverb_update"));
		
		Thread.sleep(4000);
		
		//Validations
		
		//switchToDefaultContent();
		
		click(locateElement("xpath","//div[text()='All']/../.."));
		
		switchToFrameByNameID("gsft_main");
		
		type(locateElement("xpath","(//label[text()='Search'])[2]/following-sibling::input"),incidentNumber+Keys.ENTER);
		
		verifyExactText(locateElement("link",incidentNumber),incidentNumber);
		
		verifyExactText(locateElement("xpath","(//a[contains(text(),'INC')]/../..)/td[8]"),"In Progress");
		
		
		closeAllBrowsers();
		
	}

}

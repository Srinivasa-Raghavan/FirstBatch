package testCases;

import org.testng.annotations.Test;

import wdMethods.ProjectMethods;

public class MergeLeads extends ProjectMethods {
	
	@Test
	public void mergeLeads() {
		
		String fromLeadID = "11366";
		String toLeadID = "11418";
		String finalVerify = "No records to display";

		
		//Selecting the leads tab
		click(locateElement("link","Leads"));
		
		//Selecting Merge Lead tab
		click(locateElement("link","Merge Leads"));
		
		//Selecting the From Leads Icon
		clickWithoutSnap(locateElement("xpath","(//img[@src='/images/fieldlookup.gif'])[1]"));
		
		//Switching to the second window
		switchToWindow(1);
		
		//Enter the search From Lead ID
		type(locateElement("name","id"),fromLeadID);
		
		//Select the Find Leads button
		click(locateElement("xpath","//button[text()='Find Leads']"));
		
		//calling Explicit Wait

		//Calling explicit wait
		delayUntilClickable("//td[@class='x-grid3-col x-grid3-cell x-grid3-td-partyId x-grid3-cell-first ']/div/a");
		
		//Selecting the first element
		clickWithoutSnap(locateElement("xpath","//td[@class='x-grid3-col x-grid3-cell x-grid3-td-partyId x-grid3-cell-first ']/div/a"));

		//selecting the base window - or giving the control back to base window
		switchToWindow(0);

		//Selecting the TO Icon
		clickWithoutSnap(locateElement("xpath","(//img[@src='/images/fieldlookup.gif'])[2]"));

		//again get the control to the new window
		switchToWindow(1);

		//Select the LEad id field
		//Enter the search From Lead ID
		type(locateElement("name","id"),toLeadID);
		
		//Select the Find Leads button
		click(locateElement("xpath","//button[text()='Find Leads']"));

		//calling Explicit Wait
		delayUntilClickable("//td[@class='x-grid3-col x-grid3-cell x-grid3-td-partyId x-grid3-cell-first ']/div/a");

		//Selecting the first element
		clickWithoutSnap(locateElement("xpath","//td[@class='x-grid3-col x-grid3-cell x-grid3-td-partyId x-grid3-cell-first ']/div/a"));

		//selecting the base window - or giving the control back to base window
		switchToWindow(0);
		
		//Click on Merge
		clickWithoutSnap(locateElement("link","Merge"));

		//Select ok for the Alert
		acceptAlert();

		//call explicitly wait
		delayUntilVisible("id","viewLead_companyName_sp");

		
		//First Level Validation
		verifyPartialText(locateElement("viewLead_companyName_sp"), toLeadID);

		//Second Level Validation
		
		//Finding the From Lead ID from Find leads tab
		
		click(locateElement("link","Find Leads"));
		type(locateElement("name","id"), fromLeadID);
		click(locateElement("xpath","//button[text()='Find Leads']"));
		
		delayUntilVisible("class", "x-paging-info");
		
		verifyExactText(locateElement("class","x-paging-info"),finalVerify);
		
	}
	

}

package testCases;



import org.testng.annotations.Test;

import wdMethods.ProjectMethods;

public class DuplicateLead extends ProjectMethods {
	
	@Test
	public void duplicateLead() {
		
		String findLeadID = "11360";
		String company = "Cognizant";
		String fName ="Srinivasa";
		String lName ="Raghavan";
		
		findLeads();
		
		//Enter the Lead Id to be searched
		type(locateElement("name","id"),findLeadID);
		
		click(locateElement("xpath","//button[text()='Find Leads']"));
		
		//Wait program
		delayUntilClickable("(//td[@class='x-grid3-col x-grid3-cell x-grid3-td-partyId x-grid3-cell-first '])[1]/div/a");

		click(locateElement("xpath","(//td[@class='x-grid3-col x-grid3-cell x-grid3-td-partyId x-grid3-cell-first '])[1]/div/a"));
		
		//Select Duplicate lead button
		click(locateElement("link","Duplicate Lead"));
		
		//Select Create Lead without editing anything
		click(locateElement("class","smallSubmit"));
		
		
		
		
		
		//validations
		//Verify the Status text
		verifyExactText(locateElement("viewLead_statusId_sp"), "Assigned");
		
		//Verify the Company name
		verifyPartialText(locateElement("viewLead_companyName_sp"), company);
		
		//Verify the fName & lName
		verifyExactText(locateElement("viewLead_firstName_sp"),fName);
		verifyExactText(locateElement("viewLead_lastName_sp"),lName);
		verifyPartialText(locateElement("viewLead_parentPartyId_sp"),"Company");

		
	}
	

}

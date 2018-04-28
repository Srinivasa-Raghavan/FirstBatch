package testCases;



import org.testng.annotations.Test;

import wdMethods.ProjectMethods;

public class EditLead extends ProjectMethods {
	
	@Test
	public void editLead() {
		
		String findLeadID = "11361";
		String company = "Huawei";
		String fName ="Sankara";
		String lName ="Narayanan";
		
		findLeads();
		
		//Enter the Lead Id to be searched
		type(locateElement("name","id"),findLeadID);
		
		click(locateElement("xpath","//button[text()='Find Leads']"));
		
		//Wait program
		delayUntilClickable("(//td[@class='x-grid3-col x-grid3-cell x-grid3-td-partyId x-grid3-cell-first '])[1]/div/a");

		click(locateElement("xpath","(//td[@class='x-grid3-col x-grid3-cell x-grid3-td-partyId x-grid3-cell-first '])[1]/div/a"));
		
		//Select Edit lead button
		click(locateElement("link","Edit"));
		
		//Change the fields
		type(locateElement("updateLeadForm_companyName"),company);
		type(locateElement("updateLeadForm_firstName"),fName);
		type(locateElement("updateLeadForm_lastName"),lName);
		
		//Select Update Lead 
		click(locateElement("xpath","(//input[@name='submitButton'])[1]"));
		
		
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

package testCases;


import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import utils.ReadExcel;
import wdMethods.ProjectMethods;

public class DeleteLead extends ProjectMethods {
	
	@Test(dataProvider="testData")
	public void deleteLead(String findLeadID) {
		
		findLeads();
		
		//Enter the Lead Id to be searched
		type(locateElement("name","id"),findLeadID);
		
		click(locateElement("xpath","//button[text()='Find Leads']"));
		
		//Wait program
		delayUntilClickable("(//td[@class='x-grid3-col x-grid3-cell x-grid3-td-partyId x-grid3-cell-first '])[1]/div/a");

		click(locateElement("xpath","(//td[@class='x-grid3-col x-grid3-cell x-grid3-td-partyId x-grid3-cell-first '])[1]/div/a"));
		
		click(locateElement("link","Delete"));
		
		//validations
		verifyExactText(locateElement("xpath","//span[text()='Lead List']"), "Lead List");
		
		click(locateElement("link","Find Leads"));
		
		type(locateElement("name","id"),findLeadID);
		
		click(locateElement("xpath","//button[text()='Find Leads']"));
		
		//Wait program
		delayUntilVisible("class", "x-paging-info");
		
		verifyExactText(locateElement("class","x-paging-info"), "No records to display");
		
		
		
		
	}
	
	@DataProvider(name="testData")
	public Object[][] getData() throws IOException
	{
		//Get the data from Excel
		
		ReadExcel rds = new ReadExcel();
		
		Object[][] testData=rds.readExcel("DeleteLead");
		
		return testData;
	}

}

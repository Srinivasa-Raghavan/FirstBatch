package testCases;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import utils.ReadExcel;
import wdMethods.ProjectMethods;

public class CreateLead extends ProjectMethods {

	@Test(dataProvider="testData")
	public void createLead(String cName, String fName, String lName, String index,String viText) throws InterruptedException
	{
		
		//Select Create Lead Link
		click(locateElement("link","Create Lead"));

		//Enter the basic fields including few dropdowns
		type(locateElement("createLeadForm_companyName"),cName);

		type(locateElement("createLeadForm_firstName"),fName);

		type(locateElement("createLeadForm_lastName"),lName);

		//Selecting Conference as the option
		selectDropDownUsingIndex(locateElement("createLeadForm_dataSourceId"), Integer.parseInt(index));

		//Selecting Automobile as the option
		selectDropDownUsingText(locateElement("createLeadForm_marketingCampaignId"), viText);

		//Selecting the Parent group by switching to the window
		click(locateElement("xpath","//img[@src='/images/fieldlookup.gif']"));

		switchToWindow(1);

		clickWithoutSnap(locateElement("xpath","(//td[@class='x-grid3-col x-grid3-cell x-grid3-td-partyId x-grid3-cell-first '])[3]/div/a"));

		switchToWindow(0);

		click(locateElement("name","submitButton"));

		//Verify the Status text
		verifyExactText(locateElement("viewLead_statusId_sp"), "Assigned");

		//Verify the Company name
		verifyPartialText(locateElement("viewLead_companyName_sp"), cName);

		//Verify the fName & lName
		verifyExactText(locateElement("viewLead_firstName_sp"),fName);
		verifyExactText(locateElement("viewLead_lastName_sp"),lName);
		
	}
	
	@DataProvider(name="testData")
	public Object[][] getData() throws IOException
	{
		//Get the data from Excel
		
		ReadExcel rds = new ReadExcel();
		
		Object[][] testData=rds.readExcel("CreateLead");
		
		return testData;
	}
}

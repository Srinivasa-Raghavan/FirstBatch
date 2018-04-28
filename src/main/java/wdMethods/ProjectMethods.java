package wdMethods;

import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class ProjectMethods extends SeMethods{
	
	@Parameters({"url","uName","pwd"})
	@BeforeMethod
	public void loginToURL(String url, String uName, String pwd) {
		
		//Login to the URL
		startApp("chrome", url);
		
		//Enter UserName & password
		WebElement userName = locateElement("username");
		type(userName, uName);
		
		WebElement password = locateElement("password");
		type(password, pwd);
		
		WebElement login = locateElement("class", "decorativeSubmit");
		click(login);
		
		//Select CRM/SFA link
		click(locateElement("link","CRM/SFA"));

	}
	
	@AfterMethod
	public void closeApp()
	{
		closeBrowser();
		closeAllBrowsers();
	}
	
	public void findLeads()
	{
		//Selecting the leads tab
		click(locateElement("link","Leads"));
		
		//Selecting Find Leads tab
		click(locateElement("link","Find Leads"));
		
	}

}

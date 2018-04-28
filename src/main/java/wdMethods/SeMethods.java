package wdMethods;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeMethods implements WdMethods{

	public static RemoteWebDriver driver;
	int imgctr;
	public static WebDriverWait objExpWait;

	@Override
	public void startApp(String browser, String url) {
		if(browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"./drivers/chromedriver.exe");		
			driver = new ChromeDriver();			
		}else if(browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver",
					"./drivers/geckodriver.exe");		
			driver = new FirefoxDriver();		
		}		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(url);		
		System.out.println("The Browser "+browser+" launched Successfully");
		
		//Declaring Explicit wait time
		objExpWait = new WebDriverWait(driver, 25);
		takeSnap();
	}

	@Override
	public WebElement locateElement(String locator, String locValue) {

		switch(locator) {		
		case "id": return driver.findElementById(locValue);
		case "name": return driver.findElementByName(locValue);
		case "link": return driver.findElementByLinkText(locValue);
		case "class": return driver.findElementByClassName(locValue);
		case "xpath": return driver.findElementByXPath(locValue);		
		}		
		return null;
	}

	@Override
	public WebElement locateElement(String locValue) {
		return driver.findElementById(locValue);	
	}

	@Override
	public void type(WebElement ele, String data) {
		ele.clear();
		ele.sendKeys(data);
		System.out.println("The Element "+ele+" is entered with "+data);
		takeSnap();
	}

	@Override
	public void click(WebElement ele) {
		ele.click();
		System.out.println("The Element "+ele+" is clicked");
		takeSnap();

	}

	@Override
	public void clickWithoutSnap(WebElement ele) {
		ele.click();

	}

	@Override
	public String getText(WebElement ele) {
		//returns the visible text in the given webelement
		takeSnap();
		return ele.getText();

	}

	@Override
	public void selectDropDownUsingText(WebElement ele, String value) {
		// Select the dropdown values using visible text

		Select dropDown = new Select(ele);
		dropDown.selectByVisibleText(value);
		takeSnap();
	}

	@Override
	public void selectDropDownUsingIndex(WebElement ele, int index) {
		// Select the dropdown values using index

		Select dropDown = new Select(ele);
		dropDown.selectByIndex(index);
		takeSnap();
	}

	@Override
	public boolean verifyTitle(String expectedTitle) {
		// Verify the title

		if(driver.getTitle().equals(expectedTitle)) {
			takeSnap();
			return true;
		}
		else {
			takeSnap();
			return false;
		}

	}

	@Override
	public void verifyExactText(WebElement ele, String expectedText) {
		// Verify the exact text of the given element

		if(ele.getText().equals(expectedText))
		{
			System.out.println("The Visible Text of the element: "+ele+"EXACTLY matches");
		}
		else {
			System.out.println("The Visible Text of the element: "+ele+"NOT matches");
		}
		takeSnap();
	}

	@Override
	public void verifyPartialText(WebElement ele, String expectedText) {
		// Verify the partial text of the given element

		if(ele.getText().contains(expectedText))
		{
			System.out.println("The Visible Text of the element: "+ele+"Partially matches");
		}
		else {
			System.out.println("The Visible Text of the element: "+ele+"doesn't contains the expected text");
		}

		takeSnap();

	}

	@Override
	public void verifyExactAttribute(WebElement ele, String attribute, String value) {
		// Verifies the attribute value exactly matches with the expected value in the given webelement

		if(ele.getAttribute(attribute).equals(value))
		{
			System.out.println("The attribute value of the element: "+ele+"EXACTLY matches");
		}
		else {
			System.out.println("The attribute value of the element: "+ele+"doesn't Matches");
		}		
		takeSnap();
	}

	@Override
	public void verifyPartialAttribute(WebElement ele, String attribute, String value) {
		// Verifies the attribute value Partially matches with the expected value in the given webelement

		if(ele.getAttribute(attribute).contains(value))
		{
			System.out.println("The attribute value of the element: "+ele+"Partially matches");
		}
		else {
			System.out.println("The attribute value of the element: "+ele+"doesn't Matches");
		}		
		takeSnap();

	}

	@Override
	public void verifySelected(WebElement ele) {
		//Verify whether the element is selected
		if(ele.isSelected())
		{
			System.out.println("The Element" +ele +"is Selected");
		}
		else {
			System.out.println("The Element" +ele +"is NOT Selected");
		}		
		takeSnap();
	}

	@Override
	public void verifyDisplayed(WebElement ele) {
		//Verify whether the element is displayed
		if(ele.isDisplayed())
		{
			System.out.println("The Element" +ele +"is Displayed");
		}
		else {
			System.out.println("The Element" +ele +"is NOT Displayed");
		}

		takeSnap();
	}

	@Override
	public void switchToWindow(int index) {
		//switch to window with the index given

		Set<String> allWindows = driver.getWindowHandles();
		List<String> allList = new ArrayList<String>();
		allList.addAll(allWindows);
		System.out.println(allList.size());

		driver.switchTo().window(allList.get(index));
		takeSnap();
	}

	@Override
	public void switchToFrame(WebElement ele) {
		//switch to the specific frame (ele)
		driver.switchTo().frame(ele);
		takeSnap();
	}

	@Override
	public void acceptAlert() {
		//accept the alert
		driver.switchTo().alert().accept();

	}

	@Override
	public void dismissAlert() {
		//dismissing the alert
		driver.switchTo().alert().dismiss();

	}

	@Override
	public String getAlertText() {
		//returns the alert text
		return driver.switchTo().alert().getText();
	}

	@Override
	public void takeSnap() {
		//take snapshot and save as png in the project path
		File src = driver.getScreenshotAs(OutputType.FILE);
		File desc = new File("./snaps/img"+imgctr+".png");
		try {
			FileUtils.copyFile(src, desc);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		imgctr++;

	}

	@Override
	public void closeBrowser() {

		driver.close();

	}

	@Override
	public void closeAllBrowsers() {

		driver.quit();

	}
	
	@Override
	public void delayUntilClickable(String xPath) {
		
		objExpWait.until(ExpectedConditions.elementToBeClickable(By.xpath(xPath)));

		
	}

	@Override
	public void delayUntilVisible(String type, String value) {
		
		if(type.equalsIgnoreCase("id"))
		{
			objExpWait.until(ExpectedConditions.visibilityOfElementLocated(By.id(value)));
		}
		
		if(type.equalsIgnoreCase("class"))
		{
			objExpWait.until(ExpectedConditions.visibilityOfElementLocated(By.className(value)));
		}
		
		
	}
	
	@Override
	public void switchToFrameByNameID(String value) {
		
		driver.switchTo().frame(value);
	}
	
	@Override
	public String getAttributeValue(WebElement ele,String attributeName) {
		
		return ele.getAttribute(attributeName);
	}
	
	
	@Override
	public void delayUntilFrameVisible(String frameNameID) {
		
		objExpWait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id(frameNameID)));

		
	}


}

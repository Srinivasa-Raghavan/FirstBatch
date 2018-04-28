package allWeeksBrowserMethods;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AllWeeksBrowserMethods {

	//Reusable function for getting the active window list in the List Array format 
	public static List<String> GetWindowListArr(WebDriver driverobj)
	{
		//Moving the control to the next window

		Set<String> objAllWindows = driverobj.getWindowHandles();

		//converting the Set to List
		List<String> objAllWinList = new ArrayList<String>();
		objAllWinList.addAll(objAllWindows);

		return objAllWinList;
	}

	public static ChromeDriver getBrowser(String userURL)
	{
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driverObj = new ChromeDriver();

		driverObj.get(userURL);
		driverObj.manage().window().maximize();
		return driverObj;
	}
}

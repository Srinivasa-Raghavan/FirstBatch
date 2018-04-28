package week1.day1;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Week1HWDay1 {

	public static String userID;
	public static String password;
	public static int securityQu;
	public static String securityAns;
	public static String prefLang;
	public static String fName, lName, mName, date, month, year;
	public static char gender,martialStatus;
	public static String occupation;
	public static String country;
	public static int isdCode,mobNum;
	public static String emailID;
	public static String nationality, doorNo,street,area;
	public static String indState, indCity, indPostOffice;
	public static String otherState,otherCity;
	public static int pincode;
	public static String phone;

	public static void main(String[] args) throws InterruptedException {

		String nationalValid;
		boolean otherCount = false;
		String pinValid = "Please enter corret Pincode";
		//Initialize the Google Chrome Driver

		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver objDriver = new ChromeDriver();
		//Launch the irctc user Signup page
		objDriver.get("https://www.irctc.co.in/eticketing/userSignUp.jsf");
		objDriver.manage().window().maximize();
		
		//initialise the variables
		initialiseVariables();

		//Enter the user ID
		objDriver.findElementById("userRegistrationForm:userName").sendKeys(userID);

		//Enter the password & Confirm password field
		objDriver.findElementById("userRegistrationForm:password").sendKeys(password);
		objDriver.findElementById("userRegistrationForm:confpasword").sendKeys(password);

		//Select the Security Question by Index
		Select securityQuDD = new Select(objDriver.findElementById("userRegistrationForm:securityQ"));
		securityQuDD.selectByIndex(securityQu);

		//Enter the security answer
		objDriver.findElementById("userRegistrationForm:securityAnswer").sendKeys(securityAns);

		//Select the preferred language by visible Text - Send Keys
		objDriver.findElementById("userRegistrationForm:prelan").sendKeys(prefLang);

		//Enter Name fields
		objDriver.findElementById("userRegistrationForm:firstName").sendKeys(fName);
		objDriver.findElementById("userRegistrationForm:middleName").sendKeys(mName);
		objDriver.findElementById("userRegistrationForm:lastName").sendKeys(lName);

		//Select the Gender field

		switch (gender) {
		case 'M':
			objDriver.findElementByXPath("//*[@id='userRegistrationForm:gender:0']").click();
			break;
		case 'F':
			objDriver.findElementByXPath("//*[@id='userRegistrationForm:gender:1']").click();
			break;
		case 'T':
			objDriver.findElementByXPath("//*[@id='userRegistrationForm:gender:2']").click();
			break;
		default:
			objDriver.findElementByXPath("//*[@id='userRegistrationForm:gender:0']").click();
			break;
		}
		
		
		//Select Martial Status field
		
		switch (martialStatus) {
		case 'M':
			objDriver.findElementByXPath("//*[@id='userRegistrationForm:maritalStatus:0']").click();
			break;
		case 'U':
			objDriver.findElementByXPath("//*[@id='userRegistrationForm:maritalStatus:1']").click();
			break;
		default:
			objDriver.findElementByXPath("//*[@id='userRegistrationForm:maritalStatus:0']").click();
			break;
		}

		//Select DOB - Select Class
		Select dateDD = new Select( objDriver.findElementById("userRegistrationForm:dobDay"));
		dateDD.selectByVisibleText(date);
		Select monthDD = new Select( objDriver.findElementById("userRegistrationForm:dobMonth"));
		monthDD.selectByVisibleText(month);
		Select yearDD = new Select( objDriver.findElementById("userRegistrationForm:dateOfBirth"));
		yearDD.selectByVisibleText(year);


		//Select Occupation by Index - Search the input visibe text and select the same using Index
		Select occupationDD = new Select(objDriver.findElementById("userRegistrationForm:occupation"));
		List<WebElement> occuOptions = occupationDD.getOptions();
		for (WebElement eachOccuOptions : occuOptions) {
			if(eachOccuOptions.getText().equals(occupation))
			{
				eachOccuOptions.click();
				break;
			}
		}


		//Select the country again using the same above logic and validate it is outside India


		Select countryDD = new Select(objDriver.findElementById("userRegistrationForm:countries"));
		List<WebElement> countryOptions = countryDD.getOptions();
		for (WebElement eachCountryOptions : countryOptions) {
			if(eachCountryOptions.getText().equals(country))
			{
				eachCountryOptions.click();
				break;
			}
		}

		//Validate it is outside India
		try {
			nationalValid = objDriver.findElementById("userRegistrationForm:nationalityIdmsg").getText();
		} catch (NoSuchElementException e) {
			nationalValid = "";
		}
		

		if(nationalValid.equals("International/NRI users with ISD code other than 91 have to pay Registration fees after successful registration i.e. on first login. Please note that the Registration fee for International/NRI users is Rs.  100 + GST."))
		{
			System.out.println("Select Country is Outside India");
			//Set the ISD Code
			objDriver.findElementById("userRegistrationForm:isdCode").sendKeys(Integer.toString(isdCode));
			otherCount = true;
		}

		//Set the Mobile Number
		objDriver.findElementById("userRegistrationForm:mobile").sendKeys(Integer.toString(mobNum));

		//Set the email ID
		objDriver.findElementById("userRegistrationForm:email").sendKeys(emailID);

		//Set the Nationality
		objDriver.findElementById("userRegistrationForm:nationalityId").sendKeys(nationality);


		//Enter the address fields

		objDriver.findElementById("userRegistrationForm:address").sendKeys(doorNo);
		objDriver.findElementById("userRegistrationForm:street").sendKeys(street);
		objDriver.findElementById("userRegistrationForm:area").sendKeys(area);

		//if country is other than India, no checking for Pincode, state & city
		if(otherCount == true)
		{
			objDriver.findElementById("userRegistrationForm:pincode").sendKeys(Integer.toString(pincode),Keys.TAB);
			objDriver.findElementById("userRegistrationForm:otherState").sendKeys(otherState);
			objDriver.findElementById("userRegistrationForm:otherCityId").sendKeys(otherCity);
		}
		else
		{
			while (pinValid.equals("Please enter corret Pincode"))
			{
				objDriver.findElementById("userRegistrationForm:pincode").sendKeys(Integer.toString(pincode),Keys.TAB);
				Thread.sleep(4000);

				//Check whether the error message element present or not
				try {
					pinValid=objDriver.findElementById("userRegistrationForm:pincodeError").getText();
				} catch (NoSuchElementException e) {
					pinValid = "test" ;
				}
			}

			// If Pincode is correct, state will be autopopulated

			Select cityOptions = new Select(objDriver.findElementById("userRegistrationForm:cityName"));
			cityOptions.selectByIndex(1);

			Select poOptions = new Select(objDriver.findElementById("userRegistrationForm:postofficeName"));
			poOptions.selectByIndex(1);

		}


		//Set the Phone
		objDriver.findElementById("userRegistrationForm:landline").sendKeys(phone);
		objDriver.close();
		objDriver.quit();
	}


	public static void initialiseVariables() {

		userID = "Testing";
		password = "test";
		securityQu = 2; //Index of the dropdown
		securityAns = "Chennai";
		prefLang = "English"; //Visibile text of the dropdown - Question here is how to handle Hindi
		fName = "Srinivasa";
		mName = "Balaji";
		lName = "Raghavan";
		gender = 'M';
		martialStatus = 'M';
		date ="10";
		month="JUN";
		year ="1966";
		occupation="Others";
		country = "San Marino";
		isdCode = 888;
		mobNum = 987654321;
		emailID = "test@gmail.com";
		nationality = "Argentina";
		doorNo = "24 B Block";
		street = "Sangam Street";
		area = "Thaluk area";
		otherState="Dubai";
		otherCity="Dubai Mainroad";
		phone = "04443231212";
		pincode = 600081;
	}

}

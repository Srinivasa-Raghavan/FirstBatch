package allWeeksReusableMethods;

public class AllWeeksCommonMethods {

	//Method to check whether the input string is Palindrome or not
	private static boolean compareStr;

	public static void ChkPaliandrome( String inputStr)
	{
		//Check whether the given string is empty or only spaces
		if((inputStr.trim()).isEmpty())
			System.out.println("Enter a valid string");
		else
		{
			//covert input string to char array
			char[] wordArry= inputStr.toCharArray();

			char[] revChar = new char[wordArry.length];
			int j=0;
			for (int i = wordArry.length-1; i>=0; i--) {
				//revChar[i]=(char) (wordArry[i]);
				revChar[j]=(char) (wordArry[i]);
				j++;
			}
			//Compare Input word and reversed word and check whether it is palindrome
			String revStr=String.valueOf(revChar);
			compareStr = inputStr.equalsIgnoreCase(revStr);
			
			if (compareStr == true)
				System.out.println("The Word "+inputStr+" is a Paliandrome");
			else
				System.out.println("The Word "+inputStr+" is not a Paliandrome");
		}
	}
	
	//Method to calculate the Factorial the given number
	
	public static void CalcFactorial(int inputNum)
	{
		//Check whether the given input > 0, then calculate Factorial
		if(inputNum > 0)
		{
			int ctr1;
			double result;
			
			result = 1;
			for(ctr1=inputNum; ctr1>0; ctr1--)
			{
				result = result*ctr1;
			}
			
			System.out.println("The Factorial of the number " +inputNum +" is " +result);
			
		}
		//If the input <=0 then print the message
		else
			System.out.println("Enter a valid Integer");
	}


	//Method to check whether the given Integer is Palindrome
	
	public static void ChkIntPalindrome(int inputNum)
	{
		//Check whether the given input > 0, then check for Palindrome
		if(inputNum > 0)
		{
			int Ctr1;
			int resultNum;
			int reminder;
			
			Ctr1 = inputNum;
			resultNum = 0;
			do
			{
				reminder = inputNum % 10;
				resultNum = reminder +( resultNum * 10);
				inputNum = inputNum / 10;
			}while(inputNum > 0);
			
			if(resultNum == Ctr1)
			{
				System.out.println("The given number "+Ctr1 +" is a Palindrome");
			}
			else
			{
				System.out.println("The given number "+Ctr1 +" is NOT a Palindrome");
			}
		}
		else
			System.out.println("Enter a valid Integer");
	}



	//Method to check whether the given Integer is Prime Number
	
	public static void ChkPrimeNumber(int inputNum)
	{
		//Check whether the given input > 1, then check for Prime
		if(inputNum >1)
		{			
			if((inputNum%2 == 0) || (inputNum%3==0) || (inputNum%4==0) || (inputNum%5==0))
			{
				System.out.println("The given number "+inputNum +" is NOT a Prime Number");
			}
			else
			{
				System.out.println("The given number "+inputNum +" is a Prime Number");
			}
		}
		else if(inputNum == 1)
			System.out.println("The Number 1 is a Prime number");
		else
			System.out.println("Enter a valid Integer");
	}

}

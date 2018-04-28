package week1MainFunction;

public class PaliandromeValidation {
	private static boolean compareStr;

	public static void ChkPaliandrome( String inputStr)
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
		System.out.println(inputStr);
		System.out.println(revStr);
		System.out.println(compareStr);

		if (compareStr == true)
			System.out.println("The Word "+inputStr+" is a Paliandrome");
		else
			System.out.println("The Word "+inputStr+" is not a Paliandrome");
	}

}



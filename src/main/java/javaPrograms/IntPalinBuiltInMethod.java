package javaPrograms;

import java.util.Scanner;

public class IntPalinBuiltInMethod {

	public static void main(String[] args) {
		int userInput;
		int ctr1;
		String convertedString;
		String reversedString = "";
		
		Scanner inputScan = new Scanner(System.in);
		
		System.out.println("Enter a number to check whether it is Palindrome");
		userInput = inputScan.nextInt();
		
		convertedString = Integer.toString(userInput);
		
		for(ctr1=convertedString.length()-1;ctr1>=0; ctr1--)
		{
			reversedString = reversedString + convertedString.charAt(ctr1);
		}
		
		//Printing the reversed string
		System.out.println("The reversed Integer is "+reversedString);
		
		if(reversedString.equalsIgnoreCase(convertedString))
		{
			System.out.println("The given integer is a Palindrome");
		}
		else
		{
			System.out.println("The given integer is NOT a Palindrome");
		}
		
		inputScan.close();
	}

}

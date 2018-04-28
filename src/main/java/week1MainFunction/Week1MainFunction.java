package week1MainFunction;

import java.util.Scanner;

import allWeeksReusableMethods.*;

public class Week1MainFunction {

	static Scanner inputScan; 
	public static void main(String[] args) {

		int userChoice;
		//Call the function for the given input from the user
		System.out.println("Enter the Choice - For which Program to execute");
		System.out.println("***********************************************");

		//Get the input from the user
		inputScan = new Scanner(System.in);

		userChoice=inputScan.nextInt();
		
		switch (userChoice) {
		case 1:
		{
			//This case is to check whether the input string is Palindrome or not
			System.out.println("You are into the program for checking the given string for Palindrome");
			System.out.println("*********************************************************************");
			Scanner indiScan = new Scanner(System.in);
			String inputStrFromUser = indiScan.nextLine();
			AllWeeksCommonMethods.ChkPaliandrome(inputStrFromUser);
			indiScan.close();
			break;
		}
		
		case 2:
		{
			//This case is to calculate the Factorial of the given number
			System.out.println("You are into the program for calculating the Factorial");
			System.out.println("******************************************************");
			Scanner indiScan = new Scanner(System.in);
			int inputNumFromUser = indiScan.nextInt();
			AllWeeksCommonMethods.CalcFactorial(inputNumFromUser);
			indiScan.close();
			break;
		}

		case 3:
		{
			//This case is to check whether the given integer is Palindrome
			System.out.println("You are into the program for checking the given integer for Palindrome");
			System.out.println("*********************************************************************");
			Scanner indiScan = new Scanner(System.in);
			int inputIntFromUser = indiScan.nextInt();
			AllWeeksCommonMethods.ChkIntPalindrome(inputIntFromUser);
			indiScan.close();
			
			break;
		}
		
		case 4:
		{
			//This case is to check whether the given integer is Prime Number or not
			System.out.println("You are into the program for checking the given integer for Prime");
			System.out.println("*********************************************************************");
			Scanner indiScan = new Scanner(System.in);
			int inputIntFromUser = indiScan.nextInt();
			AllWeeksCommonMethods.ChkPrimeNumber(inputIntFromUser);
			indiScan.close();
			
			break;
		}

		default:
		{
			System.out.println("Enter a valid input");
			break;
		}
		}
		

	}

}

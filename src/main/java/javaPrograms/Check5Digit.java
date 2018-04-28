package javaPrograms;

import java.util.Scanner;

public class Check5Digit {

	public static void main(String[] args) {
		
		String userInput;
		//String ConvString;
		
		//Get the input from the user
		Scanner inputScan = new Scanner(System.in);
		System.out.println("Enter a number");
		
		userInput = inputScan.next();
		
		//ConvString = Double.toString(userInput);
		
		if(userInput.length() == 5 && (!userInput.contains(".")))
		{
			System.out.println("true");
		}
		else
		{
			System.out.println("false");
		}
		
		inputScan.close();

	}

}

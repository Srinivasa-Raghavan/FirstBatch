package javaPrograms;

import java.util.Scanner;

public class ReverseStringWithoutSpaces {

	public static void main(String[] args) {
		int ctr1;
		String userInput;
		String resultString = "";
		
		Scanner inputScan = new Scanner(System.in);
		
		System.out.println("Enter the string");
		userInput = inputScan.nextLine();
		
		System.out.println("Printing the characters of the string in reverse after removing spaces");
		System.out.println("**********************************************************************");
		System.out.println("");
		
		for(ctr1=userInput.length()-1;ctr1>=0;ctr1--)
		{
			if(!(userInput.charAt(ctr1)== ' ')){
				resultString = resultString + userInput.charAt(ctr1);
			}
		}
		
		System.out.println("The reversed string is "+resultString);
		
		inputScan.close();

	}

}

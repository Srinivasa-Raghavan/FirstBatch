package javaPrograms;

import java.util.Scanner;

public class OccurenceOfCharInString {

	public static void main(String[] args) {
		
		int ctr1,count;
		String userInput;
		char resultString;
		
		Scanner inputScan = new Scanner(System.in);
		
		System.out.println("Enter the string");
		userInput = inputScan.nextLine();
		
		System.out.println("Enter the Character to be counted in the given string");
		resultString = inputScan.nextLine().charAt(0);
		
		System.out.println("Printing the Number of Occurrenes of the Given char in the String");
		System.out.println("*****************************************************************");
		System.out.println("");
		
		count = 0;
		for(ctr1=userInput.length()-1;ctr1>=0;ctr1--)
		{
			if((Character.toLowerCase(userInput.charAt(ctr1))== Character.toLowerCase(resultString))){
				count++;
			}
		}
		
		System.out.println("The Count of char in the given string is "+count);
		
		inputScan.close();

	}

}

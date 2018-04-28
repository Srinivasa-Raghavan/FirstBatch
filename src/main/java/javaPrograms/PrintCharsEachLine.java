package javaPrograms;

import java.util.Scanner;

public class PrintCharsEachLine {

	public static void main(String[] args) {
		
		int ctr1;
		String userInput;
		
		Scanner inputScan = new Scanner(System.in);
		
		System.out.println("Enter the string");
		userInput = inputScan.nextLine();
		
		System.out.println("Printing the characters of the string in each line");
		System.out.println("**************************************************");
		System.out.println("");
		
		for(ctr1=0;ctr1<userInput.length();ctr1++)
		{
			System.out.println(userInput.charAt(ctr1));
		}
		
		inputScan.close();

	}

}

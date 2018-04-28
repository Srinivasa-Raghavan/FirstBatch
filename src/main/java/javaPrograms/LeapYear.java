package javaPrograms;

import java.util.Scanner;

public class LeapYear{

	public static void main(String args[]){

	int inputYear;

	Scanner inputScan = new Scanner(System.in);

	//Getting the user input
	System.out.println("Enter the Year (YYYY) to find whether it is leap year or not");

	inputYear = inputScan.nextInt();

	//Checking whether the Year is divisble by 100

	if(inputYear%100 == 0)
	{
		//Checking whether the Year is divisble by 400
		if(inputYear%400 == 0)
		{
			System.out.println("The Given year " +inputYear +" is a Leap Year");
		}
		else
		{
			System.out.println("The Given year " +inputYear +" is NOT a Leap Year");
		}
	}
	//if the Year is not divisble by 100
	else
	{
		//Checking whether the Year is divisble by 4
		if(inputYear%4 == 0)
		{
			System.out.println("The Given year " +inputYear +" is a Leap Year");
		}
		else
		{
			System.out.println("The Given year " +inputYear +" is NOT a Leap Year");
		}
	}

	inputScan.close();
	}

}

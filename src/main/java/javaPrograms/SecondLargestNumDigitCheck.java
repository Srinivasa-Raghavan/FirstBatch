package javaPrograms;

import java.util.Scanner;
import java.util.*;

public class SecondLargestNumDigitCheck
{

	public static ArrayList<Integer> list;

	public static void main(String args[])
	{

	int ctr1;
	int number, digit;
	boolean flag;

	list=new ArrayList<Integer>();

	System.out.println("Enter the number :");

	Scanner inputScan = new Scanner(System.in);

	number = inputScan.nextInt();

	System.out.println("Enter the search digit:");
	
	digit = inputScan.nextInt();

	if(number>0)
	{
	for(ctr1=number-1;ctr1>0;ctr1--)
	{
		getDigits(ctr1);

		flag = true;

		for(int compareDigit : list)
		{ 
			if(compareDigit == digit)
			{
				flag = false;
				list.clear();
				break;
			}
		}

		if(flag == true)
		{
			System.out.println("The largest number is: " +ctr1);
			break;
		}

	}
	}
	else
	{
		System.out.println("Enter a valid number");
	}

	inputScan.close();

	}


	public static void getDigits(int num)
	{
		int reminder;

		while(num>0)
		{
			reminder = num%10;		
			list.add(reminder);			
			num=num/10;
		}			
	
		
	}

}
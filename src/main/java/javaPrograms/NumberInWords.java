package javaPrograms;

import java.util.ArrayList;
import java.util.Scanner;

public class NumberInWords {

	public static ArrayList<Integer> list;

	public static void main(String[] args) {

		int number;

		Scanner inputScan = new Scanner(System.in);

		System.out.println("Enter any 3 Digit Number");
		number = inputScan.nextInt();

		if (number>999 || number < 100)
		{
			System.out.println("Enter a valid 3 digit number");
		}
		else
		{
			//Getting the digits of the number
			list=new ArrayList<Integer>();
			getDigits(number);

			switch (list.get(2))
			{
			case 1: System.out.print("One Hundred"); break;
			case 2: System.out.print("Two Hundred"); break;
			case 3: System.out.print("Three Hundred"); break;
			case 4: System.out.print("Four Hundred"); break;
			case 5: System.out.print("Five Hundred"); break;
			case 6: System.out.print("Six Hundred"); break;
			case 7: System.out.print("Seven Hundred"); break;
			case 8: System.out.print("Eight Hundred"); break;
			case 9: System.out.print("Nine Hundred"); break;
			default: break;
			}
			switch (list.get(1))
			{
			case 1: 
			{
				switch (list.get(0))
				{
				case 0: System.out.print(" and Ten "); break;
				case 1: System.out.print(" and Eleven "); break;
				case 2: System.out.print(" and Twelve "); break;
				case 3: System.out.print(" and Thirteen "); break;
				case 4: System.out.print(" and Fourteen "); break;
				case 5: System.out.print(" and Fifteen "); break;
				case 6: System.out.print(" and Sixteen "); break;
				case 7: System.out.print(" and Seventeen "); break;
				case 8: System.out.print(" and Eighteen "); break;
				case 9: System.out.print(" and Nineteen "); break;
				default: break;
				}
				break;
			}
			case 2: System.out.print(" and Twenty"); break;
			case 3: System.out.print(" and Thirty"); break;
			case 4: System.out.print(" and Forty"); break;
			case 5: System.out.print(" and Fifty"); break;
			case 6: System.out.print(" and Sixty"); break;
			case 7: System.out.print(" and Seventy"); break;
			case 8: System.out.print(" and Eighty"); break;
			case 9: System.out.print(" and Ninety"); break;
			default: break;
			}

			switch (list.get(0))
			{
			case 1: 
			{
				if(list.get(1) != 1)
				{System.out.print(" One");} break;
			}
			case 2: {
				if(list.get(1) != 1)
				{System.out.print(" Two");} break;
			}
			case 3: {
				if(list.get(1) != 1)
				{System.out.print(" Three");} break;
			}
			case 4: {
				if(list.get(1) != 1)
				{System.out.print(" Four");} break;
			}
			case 5: {
				if(list.get(1) != 1)
				{System.out.print(" Five");} break;
			}
			case 6: {
				if(list.get(1) != 1)
				{System.out.print(" Six");} break;
			}
			case 7: {
				if(list.get(1) != 1)
				{System.out.print(" Seven");} break;
			}
			case 8: {
				if(list.get(1) != 1)
				{System.out.print(" Eight");} break;
			}
			case 9:{
				if(list.get(1) != 1)
				{System.out.print(" Nine");} break;
			}
			default: break;
			}
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

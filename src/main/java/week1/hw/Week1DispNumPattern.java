package week1.hw;

import java.util.Scanner;

public class Week1DispNumPattern {

	public static void main(String[] args) {
		// Get the two numbers from the user
		
		int num1, num2;
		Scanner inputScan = new Scanner(System.in);
		
		System.out.println("Enter the two numbers");
		num1 = inputScan.nextInt();
		num2 = inputScan.nextInt();
		
		//Check whether to print the logic from Num1 to num2 or vice versa
		if((num1 !=0) || (num2 !=0))
		{
			if(num1<num2)
			{
				
				for(;num1<=num2;num1++)
				{
					//check whether the number is divisible by both 3 & 5
					
					if((num1%3 == 0) && (num1%5 == 0))
					{
						System.out.print("FIZZBUZZ\t");
					}
					else if(num1%3 == 0) 
					{
						System.out.print("FUZZ\t");
					}
					else if(num1%5 == 0) 
					{
						System.out.print("BUZZ\t");
					}
					else
					{
						System.out.print(num1 +"\t");
					}
				}
				
			}
			else
			{
				for(;num2<=num1;num2++)
				{
					//check whether the number is divisible by both 3 & 5
					
					if((num2%3 == 0) && (num2%5 == 0))
					{
						System.out.print("FIZZBUZZ\t");
					}
					else if(num2%3 == 0) 
					{
						System.out.print("FUZZ\t");
					}
					else if(num2%5 == 0) 
					{
						System.out.print("BUZZ\t");
					}
					else
					{
						System.out.print(num2 +"\t");
					}
				}
			
			}
		}
		
		else
		{
			System.out.println("Both the given numbers are zeroes");
		}
		inputScan.close();
		

	}

}

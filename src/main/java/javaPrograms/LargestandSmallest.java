package javaPrograms;

import java.util.Scanner;

public class LargestandSmallest {

	public static void main(String[] args) {

		int ctr1,inputNum;
		String ConvNum;
		char largestNum, smallestNum;

		//Get the input from the user
		Scanner inputScan = new Scanner(System.in);

		System.out.println("Enter the number");

		inputNum = inputScan.nextInt();

		if(inputNum == 0)
		{
			System.out.println("The given number is 0");
		}
		else if(inputNum <0)
		{
			//Convert the integer to string for manipulation
			inputNum = inputNum * (-1);
			ConvNum = Integer.toString(inputNum);

			//Get the first char as the largest & smallest number
			largestNum = ConvNum.charAt(0);
			smallestNum = largestNum;
			for(ctr1=1;ctr1<ConvNum.length();ctr1++)
			{
				if(largestNum > ConvNum.charAt(ctr1))
				{
					largestNum = ConvNum.charAt(ctr1);
				}

				if(smallestNum < ConvNum.charAt(ctr1))
				{
					smallestNum = ConvNum.charAt(ctr1);
				}
			}

			System.out.println("The Largest Digit in the given number is "+"-"+largestNum);
			System.out.println("The Smallest Digit in the given number is "+"-"+smallestNum);

		}
		else
		{
			//Convert the integer to string for manipulation
			ConvNum = Integer.toString(inputNum);

			//Get the first char as the largest & smallest number
			largestNum = ConvNum.charAt(0);
			smallestNum = largestNum;
			for(ctr1=1;ctr1<ConvNum.length();ctr1++)
			{
				if(largestNum < ConvNum.charAt(ctr1))
				{
					largestNum = ConvNum.charAt(ctr1);
				}

				if(smallestNum > ConvNum.charAt(ctr1))
				{
					smallestNum = ConvNum.charAt(ctr1);
				}
			}

			System.out.println("The Largest Digit in the given number is "+largestNum);
			System.out.println("The Smallest Digit in the given number is "+smallestNum);
		}

		inputScan.close();
	}

}

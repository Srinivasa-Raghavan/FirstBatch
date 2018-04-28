package week1.hw;

import java.util.Scanner;

public class Week1ArmStrongNumPattern {

	public static void main(String[] args) {

		// Get the two numbers from the user

		int num1, num2, tempNum, resultNum;
		int reminder;
		Scanner inputScan = new Scanner(System.in);

		System.out.println("Enter the two 3-digit numbers");
		num1 = inputScan.nextInt();
		num2 = inputScan.nextInt();

		//Check whether to print the logic from Num1 to num2 or vice versa
		if((num1 !=0) || (num2 !=0))
		{
			if(num1<num2)
			{

				for(;num1<=num2;num1++)
				{
					//Check whether the given number is armstrong
					resultNum = 0;
					tempNum = num1;
					while(num1 >0)
					{
						reminder = num1%10;
						resultNum = (int) (resultNum + Math.pow(reminder,3));
						num1=num1/10;
					}

					num1=tempNum;

					if(num1 == resultNum)
					{
						System.out.print(num1 +"\t");
					}

				}

			}
			else
			{
				for(;num2<=num1;num2++)
				{
					//Check whether the given number is armstrong
					resultNum = 0;
					tempNum = num2;
					while(num2 >0)
					{
						reminder = num2%10;
						resultNum = (int) (resultNum + Math.pow(reminder,3));
						num2=num2/10;
					}

					num2=tempNum;

					if(num2 == resultNum)
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

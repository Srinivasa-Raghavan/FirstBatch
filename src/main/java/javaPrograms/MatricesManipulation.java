package javaPrograms;

import java.util.Scanner;

public class MatricesManipulation
{
	public static void main(String[] args)
	{
		int xArrRowSize, xArrColSize;
		int yArrRowSize, yArrColSize;
		int[][] xArr, yArr;
		int[][] resultArr;
		int ctr1, ctr2;
		char userChoice;
		int subChoice;

		Scanner inputScan = new Scanner(System.in);
		System.out.println("This Program is to add two matrices");		
		System.out.println("***********************************");		

		System.out.println("Enter the Row size of 1st Array");		
		xArrRowSize = inputScan.nextInt();
	
		System.out.println("Enter the Column size of 1st Array");		
		xArrColSize = inputScan.nextInt();

		System.out.println("Enter the Row size of 2nd Array");		
		yArrRowSize = inputScan.nextInt();
	
		System.out.println("Enter the Column size of 2nd Array");		
		yArrColSize = inputScan.nextInt();
		
		
		if ((xArrRowSize == yArrRowSize) && (xArrColSize == yArrColSize))
		{
			
			//Getting the array stored in the respective array variable
			xArr = new int[xArrRowSize][xArrColSize];		
			yArr = new int[yArrRowSize][yArrColSize];
			resultArr = new int[yArrRowSize][yArrColSize];

			System.out.println("Enter the Row-wise elements of 1st Array");
			System.out.println("****************************************");				
			for(ctr1=0;ctr1<xArrRowSize;ctr1++)
			{
				System.out.println("Enter " +(ctr1+1) + "Row");
				for(ctr2=0;ctr2<xArrColSize;ctr2++)
				{
					xArr[ctr1][ctr2] = inputScan.nextInt();	
				}
			}		

			System.out.println("Enter the Row-wise elements of 2nd Array");
			System.out.println("****************************************");				
			for(ctr1=0;ctr1<yArrRowSize;ctr1++)
			{
				System.out.println("Enter " +(ctr1+1) + "Row");
				for(ctr2=0;ctr2<yArrColSize;ctr2++)
				{
					yArr[ctr1][ctr2] = inputScan.nextInt();	
				}
			}		


			System.out.println("Enter the choice: (+/-) :");
			userChoice = inputScan.next().charAt(0);	
		
			if(userChoice == '+')
			{
				System.out.println("You are into the program of addition of two matrices");
				System.out.println("****************************************************");
				
				for(ctr1=0;ctr1<yArrRowSize;ctr1++)
				{
					for(ctr2=0;ctr2<yArrColSize;ctr2++)
					{
						resultArr[ctr1][ctr2] = xArr[ctr1][ctr2] + yArr[ctr1][ctr2];	
					}
				}		
			}
			else if(userChoice == '-')
			{

				System.out.println("You are into the program of subtraction of two matrices");
				System.out.println("****************************************************");
				
				subChoice = 0;
				while(subChoice == 0)
				{
					System.out.println("Enter the choice for Subtraction");
					System.out.println("For X-Y -> 1, For Y-X -> 2");
					subChoice = inputScan.nextInt();
					if(subChoice == 1 || subChoice == 2)
					{
						break;
					}
					else
					{
						subChoice = 0;
					}
				}

				

				for(ctr1=0;ctr1<yArrRowSize;ctr1++)
				{
					for(ctr2=0;ctr2<yArrColSize;ctr2++)
					{
						if (subChoice == 1)
						{
							resultArr[ctr1][ctr2] = xArr[ctr1][ctr2] - yArr[ctr1][ctr2];	
						}
						else
						{
							resultArr[ctr1][ctr2] = yArr[ctr1][ctr2] - xArr[ctr1][ctr2];	
						}
					}
				}	
			}

			else
			{
				System.out.println("Enter a valid user choice & try again");
			}
		

		//Printing the result

		System.out.println("The resultant of the Addition/Subtraction of two matrices is displayed below");
		for(ctr1=0;ctr1<yArrRowSize;ctr1++)
		{
			for(ctr2=0;ctr2<yArrColSize;ctr2++)
			{
				System.out.print(resultArr[ctr1][ctr2]);	
				System.out.print(" ,");
			}	
			System.out.println(" ");
		}	
		}	
		else
		{					
			System.out.println("The size of the two matrices are not identical. Hence Matrix addition/Subtraction cannot be performed");
		}
	inputScan.close();
	}
}
package javaPrograms;

import java.util.Scanner;

public class StarTriangle {

	public static void main(String[] args) {
		
		int ctr1, ctr2, sizeOfTriangle;

		Scanner inputScan = new Scanner(System.in);

		//Get the number of rows for the triangle from the user
		System.out.println("Enter the size of the triangle:");
		sizeOfTriangle = inputScan.nextInt();

		//Printing the triangle

		for(ctr1=1;ctr1<=sizeOfTriangle;ctr1++)
		{
			for(ctr2=1; ctr2<=((sizeOfTriangle-ctr1)/2); ctr2++)
					{
					 	System.out.print("\t");
					}
			for(ctr2=1;ctr2<=ctr1;ctr2++)
			{
				System.out.print("*"+"\t");
			}
			System.out.println("");
		}
		
		
		inputScan.close();
	}

}

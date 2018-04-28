package javaPrograms;

import java.util.Scanner;

public class SecLargestNumber{

	public static void main(String args[]){


	int totalSize, ctr1,ctr2,temp;
	int inputArr[];

	//Get the total number of inputs from the user
	Scanner inputScan = new Scanner(System.in);

	System.out.println("Enter the total number to be compared");
	totalSize = inputScan.nextInt();

	inputArr = new int[totalSize];

	
	//Get the number array from the user
	System.out.println("Start entering the numbers");

	for(ctr1=0; ctr1<totalSize; ctr1++)
	{
		System.out.println("Enter the " +(ctr1+1) +" number: ");
		inputArr[ctr1] = inputScan.nextInt();
	}


	//Comparing the numbers & sorting the same in the array

	for(ctr1=0;ctr1<totalSize-1;ctr1++)
	{
		
		for(ctr2=ctr1+1;ctr2<totalSize;ctr2++)
		{
			if(inputArr[ctr1]<inputArr[ctr2]){
				temp = inputArr[ctr2];
				inputArr[ctr2] = inputArr[ctr1];
				inputArr[ctr1] = temp;
	
			}
			
		}

	}
	
	//Printing the given numbers

	System.out.println("Printing the numbers in Descending Order");
	
	for(ctr1=0; ctr1<totalSize; ctr1++)
	{
		System.out.println(inputArr[ctr1]);
	}


	//Printing the second largest number
	System.out.println("The Second largest number in the given array is : " +inputArr[1]);
	inputScan.close();
	}



}
package javaPrograms;

import java.util.Scanner;

public class FibonacciSeries {

	public static void main(String[] args) {
		int ctr1,resultNum;
		int userInput;
		int temp;
		
		Scanner inputScan = new Scanner(System.in);
		
		System.out.println("Enter the number until which you would like to print the fibonacci series");
		userInput = inputScan.nextInt();
		
		System.out.println("Printing the Fibonacci Series till the given number");
		System.out.println("**************************************************");
		System.out.println("");
		
		resultNum=1;
		ctr1=0;
		
		System.out.print(ctr1+"\t");
		System.out.print(resultNum+"\t");
		while(resultNum < userInput)
		{
			temp = resultNum;
			resultNum = resultNum+ ctr1;
			ctr1 = temp;
			System.out.print(resultNum+"\t");
		}
		
		inputScan.close();
	}

}

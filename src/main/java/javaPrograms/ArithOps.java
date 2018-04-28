package javaPrograms;

import java.util.Scanner;

public class ArithOps{

	public static void main(String args[]){


	int number1, number2;
	String arithOps;
	int userChoice;

	//Getting the two numbers & Operation from the user

	System.out.println("Enter the two number on which you would like to do arithmetic operation (Integers)");
	System.out.println("**********************************************************************************");
	
	//Creating Scanner obj to get the user input
	Scanner	inputScan = new Scanner(System.in);
	System.out.println("Enter the first number");
	number1=inputScan.nextInt();

	System.out.println("Enter the second number");
	number2=inputScan.nextInt();

	//Get the Arithmetic Operation from the user
	System.out.println("Enter the Arithmetic Operation would like to perform");
	System.out.println("1. Add");
	System.out.println("2. Subtract");
	System.out.println("3. Multiply");
	System.out.println("4. Divide");

	arithOps = inputScan.next();

	//Based on the user input, performing the Arthimetic operation
	switch (arithOps.toLowerCase())
	{
	case "add":
		//Case to perform addition of the numbers
		System.out.println("You have chosen Add Operator");
		System.out.println("****************************");
		System.out.println(number1 + " + " +number2 + " = " +(number1+number2));
		break;
	case "subtract":
		//Case to perform Subtraction of the numbers. Get the user choice to perform either X-Y or Y-X
		userChoice = 0;
		System.out.println("You have chosen Subtract Operator");
		System.out.println("****************************");
		System.out.println("Enter the choice, Number1 - Number2 -> 1, Number2 - Number1 -> 2: ");
		userChoice = inputScan.nextInt();

		if(userChoice == 1)
			System.out.println(number1 + " - " +number2 + " = " +(number1-number2));
		else if(userChoice == 2)
			System.out.println(number2 + " - " +number1 + " = " +(number2-number1));
		else
			System.out.println("The Choice for Subtract is NOT valid");
		break;
	case "multiply":
		//Case to perform Multiplication of the numbers
		System.out.println("You have chosen Multiply Operator");
		System.out.println("****************************");
		System.out.println(number1 + " * " +number2 + " = " +(number1*number2));
		break;
	case "divide":
		//Case to perform Division of the numbers. Get the user choice to perform either X/Y or Y/X and also check for Divide by Zero error appropriately.
		userChoice = 0;
		System.out.println("You have chosen Divide Operator");
		System.out.println("****************************");
		System.out.println("Enter the choice, Number1 / Number2 -> 1, Number2 / Number1 -> 2: ");
		userChoice = inputScan.nextInt();

		if(userChoice == 1 && number2 != 0)
			System.out.println(number1 + " / " +number2 + " = " +number1/number2);
		else if(userChoice == 2 && number1 != 0)
			System.out.println(number2 + " / " +number1 + " = " +number2/number1);
		else
			System.out.println("The Choice for Divide is NOT valid or Divide by Zero error");
		break;
	default:
		System.out.println("Enter a valid choice");
		break;
	}
	
	inputScan.close();
	}

}
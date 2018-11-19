/*
Author: David Cosby
Date: 11.19.18
Description:
	Reads an unspecified number of integers, determines how many positve and negative values have been read, and computes the total.
*/

import java.util.Scanner;

class Ex_5_1 {
	public static void main(String[] args) {
		int positiveNumbers = 0;
		int negativeNumbers = 0;
		int numberSum = 0;
		boolean complete = false;
		
		Scanner input = new Scanner(System.in);
		while (!complete) {
			
			String additionalText = ": ";
			if (numberSum != 0) {
				additionalText = " (0 to quit): ";
			}
			
			System.out.print("Enter a positive or negative number" + additionalText);
			int number = input.nextInt();
			
			if (number == 0){
				complete = true;
				break;
			}
			
			numberSum += number;
			if (number > 0) {
				positiveNumbers++;
			}
			else { // assume negative
				negativeNumbers++;
			}
			
		}
		System.out.println("Positive numbers: " + positiveNumbers);
		System.out.println("Negative numbers: " + negativeNumbers);
		System.out.println("The total is " + numberSum);
	}
}
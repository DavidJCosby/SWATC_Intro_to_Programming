/*
Author: David Cosby
Date: 10.24.18
Description:
	Determines whether a given year is a leap year and how many days are in a specified month.
*/

import java.util.Scanner;

class Ex_4_17 {
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter a year: ");		
		 int year = input.nextInt();
		System.out.print("Enter a month: ");	
		 String month = input.next();
		 month = month.substring(0, 3).toLowerCase();
				
		int days = 30; // default assumption
		
		if (month.equals("jan") || month.equals("mar") || month.equals("may") || month.equals("jul") || month.equals("aug") || month.equals("oct") || month.equals("dec")) {
			days = 31;
		}
		else if (month.equals("feb")) {
			boolean isLeapYear = (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
			if (isLeapYear == true) {
				days = 29;
			}
			else {
				days = 28;
			}
		}
		
		System.out.println(month + " " + year + " has " + days + " days.");
	}
}

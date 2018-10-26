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
				
		int days = daysInMonth(month, year);
		
		System.out.println(month + " " + year + " has " + days + " days.");
		
	}
	
	public static int daysInMonth(String month, int year) {
		if (month == "jan" || month == "mar" || month == "may" || month == "jul" || month == "aug" || month == "oct"|| month == "dec") {
			return 31;
		}
		else if (month == "feb") {
			boolean isLeapYear = (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
			if (isLeapYear == true) {
				return 29;
			}
			else {
				return 28;
			}
		}
		else {
			return 30;
		}
	}
}

/* 
Author: David Cosby
Date: 12.12.18

Adds prefix zeros to an integer to make its length equal to a given number.
*/

import java.util.Scanner;

class Ex_6_17 {	

	public static String format(int num, int width) {
		String strungNumber = "" + num;
		int numLength = strungNumber.length();
		
		if (numLength >= width) {
			return strungNumber;
		}
		else {
			int additionalZeros = width - numLength;
			return addPrefixZerosToString(strungNumber, additionalZeros);
		}
	}
	
	public static String addPrefixZerosToString(String str, int zeros) {
		for (int i = 0; i < zeros; i++) {
			str = "0" + str;
		}
		return str;
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter a number: ");
		int number = input.nextInt();
		
		System.out.print("Assign a new width for that number: ");
		int width = input.nextInt();
		
		System.out.println(format(number, width));
	}
}
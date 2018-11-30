/* 
Author: David Cosby
Date: 11.30.18

Prompt user for number and check whether number is a palindrome.
*/

import java.util.Scanner;

class Ex_6_3 {
	
	public static int promptUserForInput() {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a number: ");
		return input.nextInt();
	}
	
	public static boolean isPalindrome(int number) {
		int reverse = reverse(number);
		return number == reverse;
	}
	
	public static int reverse(int number) {
		int reverse = 0;
		while (number != 0) {
			int remainder = number % 10;
			reverse = reverse * 10 + remainder;
			number /= 10;
		}
		return reverse;
	}
	
	
	public static void main(String[] args) {
		int userInput = promptUserForInput();	
		System.out.println("Is " + userInput + " a palindrome? " + isPalindrome(userInput));
	}
}
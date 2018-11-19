/*
Author: David Cosby
Date: 11.19.18
Description:
	prompts the user to enter an integer from 1 to 15 and displays a pyramid in the output. 
*/

import java.util.Scanner;

class Ex_5_17 {
	public static void main(String[] args) {
	Scanner input = new Scanner(System.in);

	System.out.print("Enter the number of lines: ");
	int rows = input.nextInt();
		
	for (int row = 1; row <= rows; row++) {
	
		String spacing = "  ";
		String margin = new String(new char[rows-row]).replace("\0", spacing);
		System.out.print(margin);
		
		for (int i = 0; i < row; i++) {
			System.out.print((row - i) + " ");
		}
		for (int i = 2; i <= row; i++) {
			System.out.print(i + " ");
		}
		
		
		System.out.print("\n");

		
	// loop structure
	}
	
	}
}
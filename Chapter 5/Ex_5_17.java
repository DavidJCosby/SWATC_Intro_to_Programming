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

		int rows = 0;
		while (rows < 1 || rows > 15) {
			System.out.print("Enter the number of rows (1-15): ");
			rows = input.nextInt();
		}
		
		for (int row = 1; row <= rows; row++) {
			
			String tab = "   ";
			int tabsInMargin = rows - row;
				
			for (int i = 0; i < tabsInMargin; i++) { // margins
				System.out.print(tab);
			}
			
			for (int col = row; col >= 1; col--) { // left side
				System.out.printf("%3d", col);
			}
			
			for (int col = 2; col <= row; col++) { // right side
				System.out.printf("%3d", col);
			}
			System.out.print("\n");
		}
	}
}
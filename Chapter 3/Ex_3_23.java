/*
	Author: David Cosby
	Date: 10.17.18

	Description: Determines whether a point is within the bounds of a rectangle 10 units wide and 5 units high, centered on 0,0.
*/

import java.util.Scanner;

class Ex_3_23 {
	public static void main(String[] args) {
		final double WIDTH = 10.0;
		final double HEIGHT = 5.0;
		
		Scanner input = new Scanner(System.in);
		double x, y = 0;			
		
		System.out.print("Enter the x value: ");
		x = input.nextDouble();
		System.out.print("Enter the y value: ");
		y = input.nextDouble();
		
		final boolean PASSES_HORIZONTAL_CHECK = Math.abs(x) <= (WIDTH / 2.0);
		final boolean PASSES_VERTICAL_CHECK = Math.abs(y) <= (HEIGHT / 2.0);
		
		if (PASSES_HORIZONTAL_CHECK && PASSES_VERTICAL_CHECK) {
			System.out.print("Point ("+x+", "+y+") is in the rectangle.");
		}
		else {
			System.out.print("Point ("+x+", "+y+") is not in the rectangle.");
		}
	}
}
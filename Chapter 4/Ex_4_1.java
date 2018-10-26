/*
Author: David Cosby
Date: 10.24.18
Description:
	Calculates the area of a pentagon, given r.
*/

import java.util.Scanner;

class Ex_4_1 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter the length from the center to a vertex: ");
		double radius = input.nextDouble();
		
		final double SIDE_LENGTH = (2.0 * radius) * Math.sin(Math.PI/5.0);
		final double AREA =	
			(5.0 * Math.pow(SIDE_LENGTH, 2.0)) /
			(4.0 * Math.tan(Math.PI/5.0));
		
		System.out.println("The area of the pentagon is " + AREA);
	}
}
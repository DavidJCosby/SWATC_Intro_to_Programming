/*
	Author: David Cosby
	Date: 10.17.18

	Description: Computes the perimeter of a triange after determining if the side measurements are capable of forming a valid triangle.

*/

import java.util.Scanner;

class Ex_3_19 {
	public static void main(String[] args) {
		double sideA, sideB, sideC = 0;
		
		System.out.println("Enter three triangle side lengths.");
		
		Scanner input = new Scanner(System.in);
		
		System.out.print("Side A: ");
		sideA = input.nextDouble();
		System.out.print("Side B: ");
		sideB = input.nextDouble();
		System.out.print("Side C: ");
		sideC = input.nextDouble();
				
		final boolean PASSES_VALIDITY_CHECK =
			((sideA + sideB) > sideC) &&
			((sideB + sideC) > sideA) &&
			((sideA + sideC) > sideB);
		
		if (PASSES_VALIDITY_CHECK) {
			double perimeter = sideA + sideB + sideC;
			System.out.println("Perimeter is " + perimeter);
		}
		else {
			System.out.println("Triangle is invalid.");
		}
										
	}
}
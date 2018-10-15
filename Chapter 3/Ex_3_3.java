/*
	Author: David Cosby
	Date: 10.15.18

	Description: Uses Cramer's rule to solve a set of linear equations

*/

import java.util.Scanner;

class Ex_3_3 {
	public static void main(String[] args) {
		double a, b, c, d, e, f = 0.0;
		
		System.out.println("given that\n\n\tax+by=e\nand\n\tcx+dy=f\n\nenter values for each variable to solve for x and y.");
		
		Scanner input = new Scanner(System.in);
		
		System.out.print("a: ");
		a = input.nextDouble();
		System.out.print("b: ");
		b = input.nextDouble();
		System.out.print("c: ");
		c = input.nextDouble();
		System.out.print("d: ");
		d = input.nextDouble();
		System.out.print("e: ");
		e = input.nextDouble();
		System.out.print("f: ");
		f = input.nextDouble();
		
		if (a*d - b*c == 0) {
			System.out.println("Cannot divide by zero.");
		}
		else {
			double x = (e*d - b*f) / (a*d - b*c);
			double y = (a*f - e*c) / (a*d - b*c);
			System.out.println("x is "+ x);
			System.out.println("y is "+ y);
		}
	}
}
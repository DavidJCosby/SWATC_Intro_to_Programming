/* 
 Author: David Cosby
 Date: 2.7.19

Adds two matrices together.
*/

import java.util.Scanner;

class Ex_8_5 {
	
	public static String matrixToString(double[][] m) {
		String base = "";
		
		for (int row = 0; row < 3; row++) {
			base += "  ";
			for (int col = 0; col < 3; col++) {
				base += m[row][col] + "\t";
			}
			base += "\n";
		}
		
		return base;
	}
	
	public static double[][] promptMatrix(String matrixName) {
		Scanner input = new Scanner(System.in);
		double[][] m = new double[3][3];
		
		System.out.println("Enter values for Matrix " + matrixName);
		
		for (int row = 0; row < 3; row++) {
			for (int col = 0; col < 3; col++) {
				System.out.print(matrixName + "(" + (row + 1) + ", " + (col + 1) + ") = "); // arrays really should start at 1.
				m[row][col] = input.nextDouble();				
			}
		}
		
		System.out.print('\n');
		
		return m;
	}
	
	public static double[][] addMatrix(double[][] a, double[][] b) {
		
		double[][] c = new double[3][3];
		
		for (int row = 0; row < 3; row++) {
			for (int col = 0; col < 3; col++) {
				c[row][col] = (a[row][col] + b[row][col]);
			}
		}
		
		return c;
	}
	
	public static void main(String[] args) {
		double[][] a = promptMatrix("A"); 
		double[][] b = promptMatrix("B");
		double[][] c = addMatrix(a, b);
		
		System.out.println("\n\nMatrix A = ");
		System.out.println(matrixToString(a));
		
		System.out.println("Matrix B = ");
		System.out.println(matrixToString(b));
		
		System.out.println("A + B = ");
		System.out.print(matrixToString(c));

	}
}
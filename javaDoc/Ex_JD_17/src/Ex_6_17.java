/** 
 * <h1> Matrix Generator </h1> 
 * <p> Generates an n-n matrix with random values where 'n' is defined by the user. </p>
 * <p> Date: 12.6.18 </p>

 * @author David Cosby
*/

import java.util.Scanner;

public class Ex_6_17 {	

	/**
	 * Prompts user for an integer input.
	
	 * @return integer sent by user.
	*/
	
	public static int promptUserForInput() {
		Scanner input = new Scanner(System.in);
		System.out.print("To create a randomized n-by-n matrix, please define n: ");
		return input.nextInt();
	}
	
	/**
	 * outputs an <i> n </i> by <i> n </i> matrix of randomly generated zeros and ones.
	 
	 * @param n integer for matrix height and width.
	*/
	public static void printMatrix(int n) {
		for (int i = 0; i < n; i++) {
			printRow(n);
			System.out.print('\n');
		}
	}
	/**
	 * outputs a row of randomly generated zeros and ones of width <i> length. </i>
	 
	 * @param length number of items in row.
	*/
	public static void printRow(int length) {
		for (int i = 0; i < length; i++) {
			double num = Math.round(Math.random());
			System.out.print((int)num + " ");
		}
	}
	
	/**
	 * calls the promptUserForInput() method and generates a matrix with a height and width given by the user.
	 * @param args Argument from console input; Unused
	*/
	public static void main(String[] args) {
		int size = promptUserForInput();
		printMatrix(size);
	}
}
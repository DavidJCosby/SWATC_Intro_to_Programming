/* 
 Author: David Cosby
 Date: 2.1.19

 finds the minimum value given in a series of numbers
*/

import java.util.Scanner;

class Ex_7_9 {

	public static String promptUserForInput() {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter multiple numbers separated by spaces: ");
		return input.nextLine();
	}

	public static double[] convertStringToNumericArray(String str) {
		String[] stringArray = str.split(" ");
		double[] numericArray = new double[stringArray.length];
		
		for (int i = 0; i < stringArray.length; i++) {
			numericArray[i] = Double.parseDouble(stringArray[i]);
		}
		
		return numericArray;
	}

	public static double min(double[] array) {
		double min = array[0];
		
		for (int i = 1; i < array.length; i++) {
			if (array[i] < min) {
				min = array[i];
			}
		}
		
		return min;
	}

	public static void main(String[] args) {
		String input = promptUserForInput();
		double[] array = convertStringToNumericArray(input);
		double minimumValue = min(array);
		
		System.out.print("The minimum value is: " + minimumValue);
	}
}
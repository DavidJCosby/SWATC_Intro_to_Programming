import java.util.Scanner;

/** 
 * <h1> Number Length Formatter </h1> 
 * <p> Adds a certain amount of zeros to the beginning of an integer to give it a requested length. </p>
 * <p> Date: 12.12.18 </p>
 *  
 * @author David Cosby
*/

public class Ex_6_37 {	

	/**
	 * Adds a certain number of zeros to the beginning of a string cast from an integer, giving it a length requested by the user, and returns it. If the number's initial length exceeds or matches the requested one, the function will return the initial number cast to a string.
	
	 *<p> Examples: </p>
	 	* <pre> {@code
	 		* format(5550142, 9)		returns "005550142"
	 		* format(510, 1)			returns "510"
	 		* format(1776, 10)		returns "0000001776"
	 	* }
	 * </pre>

	
	 * @param num number to expand in length.
	 * @param width length of the new number.
	 * @return String with requested width.
	*/
	
	public static String format(int num, int width) {
		String strungNumber = "" + num;
		int numLength = strungNumber.length();
		
		if (numLength >= width) {
			return strungNumber;
		}
		else {
			int additionalZeros = width - numLength;
			return addPrefixZerosToString(strungNumber, additionalZeros);
		}
	}
	
	/**
	 * Adds a requested number of zeros to the beginning of a string.* 
	 *<p> Examples: </p>
	 	* <pre> {@code
	 		* addPrefixZerosToString("5550142", 9)		returns "0000000005550142"
	 		* addPrefixZerosToString("510", 1)		returns "0510"
	 		* addPrefixZerosToString("1776", 10)		returns "00000000001776"
	 	* }
	 * </pre> 
	 * @param str string to modify.
	 * @param zeros number of zeros to add.
	 * @return String expanded by prefix zeros.
	*/
	
	public static String addPrefixZerosToString(String str, int zeros) {
		for (int i = 0; i < zeros; i++) {
			str = "0" + str;
		}
		return str;
	}

	/**
	 * Prompts user for inputs regarding an integer and the width that it should be assigned.
	 * Print a newly formatted integer with that width.
	 * 
	 * @param args Argument from console input; Unused
	*/
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter a number: ");
		int number = input.nextInt();
		
		System.out.print("Assign a new width for that number: ");
		int width = input.nextInt();
		
		System.out.println(format(number, width));
	}
}
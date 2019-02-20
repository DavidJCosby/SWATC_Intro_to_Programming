/* 
 Author: David Cosby
 Date: 2.20.19

Generates a binary matrix, where 0's and 1's are replaced with H's and T's from an integer input.
*/

import java.util.Scanner;

class Ex_8_11 {
	
	public static int promptUserForInput() {
		Scanner input = new Scanner(System.in);
		System.out.print("Please enter a number between 0 and 511: ");
		
		int response = input.nextInt();
		
		if ((response < 512) && (response > -1)) {
			return response;
		}
		else {
			return promptUserForInput();
		}
	}
	
	public static String repeat(String str, int times) {  // borrowed from stackoverflow.com/questions/1235179/
		return new String(new char[times]).replace("\0", str);
	}
	
	public static String numberToBinary(int num) {
		String binary = Integer.toBinaryString(num);
		
		if (binary.length() < 9) {
			int zerosNeeded = 9 - binary.length();
			String zeros = repeat("0", zerosNeeded);
			binary = zeros + binary;
		}
		
		return binary;
	}
	
	public static String binaryToCoinArray(String binary) {
		String array = "";
		char[] bits = binary.toCharArray();
		
		int x = 0;
		for (char bit : bits) {
			if (bit == '0') {
				array += "H ";
			}
			else {
				array += "T ";
			}
	
			x++;
			if (x % 3 == 0) {
				array += "\n";
			}
		}
		
		return array;
	}
	
	
	public static void main(String[] args) {
		int num = promptUserForInput();
		String binary = numberToBinary(num);
		String array = binaryToCoinArray(binary);
		System.out.println(array);
	}
}
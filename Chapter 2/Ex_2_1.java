/*
Author: David Cosby
Date: 9.21.18

Takes a celsius measurement from the user and converts it into fahrenheit

*/
import java.util.Scanner;

public class Ex_2_1 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a degree in Celsius: ");
		double celsius = input.nextDouble();
		double fahrenheit = (9.0/5.0) * celsius + 32.0;
		System.out.println(celsius + " degrees celsius is equal to " + fahrenheit + " degrees fahrenheit.");
	}
}

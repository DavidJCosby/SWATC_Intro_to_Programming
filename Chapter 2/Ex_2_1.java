/*
Author: David Cosby
Date: 9.21.18

Takes a celsius measurement from the user and converts it into fahrenheit

*/


class Ex_2_1 {
	public static void main(String[] args) {
		System.out.println("Enter a degree in Celsius: ");
		double celsius = 29.5; // placeholder until I figure out user input
		double fahrenheit = (9.0/5.0) * celsius + 32.0;
		System.out.println(fahrenheit);
	}
}
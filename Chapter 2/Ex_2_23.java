/*
Author: David Cosby
Date: 10.1.18

Calculates the cost of a trip given driving distance, car milage and gas prices.
*/

import java.util.Scanner;


class Ex_2_23 {
	public static void main(String[] args) {
		double drivingDistance, milesPerGallon, pricePerGallon;
		
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter the driving distance: ");
		drivingDistance = input.nextDouble();
		System.out.print("Enter miles per gallon: ");
		milesPerGallon = input.nextDouble();
		System.out.print("Enter price per gallon: $");
		pricePerGallon = input.nextDouble();
		
		final double GALLONS = drivingDistance / milesPerGallon;
		final double TRIP_PRICE = GALLONS * pricePerGallon;
		
		System.out.println("The cost of driving is $" + TRIP_PRICE);
	}
}
/*
Author: David Cosby
Date: 9.27.18

Calculates account balance over a period of six months, given monthly
deposits and annual interest rates.

*/

import java.util.Scanner;


class Ex_2_13 {
	public static void main(String[] args) {
		final double ANNUAL_INTEREST_RATE = 0.05;
		final double MONTHLY_INTEREST_RATE = ANNUAL_INTEREST_RATE / 12;
		double accountBalance = 0;
		
		Scanner input = new Scanner(System.in);
		System.out.print("How much do you deposit each month? $");
		final double MONTHLY_DEPOSIT = input.nextDouble();

		accountBalance = (accountBalance + MONTHLY_DEPOSIT) * (1 + MONTHLY_INTEREST_RATE); // step
		accountBalance = (accountBalance + MONTHLY_DEPOSIT) * (1 + MONTHLY_INTEREST_RATE);
		accountBalance = (accountBalance + MONTHLY_DEPOSIT) * (1 + MONTHLY_INTEREST_RATE);
		accountBalance = (accountBalance + MONTHLY_DEPOSIT) * (1 + MONTHLY_INTEREST_RATE);
		accountBalance = (accountBalance + MONTHLY_DEPOSIT) * (1 + MONTHLY_INTEREST_RATE);
		accountBalance = (accountBalance + MONTHLY_DEPOSIT) * (1 + MONTHLY_INTEREST_RATE);
		
		System.out.println("final balance after 6 months: $" + accountBalance);
	}
}
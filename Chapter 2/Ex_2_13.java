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
		double monthlyInterestRate = ANNUAL_INTEREST_RATE / 12;
		double accountBalance = 0;

		Scanner input = new Scanner(System.in);
		System.out.print("How much do you deposit each month? $");
		double monthlyDeposit = input.nextDouble();

		accountBalance = (accountBalance + monthlyDeposit) * (1 + monthlyInterestRate); // step
		accountBalance = (accountBalance + monthlyDeposit) * (1 + monthlyInterestRate);
		accountBalance = (accountBalance + monthlyDeposit) * (1 + monthlyInterestRate);
		accountBalance = (accountBalance + monthlyDeposit) * (1 + monthlyInterestRate);
		accountBalance = (accountBalance + monthlyDeposit) * (1 + monthlyInterestRate);
		accountBalance = (accountBalance + monthlyDeposit) * (1 + monthlyInterestRate);
		
		System.out.println("final balance after 6 months: $" + accountBalance);
	}
}
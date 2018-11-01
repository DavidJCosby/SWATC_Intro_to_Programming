/*
Author: David Cosby
Date: 10.30.18
Description:
	Print's a payroll statement given various parameters.
*/

import java.util.Scanner;
import java.text.*;

class Ex_4_23 {
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter employee's name: ");	
		 String name = input.nextLine();
		System.out.print("Enter number of hours worked: ");
		 double hoursWorked = input.nextDouble();
		System.out.print("Enter hourly pay rate: $");
		 double hourlyPayRate = input.nextDouble();
		System.out.print("Enter federal tax withholding rate: ");
		 double federalTaxRate = input.nextDouble();
		System.out.print("Enter state tax withholding rate: ");
		 double stateTaxRate = input.nextDouble();
		
		double grossPay = round(hoursWorked * hourlyPayRate, 2);
		double federalWithholding = round(grossPay * federalTaxRate, 2);
		double stateWithholding = round(grossPay * stateTaxRate, 2);
		double totalDeduction = round(federalWithholding + stateWithholding, 2);
		double netPay = round(grossPay - totalDeduction, 2);
				
		DecimalFormat money = new DecimalFormat("$####0.00");
		
		System.out.println("\nEmployee Name: " + name);
		System.out.println("Hours worked: " + hoursWorked);
		System.out.println("Pay Rate: " + money.format(hourlyPayRate));
		System.out.println("Gross Pay: " + money.format(grossPay));
		System.out.println("Deductions:");
		System.out.println("\tFederal Withholding (" + (federalTaxRate * 100.0) + "%): " + money.format(federalWithholding));
		System.out.println("\tState Withholding (" + (stateTaxRate * 100.0) + "%): " + money.format(stateWithholding));
		System.out.println("\tTotal Deduction: " + money.format(totalDeduction));
		System.out.println("Net Pay: " + money.format(netPay));
	}
		
	public static double round(double number, int places) {
		return Math.floor(number * Math.pow(10, places) + 0.5) / Math.pow(10, places);
	}
}

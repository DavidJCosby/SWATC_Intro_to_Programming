/*
Author: David Cosby
Date: 11.13.18
Description:
	Displays all the numbers from 100 to 200 in rows of ten that are divisble by either five or six.
*/


class Ex_5_11 {
	public static void main(String[] args) {
		int num = 100;
		int lineCounter = 0;
		while (num <= 200) {
			boolean isDivisibleByFive = (num % 5 == 0);
			boolean isDivisibleBySix = (num % 6 == 0);
			if (isDivisibleByFive ^ isDivisibleBySix) {
				System.out.print(num + " ");
				
				lineCounter++;
				if (lineCounter == 10) {
					lineCounter = 0;
					System.out.print("\n");
				}
			}
			num++;
		}
	}
}
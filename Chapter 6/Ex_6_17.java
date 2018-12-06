import java.util.Scanner;

class Ex_6_17 {	

	public static int promptUserForInput() {
		Scanner input = new Scanner(System.in);
		System.out.print("To create a randomized n-by-n matrix, please define n: ");
		return input.nextInt();
	}
	
	public static void printMatrix(int n) {
		for (int i = 0; i < n; i++) {
			printRow(n);
			System.out.print('\n');
		}
	}
	
	public static void printRow(int length) {
		for (int i = 0; i < length; i++) {
			double num = Math.round(Math.random());
			System.out.print((int)num + " ");
		}
	}
	
	
	public static void main(String[] args) {
		int size = promptUserForInput();
		printMatrix(size);
	}
}
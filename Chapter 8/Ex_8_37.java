/* 
 Author: David Cosby
 Date: 3.4.19

Quizzes the user on various state capitals.
*/

import java.util.Scanner;

class Ex_8_37 {
	
	public static String[][] stateCapitalPairs = new String[][] {
		{"Alabama", "Montgomery"},
		{"California", "Sacramento"},
		{"Georgia", "Atlanta"},
		{"New Jersey", "Trenton"},
		{"Massachusetts", "Boston"},
		{"New York", "Albany"},
		{"Montana", "Helena"},
		{"Nebraska", "Lincoln"},
		{"Texas", "Austin"},
		{"South Dakota", "Pierre"},
	};
	
	public static int randomNumber(int max) {
		int num = (int) Math.floor((Math.random() * max) + 0.5);
		return num;
	}
	
	public static String[] grabRandomPair() {
		int index = randomNumber(9);
		return stateCapitalPairs[index];
	}
	
	public static boolean checkEquivalent(String answer, String capital) {
		capital = capital.toLowerCase();
		answer = answer.toLowerCase();
		
		return(answer.equals(capital));
	}
	
	public static String promptUserForAnswer(String[] stateCapitalPair) {
		Scanner input = new Scanner(System.in);
		System.out.println("What is the capital of " + stateCapitalPair[0] + "?");
		System.out.print("\t");
		
		return input.next();
	}
	
	public static void QuizUser() {
		String[] stateCapitalPair = grabRandomPair();
		
		String response = promptUserForAnswer(stateCapitalPair);
		boolean correct = checkEquivalent(response, stateCapitalPair[1]);
		
		if (correct) {
			System.out.println("Correct!");
		}
		else {
			System.out.println("Incorrect.");
		}
	}
	
	public static boolean checkIfBored() {
		Scanner input = new Scanner(System.in);
	
		System.out.print("\n Another? (Y/N) ");
		String response = input.next();
		
		return !(response.toLowerCase().equals("y"));
	}
		
	public static void main(String[] args) {
		boolean bored = false;
		while (!bored) {
			QuizUser();
			bored = checkIfBored();
			
			if (!bored) {
				System.out.print("\n");
			}
		}
	}
}
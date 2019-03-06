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
	
	public static int randomInt(int min, int max) {
		int range = max - min;
		int num = min + (int) Math.round((Math.random() * range));
		return num;
	}
	
	public static String[] getRandomStateCapitalPair() {
		int index = randomInt(0, 9);
		return stateCapitalPairs[index];
	}
	
	public static boolean checkEquivalent(String answer, String capital) {
		capital = capital.toLowerCase();
		answer = answer.toLowerCase();
		
		return(answer.equals(capital));
	}
	
	public static String askUserForCapitalOf(String state) {
		Scanner input = new Scanner(System.in);
		System.out.println("What is the capital of " + state + "?");
		System.out.print("\t");
		
		return input.next();
	}
	
	public static void QuizUser() {
		String[] stateCapitalPair = getRandomStateCapitalPair();
		String state = stateCapitalPair[0];
		String capital = stateCapitalPair[1];
		
		String response = askUserForCapitalOf(state);
		boolean correct = checkEquivalent(response, capital);
		
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
		String response = input.next().toLowerCase();
		
		if (response.equals("y")) {
			return false;
		}
		else {
			return true;
		}
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
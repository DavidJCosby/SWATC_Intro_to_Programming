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
	
	public static boolean checkEquivalent(String answer, String capital) {
		capital = capital.toLowerCase();
		answer = answer.toLowerCase();
		
		return (answer.equals(capital));
	}
	
	public static String askUserForCapitalOf(String state) {
		Scanner input = new Scanner(System.in);
		System.out.println("What is the capital of " + state + "?");
		System.out.print("\t");
		
		return input.next();
	}
	
	public static void quizUserOnState(String[] stateCapitalPair) {
		String state = stateCapitalPair[0];
		String capital = stateCapitalPair[1];
		
		String response = askUserForCapitalOf(state);
		boolean correct = checkEquivalent(response, capital);
		
		if (correct) {
			score ++;
		}
	}
	
	public static void quizUserOnStates() {
		for (String[] stateCapitalPair : stateCapitalPairs) {
			quizUserOnState(stateCapitalPair);
		}
	}
	
	public static void showScore() {
		System.out.println("\nYou scored " + score + "/10.");
	}
	
	
	public static int score = 0;
		
	public static void main(String[] args) {
		quizUserOnStates();
		showScore();
	}
}
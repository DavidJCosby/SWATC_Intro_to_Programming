import java.util.Scanner;

/** 
 * <h1> Palindrome test </h1> 
 * <p> Prompt user for number and check whether number is a palindrome. </p>
 * <p> Date: 11.30.18 </p>
 *  
 * @author David Cosby
*/

public class Ex_6_3 {
	/**
	 * Prompts user for an integer input.
	
	 * @return integer inputted by user.
	*/
	public static int promptUserForInput() {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a number: ");
		int results = input.nextInt();
		input.close();
		return results;
	}
	
	/**
	 * Takes a given integer and determines if it is a palindrome by checking if it is the same as its reversed form.
	 *<p> Examples: </p>
	 * <pre> {@code
	 	* isPalindrome(554343455)	returns true
	 	* isPalindrome(8675309)		returns false
	 	* isPalindrome(012210)		returns false
	 * }
	 * </pre>
	 * @param number to check.
	 * @return bool indicating whether given integer is a palindrome.
	*/
	public static boolean isPalindrome(int number) {
		int reverse = reverse(number);
		return number == reverse;
	}

	/**
	 * Takes a given integer and reverses the order of its digits.
	 *<p> Examples: </p>
	 * <pre> {@code
	 	* reverse(5550142)	returns 2410555
	 	* reverse(29892)		returns 29892
	 	* reverse(6400)		returns 46
	 * }
	 * </pre>
	 * @param number integer to be reversed.
	 * @return reversed integer number.
	*/
	public static int reverse(int number) {
		int reverse = 0;
		while (number != 0) {
			int remainder = number % 10;
			reverse = reverse * 10 + remainder;
			number /= 10;
		}
		return reverse;
	}
	
	/**
	 * calls the promptUserForInput() method and informs user whether their given integer is a palindrome.
	 * @param args Argument from console input; Unused
	*/
	public static void main(String[] args) {
		int userInput = promptUserForInput();	
		System.out.println("Is " + userInput + " a palindrome? " + isPalindrome(userInput));
	}
}
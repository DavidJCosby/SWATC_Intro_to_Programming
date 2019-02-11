/* 
 Author: David Cosby
 Date: 2.11.19

 solves the locker puzzle explained in detail at the link below without the use of objects:
https://stech.instructure.com/courses/516740/assignments/5325572?module_item_id=7862349
*/



class Ex_7_23_lame_version {
	
	public static String lockerToString(int index, boolean open) {
		String base = " ";
		if ((index + 1) % 10 == 1) {
			base += "\n";
		}
		
		if (open == true)
			base += "o";
		else 
			base += "x";
		
		return base;
	}
	
	public static void listOpenLockers() {
		String base = "";
		int index = 0;
		for (boolean open : lockers) {
			if (open == true) {
				base += (" L" + (index + 1));
			}
			index++;
		}
		System.out.println("The following lockers are still open: ");
		System.out.print(base);
	}
	
	public static void displayLockers() {
		String base = "";
		int index = 0;
		for (boolean open : lockers) {
			base += lockerToString(index, open);
			index++;
		}
		System.out.print(base + "\n\n");
	}
	
	public static void runStudentIteration(int studentNum) {
		for (int i = 0; i <= 100; i++) {
			if (i >= studentNum) {
				if (i % (studentNum) == 0) {
					lockers[i-1] = !(lockers[i-1]); // I don't know why, but i-1 makes this work out.
				}
			}
		}
	}
	
	public static void runIterationsForEveryStudent() {
		for (int i = 1; i <= 100; i++) {
			runStudentIteration(i);
		}
	}
	
	
	static boolean[] lockers = new boolean[100];
	
	public static void main(String[] args) {
		runIterationsForEveryStudent();
		displayLockers();
		listOpenLockers();
	}
}
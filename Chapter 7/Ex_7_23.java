/* 
 Author: David Cosby
 Date: 2.7.19

 solves the locker puzzle explained in detail at the link below:
https://stech.instructure.com/courses/516740/assignments/5325572?module_item_id=7862349
*/

class Locker {
	int index = 0;
	boolean open = false;
	
	public Locker(int i) {
		index = i;
	}
	
	public void toggleOpen() {
		open = !open;
	}
	
	public String toString() {
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
}

class Ex_7_23 {
	
	public static void listOpenLockers() {
		String base = "";
		for (Locker locker : lockers) {
			if (locker.open == true) {
				base += (" L" + (locker.index + 1));
			}
		}
		System.out.println("The following lockers are still open: ");
		System.out.print(base);
	}
	
	public static void displayLockers() {
		String base = "";
		for (Locker locker : lockers) {
			base += locker;
		}
		System.out.print(base + "\n\n");
	}
	
	public static void runStudentIteration(int studentNum) {
		for (int i = 0; i <= 100; i++) {
			if (i >= studentNum) {
				if (i % (studentNum) == 0) {
					lockers[i-1].toggleOpen(); // I don't know why, but i-1 makes this work out.
				}
			}
		}
	}
	
	public static void runIterationsForEveryStudent() {
		for (int i = 1; i <= 100; i++) {
			runStudentIteration(i);
		}
	}
	
	public static void setUpLockers() {	
		for (int i = 0; i < 100; i++) {
			lockers[i] = new Locker(i);
		}
	}
	
	static Locker[] lockers = new Locker[100];
	
	public static void main(String[] args) {
		setUpLockers();
		runIterationsForEveryStudent();
		displayLockers();
		listOpenLockers();
	}
}
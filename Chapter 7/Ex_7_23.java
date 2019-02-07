/* 
 Author: David Cosby
 Date: 2.7.18

 solves the locker puzzle explained in detail at the link below:
https://stech.instructure.com/courses/516740/assignments/5325572?module_item_id=7862349
*/

class Locker {
	int index = 0;
	boolean locked = false;
	
	public void Locker(int i) {
		index = i;
	}
	
	public void toggleLock() {
		locked = !locked;
	}
}

class Ex_7_23 {
	
	
	public static void main(String[] args) {
		
	}
}
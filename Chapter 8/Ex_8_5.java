/* 
 Author: David Cosby
 Date: 2.7.19

Adds two matrices together.
*/

class Ex_8_5 {
	
	public static double[][] addMatrix(double[][] a, double[][] b) {
		
		double[][] c = new double[3][3];
		
		for (int row = 0; i < 3; row++) {
			for (int col = 0; i < 3; col++) {
				c[row][col] = (b[row][col] + b[row][col]);
			}
		}
		
		return c;
	}
	
	public static void main(String[] args) {
		
		
	}
}
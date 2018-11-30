public class Vector2 {
	double x;
	double y;
	
	public Vector2(double xCoordinate, double yCoordinate) {
		x = xCoordinate;
		y = yCoordinate;
	}
	
	public Vector2 plus(Vector2 translationVector) {
		return new Vector2(x + translationVector.x, y + translationVector.y);
	}
	
	public Vector2 minus(Vector2 translationVector) {
		return new Vector2(x - translationVector.x, y - translationVector.y);
	}
	
	public Vector2 times(Vector2 translationVector) {
		return new Vector2(x * translationVector.x, y * translationVector.y);
	}
	
	public Vector2 dividedBy(Vector2 translationVector) {
		if ((translationVector.x == 0) || (translationVector.y == 0)) {
			System.out.println("Divide by zero error.");
			return this;
		}
		return new Vector2(x / translationVector.x, y / translationVector.y);
	}
	
	public Vector2 negate() {
		return new Vector2(-x, -y);
	}
	
	public double magnitude() {
		return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
	}
	
	public Vector2 unit() {
		double magnitude = this.magnitude();

		return this.dividedBy(new Vector2(magnitude, magnitude));
	}
			
	public void read() {
		System.out.println(x + ", " + y);
	}
	
	public Vector2 rotate(double angle) {
		Vector2 normalizedSelf = this.unit();
		double mag = this.magnitude();
		double currentAngle = Math.atan2(normalizedSelf.y, normalizedSelf.x);
		double newAngle = currentAngle + angle;
		// convert back to unit
		// multiply by magnitude
	}


	public static void main(String []args) {
		
		Vector2 vector = new Vector2(10, 0);
		vector.read();
		
		vector.unit().read();
		double hypotenuseLength = vector.magnitude();
		
		System.out.print(hypotenuseLength);
	}
}
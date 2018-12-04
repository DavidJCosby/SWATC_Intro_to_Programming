class Symbol {
	String character;
	double value;
	String type;
		
	public void Variable(String s, double v) {
		character = s;
		value = v;
		type = "Variable";
	}
	
	public void Constant(double v) {
		value = v;
		type = "Constant";
	}
	
	public void Operator(String s) {
		character = s;
	}
}



class Equation {
	
	Symbol[] equation;

	
	public Equation(String formula) {
		String[] separatedFormula = formula.split("\\s+");
		
	}
	
	public static void main(String[] args) {
		
	}
}
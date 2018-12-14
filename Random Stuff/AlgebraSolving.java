class EquationSegment {
	String type = "Blank"; // Variable, Constant, Group, Operator, Blank
	EquationSegment[] contents;
	String symbol = "";
	EquationSegment coefficient;
	double value = 0;
	boolean hasValueAssigned = false;
	
	public EquationSegment(String s) {
		type = s;
	}
	
	public String toString() {
		if (type == "Variable" || type == "Constant" || type == "Operator") {
			return symbol;
		}
		else if (type == "Group") {
			String composite = "";
			for (EquationSegment eqSeg : contents) {
				composite += eqSeg;
			}
		}
		else if (type == "Blank") {
			return "";
		}
	}
	
	public void assignValue(double v) {
		if (type == "Group" || type == "Operator" || type == "Blank") {
			System.out.print("Values cannot be assigned to " + type + "s.");
			return null;
		}
		else {
			value = v;
			hasValueAssigned = true;
		}
	}
	
	public String getTrueCoefficientValue() {
		
		switch (coefficient.type) {
			case "Constant":
				return "" + coefficient.value;
				break;
			case "Variable":
				if (coefficient.hasValueAssigned) {
					return "" + (coefficient.value * Double.parseDouble(getTrueCoefficientValue()));
				}
				break;
			default:
				return "1";
				break;
		}
	}
	
	public void assignContents(EquationSegment[] newContents) {
		if (!type == "Group") {
			System.out.print("contents cannot be assigned to " + this + " because it isn't a group!");
		}
		else {
			contents = new EquationSegment[newContents.length];
			contents = newContents.clone();
		}
	}
	
	
	public EquationSegment substituteKnownVariablesWithTheirValues() {
	
		switch (type) {
			case "Variable":
				if (hasValueAssigned) {
					if (getTrueCoefficientValue() == "1") {
						EquationSegment convertedToConst = new EquationSegment("Constant");
						convertedToConst.assignValue(value);
						convertedToConst.symbol = "" + value;
						return convertedToConst;
					}
					else if (getTrueCoefficientValue() == "0") {
						EquationSegment convertedToBlank = new EquationSegment("Blank");
						return convertedToBlank;
					}
					else {
						
						// if, for example, x was known to have a value of 2, 6x would become 6(2);
						
						EquationSegment group = new EquationSegment("Group");
						EquationSegment[] container = new EquationSegment[1];
						
						EquationSegment convertedToConst = new EquationSegment("Constant");
						convertedToConst.assignValue(value);
						convertedToConst.symbol = "" + value;
						
						container[0] = convertedToConst.clone();
						
						group.assignContents(container);
						group.coefficient = coefficient.clone();
						
						return group;
					}
				}
				break;
			default:
				return this;
				break;
		}
	}
}

class Equation {
	
	public getTypeOfStringSegment(String seg) {
		try {
			
		}
	}
	
	public static EquationSegment formulaToGroup(String formula) {
		String[] separatedFormula = formula.split("\\s+");
		Symbol[] convertedSegments = new EquationSegment[separatedFormula.length];
		
		int i = 0;
		for (EquationSegment segment : separatedFormula) {
			convertedSegments[i] = new EquationSegment(segment);
			i++;

		}
		EquationSegment group = new EquationSegment("Group");
		group.assignContents(convertedSegments);
		return group;
	}
	
	EquationSegment leftSide;
	EquationSegment rightSide;
	
	public Equation(String formula) {
		EquationSegment separatedFormula = formulaToGroup(formula);
		System.out.print(separatedFormula);
	}
	
	public static void main(String[] args) {
		Equation testEQ = new Equation("54 + 93");
		
	}
}
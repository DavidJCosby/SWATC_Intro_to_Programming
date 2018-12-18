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

	public EquationSegment newConstant(String num) {
		EquationSegment const = new EquationSegment("Constant");
		const.assignValue(Double.parseDouble(num));
		const.symbol = num;
		return const;
	}
	
	public EquationSegment newVariable(String symbol) {
		EquationSegment var = new EquationSegment("Variable");
		var.symbol = synbol;
		return var;
	}

	public EquationSegment newGroup(EquationSegment[] contents) {
		EquationSegment group = new EquationSegment("Group");
		group.assignContents(contents);
		return group;
	}

	
	public static boolean isInteger(String s) { // via https://stackoverflow.com/questions/5439529/determine-if-a-string-is-an-integer-in-java
		try { 
			Integer.parseInt(s); 
		} catch(NumberFormatException e) { 
			return false; 
		} catch(NullPointerException e) {
			return false;
		}
		
		return true;
	}
	
	
	public EquationSegment clusterOfVariablesToSingleVariable(String cluster) {
		if (isInteger(cluster)) {
			return newConstant(cluster);
		}
		else {
			if (cluster.length() == 1) {
				return newVariable(seg);
			}
			else {
				EquationSegment base = newVariable(cluster.substring(cluster.length() - 1, cluster.length() - 2));
				EquationSegment[] coefficients = new EquationSegment[cluster.length - 1];
				int counter = 0;
				for (int i = cluster.length()-1; i > 0; i--) {
					String seg = cluster.substring(i - 1, i - 2);
					coefficients[counter] = newVariable(seg);
				}
				
				for (int i = 0; i < coefficients.length; i++) {
					coefficients[]
				}
			}
		}
	}
	
	public EquationSegment stringToSegment(String str) {
		String uppercase = str.toUpperCase();
		String[] splitByNumbers = str.split("[^A-Z0-9]+|(?<=[A-Z])(?=[0-9])|(?<=[0-9])(?=[A-Z])");
		String type = "Constant";
		
		if (splitByNumbers.length == 1) {
			String seg = splitByNumbers[0];
			if (seg.length() == 1) {
				if (isInteger(seg)) {
					return newConstant(seg);
				}
				else {
					return newVariable(seg);
				}
			}
		}
		
		else {
			
			String base = splitByNumbers[splitByNumbers.length-1];
			
			EquationSegment[] coefficients = new String[splitByNumbers.length-1];
			
			int counter = 0;
			for (int i = (splitByNumbers.length-2); i > 0; i--) {
				String portion = splitByNumbers[i];
				if (isInteger(portion)) { // numeric coefficient
					coefficients[counter] = newConstant(portion);
				}
				else { // variable or a bunch of variables
					
				}
			}

		}
		
			}
	
	public static EquationSegment formulaToGroup(String formula) {
		String[] splitBySpaces = formula.split("\\s+");
		Symbol[] convertedSegments = new EquationSegment[splitBySpaces.length];
		
		int i = 0;
		for (EquationSegment segment : splitBySpaces) {
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
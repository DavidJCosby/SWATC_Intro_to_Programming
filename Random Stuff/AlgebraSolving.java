class Group {
	Symbol[] contents;
	
	public Group(Symbol[] formula) {
		contents = new Symbol[formula.length];
		contents = formula.clone();
	}
	
	public String toString() {
		String composite = "";
		
		for (Symbol s : contents) {
			composite += s;
			//composite += s.toString();
		}
		return composite;
	}
	
	//public Group simplify() {
		
	//}

}


class EquationSegment {
	String type = "Blank"; // Variable, Constant, Group, Blank
	EquationSegment[] contents;
	String symbol = "";
	EquationSegment coefficient;
	double value = 0;
	boolean hasValueAssigned = false;
	
	public EquationSegment(String s) {
		type = s;
	}
	
	//public String toString() {
		
	//}
	
	
	
	public void assignSymbol(String s) {
		if (type == "Group") {
			System.out.print("Symbol cannot be assigned to " + this + " because it is of type Group.");
			return void;
		}
		else {
			symbol = s;
		}
	}
	
	public void assignValue(double v) {
		if (type == "Group") {
			System.out.print("Value cannot be directly assigned to " + this + " because it is of type Group.");
			return void;
		}
		else {
			value = v;
			hasValueAssigned = true;
		}
	}
	
	public void assignCoefficient(EquationSegment c) {
		if (type == "Constant") {
			System.out.print("Coefficient cannot be assigned to Constants!");
			return void;
		}
		else {
			coefficient = c;
		}
	}
	
	
	public void assignContents(EquationSegment[] newContents) {
		if (!type == "Group") {
			System.out.print("contents cannot be assigned to " + this + " because it isn't a group!");
			return void;
		}
		else {
			contents = new EquationSegment[newContents.length];
			contents = newContents.clone();
		}
	}
	
	
	public EquationSegment tryConvertToConstant() {
		if (type == "Constant") {
			return this;
		}
		else if (type == "Variable") {
			if (hasValueAssigned) {
				if (coefficient) {
					coefficient = coefficient.tryConvertToConstant();
					if (coefficient.type == "Variable") {
						return this;
					}
					else {
						/////////////////////////////////////////////////////////continue here
					}
				}
				Double newValue = (coefficient * value);
				Symbol converted = new Symbol("" + newValue);
				converted.value = newValue;
			}
		}
	}
	
	
	
}

// rewriting below class to make it more usable.
class Symbol {
	
	String character = "";
	double value;
	double coefficient = 1;
	boolean hasValue = false;
	
	public Symbol(String s) {
		character = s;
	}
	
	public String toString() {
		String returnValue = "";
		if (coefficient == 0 || ("" + character) == "null") {
			return "";
		}
		if (coefficient != 1) {
			returnValue += coefficient;
		}
		returnValue += character;
		
		return returnValue;
	}
	
	public Symbol tryConvertToConstant() {
		if (!hasValue) {
			return this;
		}
		Double newValue = (coefficient * value);
		Symbol converted = new Symbol("" + newValue);
		converted.value = newValue;
		return converted;		
	}
}



class Equation {
	public static Group formulaToGroup(String formula) {
		String[] separatedFormula = formula.split("\\s+");
		Symbol[] convertedSymbols = new Symbol[separatedFormula.length]; // todo: use up less memory please
		
		int i = 0;
		for (String symbol : separatedFormula) {
			convertedSymbols[i] = new Symbol(symbol);
			i++;

		}
		return new Group(convertedSymbols);
	}
	
	Group leftSide;
	Group rightSide;
	
	public Equation(String formula) {
		Group separatedFormula = formulaToGroup(formula);
		System.out.print(separatedFormula);
	}
	
	public static void main(String[] args) {
		Equation testEQ = new Equation("y = mx + b");
		
	}
}
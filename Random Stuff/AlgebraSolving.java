class Group {
	Symbol[] contents;
	
	public Group(Symbol[] formula) {
		contents = formula;
	}
	
	//public Group simplify() {
		
	//}

}

class Symbol {
	String character;
	double value;
	double coefficient = 1;
	boolean hasValue = false;
	
	public Symbol(String s) {
		character = s;
	}
	
	public String toString() {
		String returnValue = "";
		if (coefficient == 0 || character == null) {
			return returnValue;
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
		Symbol[] convertedSymbols};
		
		int i = 0;
		for (String symbol : separatedFormula) {
			i++;
			convertedSymbols[i] = new Symbol(symbol);
		}
		return new Group(convertedSymbols);
	}
	
	Group leftSide;
	Group rightSide;
	
	public Equation(String formula) {
		Group separatedFormula = formulaToGroup(formula);
	}
	
	public static void main(String[] args) {
		Equation testEQ = new Equation("y = mx + b");
	}
}
import java.util.*;

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
			return composite;
		}
		else if (type == "Blank") {
			return "";
		}
		return "";
	}
	
	public void assignValue(double v) {
		if (type == "Group" || type == "Operator" || type == "Blank") {
			System.out.print("Values cannot be assigned to " + type + "s.");
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

			case "Variable":
				if (coefficient.hasValueAssigned) {
					return "" + (coefficient.value * Double.parseDouble(getTrueCoefficientValue()));
				}
				break;
			default:
				return "1";
		}
		return "";
	}
	
	public void assignContents(EquationSegment[] newContents) {
		if (type != "Group") {
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
						
						// if, for example, x was known to have a value of 2, 6x would become 6(2)
						return this;
					}
				}
				break;
			default:
				return this;
				break;
		}
	}
	return this;
}

class Equation {

	public EquationSegment newConstant(String num) {
		EquationSegment constant = new EquationSegment("Constant");
		constant.assignValue(Double.parseDouble(num));
		constant.symbol = num;
		return constant;
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

	
	public static boolean isNumber(String s) { // via https://stackoverflow.com/questions/5439529/determine-if-a-string-is-an-integer-in-java
		try { 
			Double.parseDouble(s); 
		} catch(NumberFormatException e) { 
			return false; 
		} catch(NullPointerException e) {
			return false;
		}
		
		return true;
	}
	
	
	public EquationSegment stringToSegment(String str) {
		String[] splitByNumbers = str.split("[^A-Z0-9]+|(?<=[A-Z])(?=[0-9])|(?<=[0-9])(?=[A-Z])");
		ArrayList<String> splitByCoefficients = new ArrayList<String>();
		
		for (String seg : splitByNumbers) {
			if (isNumber(seg)) {
				splitByCoefficients.add(seg);
			}
			else {
				String[] splitIntoCharacters = seg.split("");
				for (String ch : splitIntoCharacters) {
					splitByCoefficients.add(ch);
				}
			}
		}
		
		System.out.print(splitByCoefficients);
		
		return newConstant("83");
	}
	
	public EquationSegment formulaToGroup(String formula) {
		String[] splitBySpaces = formula.split("\\s+");
		Symbol[] convertedSegments = new EquationSegment[splitBySpaces.length];
		
		int i = 0;
		for (String segment : splitBySpaces) {
			EquationSegment coefficientForm = stringToSegment(segment);
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
		formula = formula.toUpperCase();
		EquationSegment separatedFormula = formulaToGroup(formula);
		System.out.print(separatedFormula);
	}
	
	public static void main(String[] args) {
		Equation testEQ = new Equation("54 + 93");
		
	}
}
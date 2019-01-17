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
		String base = "";
		if (coefficient != null) {
			if (coefficient.value != 1) {
				if (coefficient.value == -1) {
					base = "-";
				}
				else {
					base = coefficient + "";
				}
			}

		}
		if (type == "Variable" || type == "Constant" || type == "Operator") {
			return base + symbol;
		}
		else if (type == "Group") {
			String composite = base + "(";
			for (EquationSegment eqSeg : contents) {
				composite += eqSeg;
			}
			return composite + ")";
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
	
	public void assignContents(EquationSegment[] newContents) {
		if (type != "Group") {
			System.out.print("contents cannot be assigned to " + this + " because it isn't a group!");
		}
		else {
			contents = new EquationSegment[newContents.length];
			contents = newContents.clone();
		}
	}
	

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
		var.symbol = symbol;
		return var;
	}

	public EquationSegment newGroup(EquationSegment[] contents) {
		EquationSegment group = new EquationSegment("Group");
		group.assignContents(contents);
		return group;
	}
	
	public EquationSegment newOperator(String symbol) {
		EquationSegment operator = new EquationSegment("Operator");
		operator.symbol = symbol;
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
	
	
	public ArrayList<String> extractCoefficients(String str) {
		String[] splitByNumbers = str.split("[^A-Z0-9-.]+|(?<=[A-Z])(?=[0-9])|(?<=[0-9])(?=[A-Z])"); // TODO: find a way to do this that isn't terrible.
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
		
		//System.out.print(splitByCoefficients);
		return splitByCoefficients;
	}
	
	public ArrayList<EquationSegment> coefficientListToSegments(ArrayList<String> coefficientList) {
		ArrayList<EquationSegment> segments = new ArrayList<EquationSegment>();
		for (String coefficient : coefficientList) {
			if (isNumber(coefficient)) {
				segments.add(newConstant(coefficient));
			}
			else {
				segments.add(newVariable(coefficient));
			}
		}
		return segments;
	}
	
	
	public EquationSegment mergeCoefficients(ArrayList<EquationSegment> coefficients) {
		while (coefficients.size() > 1) {
			EquationSegment base = coefficients.get(1);
			EquationSegment coef = coefficients.get(0);

			base.coefficient = coef;
			coefficients.set(1, base);
			coefficients.remove(0);
		}
		return coefficients.get(0);
	}
	
	public EquationSegment stringToCoefficient(String s) {
		ArrayList<String> coefficientList = extractCoefficients(s);
		ArrayList<EquationSegment> variables = coefficientListToSegments(coefficientList);
		//return newConstant("420");
		return mergeCoefficients(variables);
	}
	
	

	
	public EquationSegment formulaToGroup(String formula) {
		//formula = formula.replaceAll("\\s+", "");
		int lastInterruption = 0;
		
		String[] splitBySpaces = formula.split("\\s+");
		EquationSegment[] convertedSegments = new EquationSegment[splitBySpaces.length];
		
		int i = 0;
		for (String segment : splitBySpaces) {
			
			EquationSegment coefficientForm = stringToCoefficient(segment);
			//System.out.println(coefficientForm);
			convertedSegments[i] = coefficientForm;
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
		int equalSignPosition = formula.indexOf('=');
		
		if (equalSignPosition > 0) {
			String right = formula.substring(equalSignPosition + 1);
			//System.out.print(right);
			rightSide = formulaToGroup(right);
			String left = formula.substring(0, equalSignPosition);
			leftSide = formulaToGroup(left);
		}
		else {
			leftSide = formulaToGroup(formula);
		}
		
		System.out.print(leftSide + " = " + rightSide);
	}
	
	public static void main(String[] args) {
		Equation testEQ = new Equation("y=3.14rrh");
		
	}
}
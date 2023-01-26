package mid_jan;

import java.util.Stack;

public class AlternateSolution_1 {
	static String alp = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
	static String symbols = "+-*/";

	public static void main(String[] args) {
		String input = "(a+b)(a*b)";
		String input1 = "(ab)(ab+)";
		String input2 = "((a*b)";
		String input3 = "(a+b)+(a-b)";
		String input4 = "a+b";
		String input5 = "(a+b)+c+(a-b)";

		System.out.println(expressionValidation1(input));
		System.out.println(expressionValidation1(input1));
		System.out.println(expressionValidation1(input2));
		System.out.println(expressionValidation1(input3));
		System.out.println(expressionValidation1(input4));
		System.out.println(expressionValidation1(input5));
	}

	public static boolean expressionValidation1(String s) {
		if (s.length() < 3) {
			return false;
		}
		Stack<Character> brackets = new Stack<>();
		for (int i = 0; i < s.length(); i++) {

			if (i != s.length() - 1 && (s.charAt(i) == '(' && s.charAt(i + 1) == ')')) {
				return false;
			}

			// To add the open brackets in the stack
			if (s.charAt(i) == '(') {
				brackets.add('(');
				continue;
			}

			// To remove the open brackets form the stack
			if (s.charAt(i) == ')') {

				// If There is no bracket It will return false
				if (!brackets.isEmpty() && brackets.peek() == '(') {
					brackets.pop();
					continue;
				} else
					return false;
			}

			// To Check the symbols
			if (alp.indexOf(s.charAt(i)) == -1) {

				// If the symbol not present in the string symbols it will return false
				if (symbols.indexOf(s.charAt(i)) != -1) {

					// character or brackets should be present before and after the symbol
					// else false
					if ((alp.indexOf(s.charAt(i - 1)) != -1 && alp.indexOf(s.charAt(i + 1)) != -1)
							|| (s.charAt(i - 1) == ')' && s.charAt(i + 1) == '(')) {
						continue;
					} else if ((s.charAt(i - 1) == ')' || s.charAt(i + 1) == '(')
							&& (alp.indexOf(s.charAt(i - 1)) != -1 || alp.indexOf(s.charAt(i + 1)) != -1)) {
						continue;
					} else {
						return false;
					}

				} else {
					return false;
				}
			}

			// To check the characters
			if ((i != 0 && i != s.length() - 1) && alp.indexOf(s.charAt(i)) != -1) {
				if (!(alp.indexOf(s.charAt(i - 1)) == -1 && alp.indexOf(s.charAt(i + 1)) == -1)) {
					return false;
				}
			}
		}

		// At the end the stack has to be empty or else it will return false
		return brackets.isEmpty();
	}
}


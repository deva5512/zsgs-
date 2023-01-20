package mid_jan;

import java.util.Stack;

public class Question_1 {
	public static void main(String[] args) {
		String input = "(a+b)(a*b)";
		String input1 = "(ab)(ab+)";
		String input2 = "((a*b)";
		System.out.println(expressionValidation1(input));
	}

	// This one won't accept the values like AB
	public static boolean expressionValidation1(String s) {
		Stack<Character> brackets = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				brackets.add('(');
				continue;
			}
			if (s.charAt(i) == ')') {
				if (brackets.peek() == '(') {
					brackets.pop();
					continue;
				} else
					return false;
			}
			if (s.charAt(i) < 'a' || s.charAt(i) > 'z') {
				if (i != 0 && i != s.length() - 1) {
					if ((s.charAt(i - 1) < 'a' || s.charAt(i + 1) > 'z')
							|| (s.charAt(i + 1) < 'a' || s.charAt(i + 1) > 'z')) {
						return false;
					}
				}
			}
			if (s.charAt(i) >= 'a' && s.charAt(i) <= 'z') {
				if ((s.charAt(i - 1) >= 'a' && s.charAt(i - 1) <= 'z')
						|| (s.charAt(i + 1) >= 'a' && s.charAt(i + 1) <= 'z')) {
					return false;
				}
			}
		}
		return brackets.isEmpty();
	}

	// This one accept the values like AB it will assume AB as A*B
	public static boolean expressionValidation(String s) {
		Stack<Character> brackets = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				brackets.add('(');
				continue;
			}
			if (s.charAt(i) == ')') {
				if (brackets.peek() == '(') {
					brackets.pop();
					continue;
				} else
					return false;
			}
			if (s.charAt(i) < 'a' || s.charAt(i) > 'z') {
				if (i != 0 && i != s.length() - 1) {
					if ((s.charAt(i - 1) < 'a' || s.charAt(i + 1) > 'z')
							|| (s.charAt(i + 1) < 'a' || s.charAt(i + 1) > 'z')) {
						return false;
					}
				}
			}
		}
		return brackets.isEmpty();
	}
}


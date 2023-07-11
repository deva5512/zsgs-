package PreparationQuestions;

public class ValidateExpression {

	public static void main(String[] args) {
		String str = "(10+2*";
		validExpression(str);
	}

	private static void validExpression(String str) {
		char[] arr = convertCharArray(str);
		if (!checkPatanthesis(arr) || !validateSymbols(arr) || !validatenumbers(arr)) {
			System.out.println("invalid expression");
			return;
		}
		System.out.println("valid expression");
	}

	private static boolean validatenumbers(char[] arr) {
		for (int i = 0; i < arr.length; i++) {
			char ch = arr[i];
			if (ch == '0' && (i == 0 || !(arr[i - 1] >= '0' && arr[i - 1] <= '9')))
				return false;
		}
		return true;
	}

	private static boolean validateSymbols(char[] arr) {
		for (int i = 0; i < arr.length; i++) {
			char ch = arr[i];
			if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
				if (i == arr.length - 1 || arr[i + 1] == ')')
					return false;
				if (ch != '-' && (i == 0 || arr[i - 1] == '('))
					return false;
				if (i != arr.length - 1) {
					ch = arr[i + 1];
					if (ch == '+' || ch == '-' || ch == '*' || ch == '/')
						return false;
				}
			}
		}
		return true;
	}

	private static boolean checkPatanthesis(char[] arr) {
		int open = 0, close = 0;
		for (int i = 0, j = arr.length - 1; j >= 0; i++, j--) {
			if (arr[i] == '(')
				open++;
			if (arr[i] == ')')
				open--;
			if (open < 0) {
				return false;
			}

			if (arr[j] == ')')
				close++;
			if (arr[j] == '(')
				close--;
			if (close < 0)
				return false;
		}
		return true;
	}

	private static char[] convertCharArray(String str) {
		char[] arr = new char[str.length()];
		for (int i = 0; i < str.length(); i++)
			arr[i] = str.charAt(i);
		return arr;
	}

}

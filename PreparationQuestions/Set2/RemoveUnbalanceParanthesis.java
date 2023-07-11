package PreparationQuestions;

public class RemoveUnbalanceParanthesis {

	public static void main(String[] args) {
		String str = "(((ab)";
		char[] arr = convertToCharArray(str);
		removePatanthesis(arr);
	}

	private static void removePatanthesis(char[] arr) {
		int open = 0, close = 0;
		for (int i = 0, j = arr.length - 1; j >= 0; i++, j--) {
			if (arr[i] == '(')
				open++;
			if (arr[i] == ')')
				open--;
			if (open < 0) {
				arr[i] = ' ';
				open = 0;
			}

			if (arr[j] == ')')
				close++;
			if (arr[j] == '(')
				close--;
			if (close < 0) {
				arr[j] = ' ';
				close = 0;
			}
		}
		StringBuilder res = new StringBuilder();
		for (char ch : arr)
			if (ch != ' ')
				res.append(ch);
		System.out.println(res);
	}

	private static char[] convertToCharArray(String str) {
		char[] arr = new char[str.length()];
		for (int i = 0; i < arr.length; i++)
			arr[i] = str.charAt(i);
		return arr;
	}

}

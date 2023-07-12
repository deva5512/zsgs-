package PreparationQuestions.Set4;

public class CountingPattern {

	public static void main(String[] args) {
		int n = 15;
		pattern(n);
	}

	private static void pattern(int n) {
		String str = "1";
		for (int i = 0; i < n; i++) {
			System.out.println(str);
			str = countConsequtiveWords(str);
		}
	}

	private static String countConsequtiveWords(String str) {
		String s = "";
		int count = 1;
		for (int i = 1; i < str.length(); i++) {
			if (str.charAt(i) == str.charAt(i - 1))
				count++;
			else {
				s += count + "" + str.charAt(i - 1);
				count = 1;
			}
		}
		s += count + "" + str.charAt(str.length() - 1);
		return s;
	}

}

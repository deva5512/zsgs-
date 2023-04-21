package PreparationQuestions;

public class Five_19_04_2023 {

	public static void main(String[] args) {
		String word = "hello world";
		convertToHexaDecimal(word);
	}

	private static void convertToHexaDecimal(String word) {

		String res = "";
		for (int i = 0; i < word.length(); i++) {
			int code = (int) word.charAt(i);
			res += Integer.toHexString(code);
		}
		System.out.println(res);
	}

	private static void convertToHexaDecimal1(String word) {

		String res = "";
		for (int i = 0; i < word.length(); i++) {
			int code = (int) word.charAt(i);
			res += Integer.toHexString(code);
		}
		System.out.println(res);
	}

}

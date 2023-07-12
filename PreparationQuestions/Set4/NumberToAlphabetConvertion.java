package PreparationQuestions.Set4;

public class NumberToAlphabetConvertion {

	public static void main(String[] args) {
		int num = 52;
		convertAlphabet(num);
	}

	private static void convertAlphabet(int num) {
		String res = "";
		while (num > 0) {
			int rem = num % 26;
			if (rem == 0)
				num--;
			num /= 26;
			if (rem == 0)
				res = 'Z' + res;
			else {
				res = ((char) ('A' + --rem)) + res;
			}
		}
		System.out.println(res);
	}

}

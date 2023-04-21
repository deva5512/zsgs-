package PreparationQuestions;

public class Three_18_04_2023 {
	public static void main(String[] args) {
		patternPrinting("devendran");
	}

	public static void patternPrinting(String word) {
		if ((word.length() & 1) == 0) {
			System.out.println("Invalid");
			return;
		}

		int mid = word.length() / 2;
		for (int i = 0; i < word.length(); i++) {
			for (int j = 0; j < word.length(); j++) {
				if (j == mid || i == j || (i + j) == word.length() - 1) {
					System.out.print(word.charAt(i)+" ");
				} else if (i == mid) {
					System.out.print(word.charAt(j)+" ");
				} else {
					System.out.print("  ");
				}
			}
			System.out.println();
		}
	}
}

package PreparationQuestions.Set3;

public class PatternX {

	public static void main(String[] args) {
		String str = "geeksforgeeks";
		pattern(str);
	}

	public static void pattern(String str) {
		int n = str.length();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i == j || i + j == n - 1)
					System.out.print(str.charAt(j) + " ");
				else
					System.out.print("  ");
			}
			System.out.println();
		}
	}

}

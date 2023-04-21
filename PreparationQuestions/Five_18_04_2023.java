package PreparationQuestions;

public class Five_18_04_2023 {
	public static void main(String[] args) {
		varArge("");
		varArge("a", "bb", "ccc");
		varArge("aaa");
	}

	public static void varArge(String... s) {
		for (int i = 0; i < s.length; i++) {
			System.out.print(s[i] + " ");
		}
		System.out.println();
	}
}

package PreparationQuestions.Set4;

public class OddNumberInRange {

	public static void main(String[] args) {
		int s = 2, e = 15;
		findOddNumberInRange(s, e);
	}

	private static void findOddNumberInRange(int s, int e) {
		for (; s < e; s++) {
			if ((s & 1) == 1)
				System.out.print(s + " ");
		}
	}
}

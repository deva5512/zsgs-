package Z_sums;

public class A_84 { // 84.Java Program to find the frequency of odd & even numbers in the given
					// matrix
	static int total = 0;

	public static void main(String[] args) {
		int[][] a = { { 1, 5, 4, 6, 2, 8, 9, 3 }, { 4, 5, 6, 7, 7, 8, 8, 8, 9, 2, 3, 5, 4, 8, 6 },
				{ 4, 8, 6, 2, 4, 86, 2, 4, 8, 6 } };
		eocount(a);
		System.out.println("In a total of : " + total);

	}

	public static void eocount(int[][] a) {
		int even = 0, odd = 0;
		for (int[] i : a) {
			for (int j : i) {
				if (j % 2 == 0) {
					even++;
				} else
					odd++;
				total++;
			}
		}
		System.out.println("Even : " + even);
		System.out.println("Odd : " + odd);
	}
}

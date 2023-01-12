package Z_sums;

import java.util.Arrays;

public class A_75 { // 75.Print Odd and Even Number from an Array
	public static void main(String[] args) {
		int[] a = { 1, 2, 3, 4, 5, 7, 8, 4, 1, 2, 5, 6, 9, 3, 5, 4, 1, 2, 5, 6, 3, 1, 4, 5, 7, 8, 9, 5, 6, 3, 5 };
		int evens = 0;
		int eve[] = new int[a.length];
		for (int i : a) {
			if (i % 2 == 0) {
				eve[evens++] = i;
			}
		}
		eve = Arrays.copyOf(eve, evens);
		int odd[] = new int[a.length - evens];
		evens = 0;
		for (int i : a) {
			if (i % 2 == 1) {
				odd[evens++] = i;
			}
		}

		System.out.println("Odd numbers : " + Arrays.toString(odd));
		System.out.println("Even numbers : " + Arrays.toString(eve));

	}
}

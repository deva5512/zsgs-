package Z_sums;

import java.util.Arrays;

public class A_77 { // 77.Java Program to sort the elements of an array in ascending order

	public static void main(String[] args) {
		int[] a = { 8, 5, 2, 1, 4, 6, 7, 3, 9 };
		System.out.println(Arrays.toString(a));
		bubble(a);
		System.out.println(Arrays.toString(a));

	}

	public static void bubble(int[] a) {
		for (int i = 0; i < a.length - 1; i++) {
			for (int j = 0; j < a.length - 1; j++) {
				if (a[j] > a[j + 1]) {
					int temp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = temp;
				}
			}
		}
	}
}

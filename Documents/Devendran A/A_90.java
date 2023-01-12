package Z_sums;

import java.util.Arrays;

public class A_90 { // 90.Java Program to sort the words in ascending.

	public static void main(String[] args) {
		String[] a = { "apple", "orange", "banana", "Aanachi" };
		System.out.println(Arrays.toString(a));
		wordSorter(a);
		System.out.println(Arrays.toString(a));
	}

	public static void wordSorter(String[] a) {
		String temp = "";
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length - 1; j++) {
				if (a[j].toUpperCase().charAt(0) > a[j + 1].toUpperCase().charAt(0)) {
					temp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = temp;
				}
			}
		}
	}
}

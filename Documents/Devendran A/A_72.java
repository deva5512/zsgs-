package Z_sums;

import java.util.Arrays;

public class A_72 { // 72.Java Program to remove Duplicate Element in an Array

	public static void main(String[] args) {
		int[] a = { 1, 1, 2, 3, 1, 4, 2, 1, 3, 5, 6, 2, 1, 3, 2 };
		System.out.println(Arrays.toString(a));
		rem(a);
		int count = 0;
		for (int i : a) {
			if (i != 0) {
				count++;
				System.out.print(i + " ");
			}
		}
		System.out.println();
		int[] res = new int[count];
		count = 0;
		for (int i : a) {
			if (i != 0)
				res[count++] = i;
		}
		System.out.println(Arrays.toString(res));
	}

	public static void rem(int[] a) {
		for (int i = 0; i < a.length; i++) {
			for (int j = i + 1; j < a.length; j++) {
				if (a[i] == a[j]) {
					a[j] = 0;
				}
			}
		}
	}

}

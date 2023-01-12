package zohosums;

import java.util.Arrays;
import java.util.Scanner;

public class FiftySeven_57 {
	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("Enter a number : ");
		int num = s.nextInt();
		int temp = num, count = 0;
		while (num > 0) {
			count++;
			num /= 10;
		}
		num = temp;
		int[] a = new int[count];
		for (int i = 0; i < a.length; i++) {
			a[i] = num % 10;
			num /= 10;
		}
		Arrays.sort(a);
		for (int i = 0; i < count; i++) {
			for (int j = 0; j < count; j++) {
				if (i == j) {
					System.out.print(a[j] + " ");
				} else if (i + j == count - 1) {
					System.out.print(a[j] + " ");
				} else {
					System.out.print("  ");
				}
			}
			System.out.println();
		}
	}

}

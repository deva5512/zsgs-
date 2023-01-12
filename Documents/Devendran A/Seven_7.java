package zohosums;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Seven_7 {
	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.print("Enter a number : ");
		int num = s.nextInt();
		int temp = num, count = 0;

		while (num > 0) {
			count++;
			num /= 10;
		}

		ArrayList a = new ArrayList();
		for (int i = 0; i < count; i++) {
			int rem = temp % 10;
			a.add(i, rem);
			temp /= 10;
		}
		Collections.reverse(a);

		for (int i = 0; i < count; i++) {
			for (int j = 0; j < count; j++) {
				if (i == j || i + j == count - 1) {
					System.out.print(a.get(i) + " ");
				} else {
					System.out.print("  ");
				}
			}
			System.out.println();
		}
	}
}

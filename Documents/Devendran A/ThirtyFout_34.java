package zohosums;

import java.util.Scanner;

public class ThirtyFout_34 {
	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("Enter the stating number : ");
		int start = s.nextInt();
		System.out.println("Enter the ending number : ");
		int last = s.nextInt();

		int sum = 0;
		for (int i = start; i <= last; i++) {
			sum += i;
		}
		int temp = sum, count = 0;
		while (sum > 0) {
			count++;
			sum /= 10;
		}
		sum = temp;
		System.out.println(sum);
		int[] a = new int[count];
		int greatest = 0;
		for (int i = 0; i < a.length; i++) {
			a[i] = sum % 10;
			sum /= 10;
			if (greatest < a[i]) {
				greatest = a[i];
			}
		}
		System.out.println(greatest);
	}
}

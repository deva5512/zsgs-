package zohosums;

import java.util.Arrays;
import java.util.Scanner;

public class FiftyFour_54 {
	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("Enter the size of the array ");
		int[] a = new int[s.nextInt()];
		int odd[] = new int[a.length / 2];
		int even[] = new int[a.length - odd.length];
		for (int i = 0, m = 0, n = 0; i < a.length; i++) {
			System.out.print("Enter : ");
			a[i] = s.nextInt();
			if (i % 2 == 0) {
				even[m++] = a[i];
			} else {
				odd[n++] = a[i];
			}
		}
		Arrays.sort(even);
		int temp = 0;
		for (int i = 0; i < odd.length - 1; i++) {
			for (int j = 0; j < odd.length - 1; j++) {
				if (odd[j] < odd[j + 1]) {
					temp = odd[j];
					odd[j] = odd[j + 1];
					odd[j + 1] = temp;
				}
			}
		}
		for (int i = 0, m = even.length - 1, n = odd.length - 1; i < a.length; i++) {
			if (i % 2 == 0) {
				System.out.print(even[m--] + " ");
			} else {
				System.out.print(odd[n--] + " ");
			}
		}

	}

	public static void print(int[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}
}

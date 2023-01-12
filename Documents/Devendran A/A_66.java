package Z_sums;

import java.util.Scanner;

public class A_66 { // 66.Java Program to left rotate the elements of an array
	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		int[] a = { 1, 2, 3, 4, 5 };
		System.out.print("Enter the number of rotation : ");
		int num = s.nextInt();
		rotate(a, num);
		p(a);
	}

	public static void rotate(int[] a, int times) {
		for (int r = 0; r < times; r++) {
			int last = a[a.length - 1];
			for (int i = a.length - 1; i > 0; i--) {
				a[i] = a[i - 1];
			}
			a[0] = last;
		}
	}

	public static void p(int[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}
}

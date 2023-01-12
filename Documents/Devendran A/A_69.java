package Z_sums;

import java.util.Scanner;

public class A_69 { // 69.Java Program to rotate the elements of an array in the right direction

	public static void main(String[] args) {
		int[] a = { 1, 2, 3, 4, 5 };
		System.out.print("Enter the number of rotation : ");
		Scanner s = new Scanner(System.in);
		int num = s.nextInt();
		s.close();
		right(a, num);
		print(a);
	}

	public static void right(int[] a, int times) {
		for (int t = 0; t < times; t++) {
			int first = a[0];
			for (int i = 0; i < a.length - 1; i++) {
				a[i] = a[i + 1];
			}
			a[a.length - 1] = first;
		}
	}

	public static void print(int[] a) {
		for (int i : a) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
}

package Z_sums;

import java.util.Scanner;

public class B_69 {
	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		int[] a = { 1, 2, 3, 4, 5 };
		System.out.print("Enter the number of rotation : ");
		int num = s.nextInt();
		rot(a, num, 0);
		A_69.print(a);
	}

	public static void rot(int[] a, int times, int i) {
		if (i < times) {
			int first = a[0];
			shift(a, 0);
			a[a.length - 1] = first;
			rot(a, times, ++i);
		}
	}

	public static void shift(int[] a, int j) {
		if (j < a.length - 1) {
			a[j] = a[j + 1];
			shift(a, ++j);
		}
	}
}

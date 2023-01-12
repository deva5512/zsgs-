package Z_sums;

import java.util.Scanner;

public class B_66 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int[] a = { 1, 2, 3, 4, 5 };
		System.out.print("Enter the number of rotation : ");
		int num = s.nextInt();
		s.close();
		times(a, num, 0);
		A_66.p(a);
	}

	public static void times(int[] a, int rot, int start) {
		if (start < rot) {
			int last = a[a.length - 1];
			rotate(a, a.length - 1);
			a[0] = last;
			times(a, rot, ++start);
		}
	}

	public static void rotate(int[] a, int s) {
		if (s > 0) {
			a[s] = a[s - 1];
			rotate(a, --s);
		}
	}
}

package Z_sums;

import java.util.Arrays;

public class C_63 {
	public static void main(String[] args) {
		int[] a = { 1, 2, 5, 6, 9, 8, 7, 5, 1, 0, 12, 15, 25 };
		Arrays.sort(a);
		System.out.println("Smallest : " + a[0]);
		System.out.println("Largest : " + a[a.length - 1]);
	}
}

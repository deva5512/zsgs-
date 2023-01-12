package Z_sums;

import java.util.Arrays;
import java.util.Scanner;

public class B_71 {
	public static void main(String[] args) {
		int[] a = { 5, 6, 9, 8, 1, 2, 3, 4, 7, 0 };
		Arrays.sort(a);
		System.out.print("Enter the number : ");
		Scanner s = new Scanner(System.in);
		int num = s.nextInt();
		s.close();
		System.out.println(num + " smallest number is " + a[num - 1]);
	}
}

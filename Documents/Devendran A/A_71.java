package Z_sums;

import java.util.Scanner;

public class A_71 { // 71.Java Program to find the 2nd Smallest Number in an Array
	public static void main(String[] args) {
		int[] a = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 0 };
		Scanner s = new Scanner(System.in);
		System.out.println("Enter a number : ");
		int num = s.nextInt();
		s.close();
		int res = second(a, num);
		System.out.println(num + " smallest is : " + res);
	}

	public static int second(int[] a, int no) {
		int smallest = 0;
		for (int t = 0; t < no; t++) {
			smallest = a[0];
			for (int i = 0; i < a.length; i++) {
				if (smallest > a[i]) {
					smallest = a[i];
				}
			}
			rem(a, smallest);
		}
		return smallest;
	}

	public static void rem(int[] a, int key) {
		for (int i = 0; i < a.length; i++) {
			if (key == a[i]) {
				a[i] = 1000;
			}
		}
	}
}

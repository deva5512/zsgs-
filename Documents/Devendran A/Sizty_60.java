package zohosums;

import java.util.Scanner;

public class Sizty_60 {
	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("Enter a number : ");
		int num = s.nextInt();

		int sum = 0, a = 1;
		for (int i = 1; i <= num; i++) {
			sum += a;
			a *= 10;
			a += 1;
		}

		System.out.println(sum);
	}
}

package zohosums;

import java.util.Scanner;

public class ThirtyFive_35 {
	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("Enter a number : ");
		int res = factorial(s.nextInt());
		System.out.println("The factorial is : " + res);
		int sum = 0;
		while (res > 0) {
			int rem = res % 10;
			sum += rem;
			res /= 10;
		}
		System.out.println("The digital sum of factorial is : " + sum);

	}

	public static int factorial(int num) {
		int fact = 1;
		for (int i = 1; i <= num; i++) {
			fact *= i;
		}
		return fact;
	}
}

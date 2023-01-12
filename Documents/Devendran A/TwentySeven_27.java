package zohosums;

import java.util.Scanner;

public class TwentySeven_27 {
	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.print("Enter a number  A : ");
		int a = s.nextInt();
		System.out.print("Enter a number B : ");
		int b = s.nextInt();

		System.out.println("After swaping : ");
		int temp = 0;
		temp = a;
		a = b;
		b = temp;

		System.out.println("A = " + a);
		System.out.println("B = " + b);

	}
}

package zohosums;

import java.util.Scanner;

public class ThirtyOne_31 {
	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.print("a : ");
		double a = s.nextDouble();
		System.out.print("b : ");
		double b = s.nextDouble();
		System.out.print("c : ");
		double c = s.nextDouble();

		double b1 = (b * b) - (4 * (a * c));
		double rt = Math.sqrt(b1);
		b = -b;

		double top = b - rt;
		double top1 = b + rt;

		a = 2 * a;
		double res = top / a;
		double res2 = top1 / a;
		System.out.println(res);
		System.out.println(res2);

	}
}

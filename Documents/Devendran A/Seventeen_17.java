package zohosums;

import java.util.Scanner;

public class Seventeen_17 {
	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		// pi * (R2-r2);
		double pi = 3.14;
		System.out.print("Enter the outer radius : ");
		int or = s.nextInt();
		System.out.print("Enter the inner radius : ");
		int ir = s.nextInt();
		or = or * or;
		ir = ir * ir;

		double res = pi * (or - ir);
		System.out.println(res);
	}
}

package zohosums;

import java.util.Scanner;

public class One_1 {
	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.print("Enter a number : ");
		int num = s.nextInt();
		for (int i = 1; i <= 10; i++) {
			System.out.println(num + " * " + i + " = " + (num * i) + "     " + num + " - " + i + " = " + (num - i));
		}
	}

}

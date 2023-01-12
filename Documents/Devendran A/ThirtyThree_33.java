package zohosums;

import java.util.Scanner;

public class ThirtyThree_33 {
	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("Enter a charactor : ");
		char c = s.next().charAt(0);
		if (c >= 'A' && c <= 'Z' || c >= 'a' && c <= 'z') {
			System.out.println("The entered charactor is a alphabet ");
		} else {
			System.out.println("The entered charactor is not a alphabet ");
		}
	}
}

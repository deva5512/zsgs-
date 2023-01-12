package zohosums;

import java.util.Scanner;

public class Two_2 {
	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.print("Enter a charactor : ");
		char c = s.next().toUpperCase().charAt(0);
		for (char i = c; i <= 'Z'; i++) {
			System.out.print(i + " ");
		}
	}
}

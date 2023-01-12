package zohosums;

import java.util.Scanner;

public class Thirty_30 {
	static Scanner s = new Scanner(System.in);
	public static void main(String[] args) {
		System.out.print("A : ");
		int a = s.nextInt();
		System.out.print("B : ");
		int b = s.nextInt();
		System.out.print("C : ");
		int c = s.nextInt();
		
		int res = (a>b)?((a>c)?a:c):((b>c)?b:c);
		System.out.println("The greatest number is : "+res );
	}

}

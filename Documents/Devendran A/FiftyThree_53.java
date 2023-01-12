package zohosums;

import java.util.Scanner;

public class FiftyThree_53 {
	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("Enter a String : "); // 48 = 0 57 = 9
		String a = s.nextLine();
		int number = 0;
		char ch = ' ';
		for (int i = 0; i < a.length(); i++) {
			if (a.charAt(i) >= '0' && a.charAt(i) <= '9') {
				ch = a.charAt(i - 1);
				for (int j = i; j < a.length(); j++) {
					if (a.charAt(j) >= '0' && a.charAt(j) <= '9') {
						number = number * 10 + value(a.charAt(i));
					} else {
						break;
					}
				}

				if (!(ch >= '0') ^ !(ch <= '9')) {
					for (int k = 0; k < number; k++) {
						System.out.println( ch + " ");
					}
				}
				number = 0;

			}
		}
	}

	static int value(char c) {
		switch (c) {
		case '1':
			return 1;
		case '2':
			return 2;
		case '3':
			return 3;
		case '4':
			return 4;
		case '5':
			return 5;
		case '6':
			return 6;
		case '7':
			return 7;
		case '8':
			return 8;
		case '9':
			return 9;
		case '0':
			return 0;
		}
		return -1;
	}
}

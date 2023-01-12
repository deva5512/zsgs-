package zohosums;

import java.util.Scanner;

public class FiftyNine_59 {
	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("Enter string 1 : ");
		String s1 = s.nextLine();
		System.out.println("Enter string 2 : ");
		String s2 = s.nextLine();
		int len = s2.length();

		int res = o(s1, s2, len);
		System.out.println(res);

	}

	public static int o(String s1, String s2, int len) {
		int fin = s1.length() - len;
		for (int i = 0; i < s1.length(); i++) {
			if (s1.charAt(i) == s2.charAt(0) && i <= fin) {
				if (s2.equals(s1.substring(i, (len + i)))) {
					return i;
				}
			}
		}
		return -1;
	}
}

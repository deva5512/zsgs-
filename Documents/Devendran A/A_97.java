package Z_sums;

import java.util.Arrays;

public class A_97 { // 97.Java program to find a character in a given string using binary search.
	public static void main(String[] args) {
		System.out.println("Enter the String : ");
		String s = A_1methods.s.next();
		System.out.println("Enter the charactor : ");
		char c = A_1methods.s.next().charAt(0);
		if (bs(s, c)) {
			System.out.println("Yes the charactor is present in the String ");
		} else {
			System.out.println("Its not present ");
		}
	}

	public static boolean bs(String s1, char c) {
		char[] ch = s1.toCharArray();
		Arrays.sort(ch);
		int f = 0;
		int l = ch.length - 1;
		while (f <= l) {
			int m = (f + l) / 2;

			if (ch[m] == c) {
				return true;
			} else if (c < ch[m]) {
				l = m - 1;
			} else {
				f = m + 1;
			}
		}

		return false;
	}
}

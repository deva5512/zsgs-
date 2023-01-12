package Z_sums;

import java.util.Arrays;

public class A_94 { // 94.Java Program to find the given two strings are anagram to each other

	public static void main(String[] args) {
		System.out.print("Enter the first String : ");
		String one = A_1methods.s.next();
		System.out.print("Enter the second String : ");
		String two = A_1methods.s.next();
		if (anagram(one, two)) {
			System.out.println("Yes the string is anagram to each other");
		} else {
			System.out.println("No");
		}
	}

	public static boolean anagram(String a, String b) {
		char[] c = a.toCharArray();
		char[] c1 = b.toCharArray();
		if (c.length != c1.length) {
			return false;
		}
		Arrays.sort(c1);
		Arrays.sort(c);
		for (int i = 0; i < c1.length; i++) {
			if (c[i] != c1[i]) {
				return false;
			}
		}
		return true;
	}

}

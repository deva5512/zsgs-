package Z_sums;

import java.util.Arrays;

public class A_92 { // 92.Java Program to sort the words in ascending using recursion.

	public static void main(String[] args) {
		String name = "one   one    apple ";
		name = doubleSpaceRemover(name);
		String[] a = name.split(" ");
		System.out.println(Arrays.toString(a));
		repetation(a, 0);
		String res = A_1methods.StringArrayToStringConverter(a);
		System.out.println(res);

	}

	public static String doubleSpaceRemover(String s) {
		String ret = "";
		String rep = "";
		String org = "";
		for (int i = 0; i < s.length(); i++) {
			if (i != s.length() - 1 && s.charAt(i) == ' ' && s.charAt(i + 1) == ' ') {
				org += s.charAt(i + 1);
				s.replaceFirst(org, rep);
				org = "";
			} else {
				ret += s.charAt(i);
			}
		}
		return ret;
	}

	public static void sorter(String[] a, int i) {

		if (i < a.length - 1) {
			if (a[i].toUpperCase().charAt(0) > a[i + 1].toUpperCase().charAt(0)) {
				String temp = a[i];
				a[i] = a[i + 1];
				a[i + 1] = temp;
			}
			sorter(a, ++i);
		}
	}

	public static void repetation(String[] a, int j) {
		if (j < a.length) {
			sorter(a, 0);
			repetation(a, ++j);
		}
	}

}

package Z_sums;

import java.util.Scanner;

public class A_1methods {
	static Scanner s = new Scanner(System.in);

	public static void p(int[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}

	public static String StringArrayToStringConverter(String[] a) {
		String res = "";
		for (int i = 0; i < a.length; i++) {
			res += a[i] + " ";
		}
		return res;
	}

	public static void pp(int[][] a) {
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static boolean squarMatrix(int[][] a) {
		int len = a.length;
		for (int i = 0; i < a.length; i++) {
			if (a[i].length != len) {
				return false;
			}
		}
		return true;
	}

	public static String charArrayToString(char[] a) {
		StringBuffer res = new StringBuffer();
		for (int i = 0; i < a.length; i++) {
			res.append(a[i]);
		}
		return new String(res);
	}

	public static boolean colEqMatrix(int[][] a) {
		int len = a[0].length;
		int count = 0;
		for (int i = 0; i < a.length; i++) {
			if (len == a[i].length) {
				count++;
			}
		}
		if (count == a.length) {
			return true;
		}
		return false;
	}

	public static boolean twojag(int[][] a, int[][] b) {
		if (a.length != b.length) {
			return false;
		}
		for (int i = 0; i < a.length; i++) {
			if (a[i].length != b[i].length) {
				return false;
			}
		}
		return true;
	}

	public static void lowerTri(int[][] a) {
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				if (i >= j) {
					System.out.print(a[i][j] + " ");
				} else
					System.out.print("  ");
			}
			System.out.println();
		}
	}

	public static void upperTri(int[][] a) {
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				if (i <= j) {
					System.out.print(a[i][j] + " ");
				} else
					System.out.print("  ");
			}
			System.out.println();
		}
	}

	public static void anci() {
		for (char c = 'a'; c <= 'z'; c++) {
			System.out.print(c + "=" + (int) c + "___");
		}
		System.out.println();
	}

	public static void Capanci() {
		for (char c = 'A'; c <= 'Z'; c++) {
			System.out.print(c + "=" + (int) c + "___");
		}
		System.out.println();
	}

	public static void main(String[] args) {

	}
}

package Z_sums;

public class A_81 { // 81.Java Program to determine whether two matrices are equal
	public static void main(String[] args) {
		int[][] a = { { 1, 2 }, { 2, 4, 2 } };
		int[][] b = { { 2, 3 }, { 8, 9, 1 } };
		int[][] c = { { 1, 2 }, { 2, 4, 2 } };
		if (A_1methods.twojag(a, c)) {
			System.out.println(equal(a, c));
		}
		if (A_1methods.twojag(a, b)) {
			System.out.println(equal(a, b));
		}

	}

	public static boolean equal(int[][] a, int b[][]) {
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				if (a[i][j] != b[i][j]) {
					return false;
				}
			}
		}
		return true;
	}
}

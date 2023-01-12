package Z_sums;

public class A_79 { // 79.Java Program to determine whether a given matrix is an identity matrix
	public static void main(String[] args) {
		int[][] a = { { 1, 0, 0 }, { 0, 1, 0 }, { 0, 0, 1 } };
		System.out.println(identity(a));
	}

	public static boolean identity(int[][] a) {
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length; j++) {
				if (i == j && a[i][j] != 1) {
					return false;
				}
				if (i != j && a[i][j] != 0) {
					return false;
				}
			}
		}
		return true;
	}
}

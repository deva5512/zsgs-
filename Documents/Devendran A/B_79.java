package Z_sums;

public class B_79 { // 79.Java Program to determine whether a given matrix is an identity matrix
	public static void main(String[] args) {
		int[][] a = { { 1, 0 }, { 0, 1 } };
		if (A_1methods.squarMatrix(a)) {
			System.out.println(identity(a));
		} else {
			System.out.println("Try a square matrix ");
		}
	}

	private static boolean identity(int[][] a) {
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length; j++) {
				if (i == j && a[i][j] != 1)
					return false;
				else if (i != j && a[i][j] != 0)
					return false;
			}
		}
		return true;
	}

}

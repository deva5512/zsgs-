package Z_sums;

public class A_80 { // 80.Java Program to determine whether a given matrix is a sparse matrix
	public static void main(String[] args) {
		int[][] a = { { 0, 1, 0 }, { 0, 1, 0 }, { 0, 0, 1 } };
		System.out.println(sparse(a));
		int[][] b = { { 1, 2, 2 }, { 5, 6, 8 }, { 0, 0, 0 } };
		System.out.println(sparse(b));
	}

	public static boolean sparse(int[][] a) {
		
		int zeros = 0;
		int size = a.length * a[0].length;
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				if (a[i][j] == 0) {
					zeros++;
				}
			}
		}
		return zeros > size / 2;
	}
}

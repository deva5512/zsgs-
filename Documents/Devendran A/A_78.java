package Z_sums;

public class A_78 { // 78.Java Program to subtract the two matrices

	public static void main(String[] args) {
		int[][] a = { { 1, 5 }, { 2, 26 } };
		int[][] b = { { 1, 5 }, { 2, 6 } };
		int[][] res = sub(a, b);
		p(res);

	}

	public static int[][] sub(int[][] a, int[][] b) {
		int res[][] = new int[a.length][a[0].length];
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				res[i][j] = a[i][j] - b[i][j];
			}
		}
		return res;
	}

	public static void p(int[][] a) {
		for (int i = 0; i < a.length; i++) {
			for (int j : a[i]) {
				System.out.print(j + " ");
			}
			System.out.println();
		}
	}
}
